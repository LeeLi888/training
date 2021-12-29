package com.amf.newsletter.model.listener;

import com.amf.newsletter.constants.ContentType;
import com.amf.newsletter.exception.NoSuchNewsletterException;
import com.amf.newsletter.model.Article;
import com.amf.newsletter.model.Newsletter;
import com.amf.newsletter.model.impl.NewsletterImpl;
import com.amf.newsletter.service.ArticleLocalService;
import com.amf.newsletter.service.NewsletterLocalService;
import com.amf.newsletter.service.exception.NodeNotExistException;
import com.amf.newsletter.service.persistence.ArticlePK;
import com.amf.newsletter.util.AmfDateUtil;
import com.amf.newsletter.util.NewsletterUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;

@Component(
    immediate = true,
    service = ModelListener.class
)
public class JournalArticleModelListener extends BaseModelListener<JournalArticle> {

    @Reference
    protected NewsletterLocalService newsletterLocalService;

    @Reference
    protected ArticleLocalService articleLocalService;

    @Override
    public void onBeforeCreate(JournalArticle journalArticle) throws ModelListenerException {
        System.out.println("onBeforeCreate: " + journalArticle.getArticleId());
        super.onBeforeCreate(journalArticle);
    }

    @Override
    public void onAfterCreate(JournalArticle journalArticle) throws ModelListenerException {
        System.out.println("onAfterCreate: " + journalArticle.getArticleId());
        super.onAfterCreate(journalArticle);
    }

    // validate the article's issue number exist.
    @Override
    public void onBeforeUpdate(JournalArticle before, JournalArticle after) throws ModelListenerException {
        System.out.println("onBeforeUpdate: " + after.getArticleId());

        try {
            Document document = after.getDocument();

            int issueNumber = NewsletterUtil.getIssueNumber(document);
            int contentType = NewsletterUtil.getContentType(document);

            // version=1 means new data
            double version = after.getVersion();
            if (version == 1) {
                Newsletter oldNewsletter = null;
                try {
                    oldNewsletter = newsletterLocalService.getNewsletter(issueNumber);
                } catch (NoSuchNewsletterException e) {
                    //nothing to do
                }

                if (contentType == ContentType.Newsletter) {
                    if (oldNewsletter != null) {
                        throw new ModelListenerException(String.format("The newsletter already exist.[%s]", issueNumber));
                    }
                } else if (contentType == ContentType.Article) {
                    if (oldNewsletter == null) {
                        throw new ModelListenerException(String.format("The newsletter not exist.[%s]", issueNumber));
                    }
                }
            }
        } catch (NodeNotExistException e) {
            // is not newsletter structure
            super.onBeforeUpdate(before, after);
            return;
        } catch (DocumentException e) {
            throw new ModelListenerException(e);
        } catch (PortalException e) {
            throw new ModelListenerException(e);
        }

        super.onBeforeUpdate(before, after);
    }

    // insert data to original table
    @Override
    public void onAfterUpdate(JournalArticle before, JournalArticle after) throws ModelListenerException {
        System.out.println("onAfterUpdate: " + after.getArticleId());

        try {
            Document document = after.getDocument();

            int issueNumber = NewsletterUtil.getIssueNumber(document);
            int contentType = NewsletterUtil.getContentType(document);

            // version=1 means new data
            double version = after.getVersion();
            //New
            if (version == 1) {
                if (contentType == ContentType.Newsletter) {
                    Newsletter newsletter = newsletterLocalService.createNewsletter(issueNumber);
                    newsletter.setTitle(after.getTitle());
                    newsletter.setDescription(after.getDescription());
                    newsletter.setIssueDate(new Date());
                    newsletter.setCreateDate(new Date());
                    newsletter.setModifiedDate(new Date());
                    newsletter.setJournalArticleId(after.getArticleId());
                    newsletterLocalService.addNewsletter(newsletter);

                } else if (contentType == ContentType.Article) {
                    //get order no
                    int order = 0;
                    {
                        List<Article> articles = articleLocalService.getArticlesByIssueNumber(issueNumber);
                        if (articles.size() == 0) {
                            order = 1;
                        } else {
                            order = articles.get(articles.size() - 1).getOrder() + 1;
                        }
                    }

                    Article article = articleLocalService.createArticle(new ArticlePK(issueNumber, order));
                    article.setTitle(after.getTitle());
                    article.setContent(NewsletterUtil.getContent(document));
                    article.setAuthor(String.valueOf(after.getUserId()));
                    article.setJournalArticleId(after.getArticleId());
                    articleLocalService.addArticle(article);

                    // update byline
                    Newsletter newsletter = newsletterLocalService.getNewsletter(issueNumber);
                    String byline = newsletter.getByline();
                    if (byline != null && !"".equals(byline)) {
                        byline += ",";
                    }
                    byline += article.getAuthor();
                    newsletter.setByline(byline);
                    newsletter.setModifiedDate(new Date());
                    newsletterLocalService.updateNewsletter(newsletter);
                }
            //update
            } else {
                if (contentType == ContentType.Newsletter) {
                    Newsletter newsletter = newsletterLocalService.getNewsletter(issueNumber);
                    newsletter.setTitle(after.getTitle());
                    newsletter.setDescription(after.getDescription());
                    newsletter.setModifiedDate(new Date());
                    newsletterLocalService.updateNewsletter(newsletter);

                } else if (contentType == ContentType.Article) {
                    Article article = articleLocalService.getArticleByJournalArticleId(after.getArticleId());

                    article.setTitle(after.getTitle());
                    article.setContent(NewsletterUtil.getContent(document));
                    article.setAuthor(String.valueOf(after.getUserId()));
                    articleLocalService.updateArticle(article);
                }
            }

        } catch (NodeNotExistException e) {
            // is not newsletter structure
            super.onBeforeUpdate(before, after);
            return;
        } catch (DocumentException e) {
            throw new ModelListenerException(e);
        } catch (PortalException e) {
            throw new ModelListenerException(e);
        }

        super.onBeforeUpdate(before, after);
    }

}

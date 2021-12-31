package com.amf.newsletter.search;

import com.amf.newsletter.model.Newsletter;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
        immediate = true,
        property = "indexer.class.name=com.amf.newsletter.model.Newsletter",
        service = ModelDocumentContributor.class
)
public class NewsletterModelDocumentContributor
        implements ModelDocumentContributor<Newsletter> {

    private static final Log logger = LogFactoryUtil.getLog(NewsletterModelDocumentContributor.class);

    @Override
    public void contribute(Document document, Newsletter newsletter) {
        document.addKeyword("issueNumber", newsletter.getIssueNumber());
//        for (Locale locale : LanguageUtil.getAvailableLocales()) {
//            String languageId = LocaleUtil.toLanguageId(locale);
//
//            document.addText(
//                    LocalizationUtil.getLocalizedName(Field.DESCRIPTION, languageId),
//                    newsletter.getDescription());
//            document.addText(
//                    LocalizationUtil.getLocalizedName(Field.TITLE, languageId),
//                    newsletter.getTitle());
//        }

        document.addText(Field.TITLE, newsletter.getTitle());
        document.addText(Field.DESCRIPTION, newsletter.getDescription());
    }

}
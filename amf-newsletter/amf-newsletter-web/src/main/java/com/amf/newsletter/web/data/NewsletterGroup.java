package com.amf.newsletter.web.data;

import com.amf.newsletter.model.Article;
import com.amf.newsletter.model.Newsletter;

import java.util.ArrayList;
import java.util.List;

public class NewsletterGroup {
    private Newsletter newsletter;
    private List<Article> articles;

    public Newsletter getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Newsletter newsletter) {
        this.newsletter = newsletter;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}

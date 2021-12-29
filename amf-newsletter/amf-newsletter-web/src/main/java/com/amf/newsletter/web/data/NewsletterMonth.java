package com.amf.newsletter.web.data;

import com.amf.newsletter.model.Newsletter;

import java.util.ArrayList;
import java.util.List;

public class NewsletterMonth {
    private int year;
    private int month;
    private List<NewsletterGroup> newsletterGroups;

    public NewsletterMonth(int year, int month) {
        this.year = year;
        this.month = month;
        newsletterGroups = new ArrayList<>();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public List<NewsletterGroup> getNewsletterGroups() {
        return newsletterGroups;
    }

    public void setNewsletterGroups(List<NewsletterGroup> newsletterGroups) {
        this.newsletterGroups = newsletterGroups;
    }

    public void addNewsletterGroup(NewsletterGroup data) {
        this.newsletterGroups.add(data);
    }
}

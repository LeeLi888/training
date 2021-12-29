package com.amf.newsletter.web.data;

import java.util.ArrayList;
import java.util.List;

public class NewsletterYear {

    private int year;

    private List<NewsletterMonth> newsletterMonths;

    public NewsletterYear(int year) {
        this.year = year;
        newsletterMonths = new ArrayList<>();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<NewsletterMonth> getNewsletterMonths() {
        return newsletterMonths;
    }

    public void setNewsletterMonths(List<NewsletterMonth> newsletterMonths) {
        this.newsletterMonths = newsletterMonths;
    }

    public void addNewsletterMonth(NewsletterMonth newsletterMonth) {
        this.newsletterMonths.add(newsletterMonth);
    }

}

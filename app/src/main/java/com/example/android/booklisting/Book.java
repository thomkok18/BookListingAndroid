package com.example.android.booklisting;

public class Book {
    private String title;
    private String subtitle;
    private String publishedDate;
    private String publisher;
    private String link;

    public Book(String mTitle, String mSubtitle, String mPublishedDate, String mPublisher, String mLink) {
        title = mTitle;
        subtitle = mSubtitle;
        publishedDate = mPublishedDate;
        publisher = mPublisher;
        link = mLink;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getLink() {
        return link;
    }
}
package com.example.android.booklisting;

public class Book {
    public String title;
    private String subtitle;
    private String publishedDate;
    private String publisher;

    public Book(String mTitle, String mSubtitle, String mPublishedDate, String mPublisher) {
        title = mTitle;
        subtitle = mSubtitle;
        publishedDate = mPublishedDate;
        publisher = mPublisher;
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
}
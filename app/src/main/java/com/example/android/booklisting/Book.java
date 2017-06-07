package com.example.android.booklisting;

public class Book {
    private String mTitle;
    private String mSubtitle;
    private String mPublishedDate;
    private String mPublisher;

    public Book(String title, String subtitle, String publishedDate, String publisher) {
        mTitle = title;
        mSubtitle = subtitle;
        mPublishedDate = publishedDate;
        mPublisher = publisher;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSubtitle() {
        return mSubtitle;
    }

    public String getPublishedDate() {
        return mPublishedDate;
    }

    public String getPublisher() {
        return mPublisher;
    }
}
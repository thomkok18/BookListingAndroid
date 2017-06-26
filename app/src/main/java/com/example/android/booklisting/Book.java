package com.example.android.booklisting;

public class Book {
    public String title;
    private String author;
    private String publishedDate;
    private String publisher;

    public Book(String mTitle, String mAuthor, String mPublishedDate, String mPublisher) {
        title = mTitle;
        author = mAuthor;
        publishedDate = mPublishedDate;
        publisher = mPublisher;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getPublisher() {
        return publisher;
    }
}
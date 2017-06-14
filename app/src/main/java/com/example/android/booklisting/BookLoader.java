package com.example.android.booklisting;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class BookLoader extends AsyncTaskLoader<List<Book>> {
    private String url;

    public BookLoader(Context context, String mUrl) {
        super(context);
        url = mUrl;
    }

    protected void onStartLoading() {
        forceLoad();
    }

    public List<Book> loadInBackground() {
        if (url == null) {
            return null;
        }
        List<Book> books = Utils.fetchBookData(url);
        return books;
    }
}
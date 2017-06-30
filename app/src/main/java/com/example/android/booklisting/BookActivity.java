package com.example.android.booklisting;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Loader;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends AppCompatActivity implements LoaderCallbacks<List<Book>> {
    private TextView emptyStateTextView;

    private static final String USGS_REQUEST_URL = "https://www.googleapis.com/books/v1/volumes?q=android&maxResults=20";

    private static final int BOOK_LOADER_ID = 1;

    private BookAdapter adapter;

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView bookListView = (ListView) findViewById(R.id.list);
        adapter = new BookAdapter(this, new ArrayList<Book>());
        bookListView.setAdapter(adapter);

        emptyStateTextView = (TextView) findViewById(R.id.empty_view);
        bookListView.setAdapter(adapter);

        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Book currentBook = adapter.getItem(position);
                Uri bookPublisher = Uri.parse(currentBook.getLink());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, bookPublisher);
                startActivity(websiteIntent);
            }
        });

        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.v("EditText", editText.getText().toString());
            }
        });

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(BOOK_LOADER_ID, null, this);
        } else {
            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);
            emptyStateTextView.setText("No internet connection");
        }
    }

    public Loader<List<Book>> onCreateLoader(int i, Bundle bundle) {
        Uri baseUri = Uri.parse(USGS_REQUEST_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        return new BookLoader(this, uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(Loader<List<Book>> loader, List<Book> books) {
        Log.i("BookActivity", String.valueOf(books.size()));
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);
        Book book = books.get(0);
        Log.i("BookActivity", book.getTitle());

        emptyStateTextView.setText("No books found.");
        adapter.clear();

        if (books != null && !books.isEmpty()) {
            Log.i("BookActivity", "books available");
            emptyStateTextView.setVisibility(View.GONE);
            adapter.addAll(books);
        }
    }

    public void onLoaderReset(Loader<List<Book>> loader) {
        adapter.clear();
    }
}
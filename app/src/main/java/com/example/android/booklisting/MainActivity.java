package com.example.android.booklisting;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String USGS_REQUEST_URL = "https://www.googleapis.com/books/v1/volumes?q=android&maxResults=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BookAsyncTask task = new BookAsyncTask();
        task.execute(USGS_REQUEST_URL);
    }

    private void updateUi(Book book) {
        TextView titleTextView = (TextView) findViewById(R.id.title);
        titleTextView.setText(book.title);
    }

    private class BookAsyncTask extends AsyncTask<String, Void, Book> {

        protected Book doInBackground(String... urls) {
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            Book result = Utils.fetchBookData(urls[0]);
            return result;
        }

        protected void onPostExecute(Book result) {
            if (result == null) {
                return;
            }
            updateUi(result);
        }
    }
}
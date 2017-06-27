package com.example.android.booklisting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, List<Book> books) {
        super(context, 0, books);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        Book book = getItem(position);

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        String title = book.getTitle();
        String subtitle = book.getSubtitle();
        String date = book.getPublishedDate();
        String publisher = book.getPublisher();

        // Find the TextView with view ID location
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.title);
        // Display the location of the current earthquake in that TextView
        primaryLocationView.setText(title);

        // Find the TextView with view ID location offset
        TextView subtitleView = (TextView) listItemView.findViewById(R.id.subtitle);
        // Display the location offset of the current earthquake in that TextView
        subtitleView.setText(subtitle);

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.publishedDate);
        // Display the date of the current earthquake in that TextView
        dateView.setText(date);

        // Find the TextView with view ID date
        TextView publisherView = (TextView) listItemView.findViewById(R.id.publisher);
        // Display the date of the current earthquake in that TextView
        publisherView.setText(publisher);

        return listItemView;
    }
}
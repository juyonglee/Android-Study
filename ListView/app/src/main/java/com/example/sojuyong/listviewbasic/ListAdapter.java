package com.example.sojuyong.listviewbasic;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<Movie> {

    private int resource;

    public ListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.resource = resource;
    }

    @Override
    public void add(@Nullable Movie object) {
        this.add(object);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.getCount();
    }

    @Nullable
    @Override
    public Movie getItem(int position) {
        return this.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, parent, false);
        }
        Movie data = getItem(position);
        //  View ID
        ImageView posterView = convertView.findViewById(R.id.posterView);
        TextView movieNameTextView = convertView.findViewById(R.id.movieNameTextView);
        TextView releaseDateTextView = convertView.findViewById(R.id.releaseDateTextView);
        TextView genreTextView = convertView.findViewById(R.id.genreTextView);
        TextView actorsTextView = convertView.findViewById(R.id.actorsTextView);
        //  View Setting
        posterView.setImageResource(data.getPoster());
        movieNameTextView.setText(data.getName());
        releaseDateTextView.setText(data.getReleaseDate());
        genreTextView.setText(data.getGenre());
        actorsTextView.setText(data.getActors());
        return convertView;
    }
}

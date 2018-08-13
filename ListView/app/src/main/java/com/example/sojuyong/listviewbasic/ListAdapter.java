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

import java.util.List;

public class ListAdapter extends ArrayAdapter<Movie> {

    private Context context;
    private int resource;
    private List<Movie> objects;

    public ListAdapter(@NonNull Context context, int resource, @NonNull List<Movie> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Nullable
    @Override
    public Movie getItem(int position) {
        return objects.get(position);
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

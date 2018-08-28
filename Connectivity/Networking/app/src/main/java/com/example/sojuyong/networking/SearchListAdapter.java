package com.example.sojuyong.networking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SearchListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> smallLinks;
    private ArrayList<String> imageLinks;

    public SearchListAdapter(Context context) {
        this.context = context;
        smallLinks = new ArrayList<>();
        imageLinks = new ArrayList<>();

    }

    @Override
    public int getCount() {
        return smallLinks.size();
    }

    @Override
    public Object getItem(int i) {
        return imageLinks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_view, viewGroup, false);
        }
        ImageView itemImageView = view.findViewById(R.id.searchImageView);
        Glide.with(context).load(smallLinks.get(i)).into(itemImageView);
        return view;
    }

    public void imageLinkAdd(String smallLink, String largeLink) {
        smallLinks.add(smallLink);
        imageLinks.add(largeLink);
        notifyDataSetChanged();
    }

    public void imageLinkClear() {
        smallLinks.clear();
        imageLinks.clear();
        notifyDataSetChanged();
    }
}

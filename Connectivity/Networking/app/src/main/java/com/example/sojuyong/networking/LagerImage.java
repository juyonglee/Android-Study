package com.example.sojuyong.networking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class LagerImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lager_image);
        Intent intent = getIntent();
        String linkImage = intent.getStringExtra("IMAGE");
        ImageView imageView = findViewById(R.id.LargeImageView);
        Glide.with(this).load(linkImage).into(imageView);
    }
}

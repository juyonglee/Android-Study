package com.example.sojuyong.listviewbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView movieList = findViewById(R.id.movieListView);
        ArrayList<Movie> dataSet = new ArrayList<>();
        dataSet.add(new Movie(R.drawable.the_spy_gone_north, "공작", "장르: 드라마", "배우: 황정민, 조진웅, 이성민, 주지훈", "2018.08.08"));
        dataSet.add(new Movie(R.drawable.along_with_the_gods, "신과함께 인과 연", "장르: 드라마, 환타지", "배우: 하정우, 주지훈, 김향기, 마동석, 김동욱, 이정재", "2018.08.01"));
        dataSet.add(new Movie(R.drawable.mamma_mia, "맘마미아!2", "장르: 뮤지컬, 로맨스, 멜로", "배우: 아만다 사이프리드, 릴리 제임스, 메릴 스트립, 피어스 브로스넌, 제레미 어바인, 콜린 퍼스, 휴 스키너, 스텔란", "2018.08.08"));
        ListAdapter adapter = new ListAdapter(this, R.layout.list_item_layout, dataSet);
        movieList.setAdapter(adapter);
    }

}

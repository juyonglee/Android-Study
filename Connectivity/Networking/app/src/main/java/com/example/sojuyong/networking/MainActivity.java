package com.example.sojuyong.networking;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String clientID = "OPUPgHkKYqOaNzMpJ2mu";
    private String clientSecret = "0x21jI5Mah";
    private String requestURL = "https://openapi.naver.com/v1/search/image?display=20&sort=sim&query=";

    private EditText queryInput;
    private ListView searchListView;
    private SearchListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queryInput = findViewById(R.id.queryInput);
        searchListView = findViewById(R.id.searchList);
        adapter = new SearchListAdapter(this);
        searchListView.setAdapter(adapter);
        searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), LagerImage.class);
                intent.putExtra("IMAGE", (String) adapter.getItem(i));
                startActivity(intent);
            }
        });
    }

    public void searchBtnAction(View view) {
        adapter.imageLinkClear();
        searchAction(queryInput.getText().toString());
    }

    public void searchAction(String userInput) {
        //  Request를 넣어둘 Queue를 생성
        RequestQueue queue = Volley.newRequestQueue(this);
        //  Request 생성
        JsonObjectRequest searchRequest = new JsonObjectRequest(Request.Method.GET, requestURL+userInput, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray items = response.getJSONArray("items");
                    for(int i=0; i<items.length(); i++) {
                        JSONObject eachItem = items.getJSONObject(i);
                        String title = eachItem.getString("title");
                        String thumbnail = eachItem.getString("thumbnail");
                        String link = eachItem.getString("link");
                        adapter.imageLinkAdd(thumbnail, link);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TEST", error.toString());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> naverHeaderInfo = new HashMap<>();
                naverHeaderInfo.put("X-Naver-Client-Id", clientID);
                naverHeaderInfo.put("X-Naver-Client-Secret", clientSecret);
                return naverHeaderInfo;
            }
        };

        queue.add(searchRequest);
    }
}

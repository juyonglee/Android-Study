package com.example.sojuyong.volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText userInput = findViewById(R.id.InputID);
        Button btn = findViewById(R.id.searchBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  1. Volley의 Request Queue를 생성
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                //  2.  Request Url을 설정
                String url = "https://api.github.com/users/" + userInput.getText().toString() +"/repos";
                //  3. Request 생성
                JsonArrayRequest jsonRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
//                Log.d("RESULT", response.toString());
                        for(int i=0; i<response.length(); i++) {
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                String name = obj.getString("name");
                                Log.d("RESULT", name);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                queue.add(jsonRequest);
            }
        });
    }
}

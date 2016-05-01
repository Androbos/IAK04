package com.tommyputranto.iak04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.tommyputranto.iak04.Api.Api;
import com.tommyputranto.iak04.model.Data;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    String API = "http://api.themoviedb.org/3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView)findViewById(R.id.text);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(API).build();
        Api api = restAdapter.create(Api.class);
       api.getFeed(new Callback<Data>() {
           @Override
           public void success(Data data, Response response) {
               Log.i("tesfds", String.valueOf(data.getPage()));
               for (int i = 0; i < data.getResults().size(); i++){
                   Log.i("tes", data.getResults().get(i).getTitle());
                   Log.i("gambar", "http://image.tmdb.org/t/p/w185/"+
                           data.getResults().get(i).getPosterPath());
               }
               mTextView.setText(String.valueOf(data.getPage()));
           }

           @Override
           public void failure(RetrofitError error) {

           }
       });
    }
}

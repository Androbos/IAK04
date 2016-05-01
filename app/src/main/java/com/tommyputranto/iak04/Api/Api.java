package com.tommyputranto.iak04.Api;

import com.tommyputranto.iak04.model.Data;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by tommy on 5/1/16.
 */
public interface Api {
    @GET("/movie/popular?api_key=YOUR KEY")
    public void getFeed(Callback<Data> response);
}

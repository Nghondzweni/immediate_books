package com.example.immediatebooks;

import com.example.immediatebooks.model.Feed;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleBooksApi {

    @GET("volumes")
    Call<Feed> getBooks(@Query("q") String title);
}

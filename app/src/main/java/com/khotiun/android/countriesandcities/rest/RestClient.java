package com.khotiun.android.countriesandcities.rest;

import android.support.annotation.NonNull;

import com.khotiun.android.countriesandcities.rest.api.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hotun on 13.10.2017.
 */

public class RestClient {

    //constant BASE_URL
   private static final String BASE_URL = "https://raw.githubusercontent.com/";

    //Get Retrofit Instance
    @NonNull
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    //Get ApiService
    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }
}

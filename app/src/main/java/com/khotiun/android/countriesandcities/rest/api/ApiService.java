package com.khotiun.android.countriesandcities.rest.api;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hotun on 05.10.2017.
 */

public interface ApiService {

    @GET(ApiMethods.COUNTRIES_GET)
    Call<JsonObject> get();
}

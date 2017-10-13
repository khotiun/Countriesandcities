package com.khotiun.android.countriesandcities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.khotiun.android.countriesandcities.rest.RestClient;
import com.khotiun.android.countriesandcities.rest.api.ApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private List<Country> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiService api = RestClient.getApiService();
        Call<JsonObject> call = api.get();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                JsonObject object = response.body();

                for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
//                    List<String> citiesList = new ArrayList<>();
//                    Log.d(TAG, entry.getKey());
                    RealmList<RealmString> citiesList = new RealmList<RealmString>();
                    String name = entry.getKey();
                    JsonArray array = entry.getValue().getAsJsonArray();
                    for (JsonElement cityJson : array) {
                        RealmString realmString = new RealmString();
                        realmString.setString(cityJson.getAsString());
                        citiesList.add(realmString);
                    }
                    Country country = new Country();
                    country.setName(name);
                    country.setCities(citiesList);
                    mList.add(country);
//                    savetoDb(country);

                }
                Log.d(TAG, mList.get(2).toString());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    //for save data
    public void savetoDb(final RealmObject item) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> realm.copyToRealmOrUpdate(item));
    }

//    public Callable<List<Country>> getListFromRealm() {
//        return () -> {
//            String[] sortFields = {"name"};
//            Sort[] sortOrder = {Sort.DESCENDING};
//            Realm realm = Realm.getDefaultInstance();
//            RealmResults<Country> realmResults = realm.where(Country.class)
//                    .findAllSorted(sortFields, sortOrder);
//            return realm.copyFromRealm(realmResults);
//        };
//    }
}

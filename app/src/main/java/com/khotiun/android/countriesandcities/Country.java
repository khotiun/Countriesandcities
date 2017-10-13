package com.khotiun.android.countriesandcities;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by hotun on 13.10.2017.
 */

public class Country extends RealmObject {

    private String name;

    private RealmList<RealmString> cities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealmList<RealmString> getCities() {
        return cities;
    }

    public void setCities(RealmList<RealmString> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", cities=" + cities +
                '}';
    }
}

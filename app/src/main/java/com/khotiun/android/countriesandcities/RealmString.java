package com.khotiun.android.countriesandcities;

import io.realm.RealmObject;

/**
 * Created by hotun on 13.10.2017.
 */

public class RealmString extends RealmObject {
    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}

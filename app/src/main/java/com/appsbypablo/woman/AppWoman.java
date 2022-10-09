package com.appsbypablo.woman;

import android.app.Application;
import android.content.SharedPreferences;

import com.huawei.hms.ads.HwAds;
import com.yariksoffice.lingver.Lingver;

public class AppWoman extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        PreferenceUtils preferenceUtils = new PreferenceUtils(this);
        String locale = preferenceUtils.getString("locale", "");

        if (locale.isEmpty()) {
            locale = "system";
            SharedPreferences.Editor editor = preferenceUtils.edit();
            editor.putString("locale", "system");
            editor.apply();
        }

        Lingver.init(this, "en");
        if (locale.equals("system")) {
            Lingver.getInstance().setFollowSystemLocale(this);
        } else {
            Lingver.getInstance().setLocale(this, locale);
        }

        HwAds.init(this);
    }
}

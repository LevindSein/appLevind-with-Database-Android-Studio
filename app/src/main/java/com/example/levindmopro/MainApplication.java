package com.example.levindmopro;

import android.app.Application;
import android.content.Context;

import com.example.levindmopro.helper.LocaleHelper;

public class MainApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base,"in"));
    }
}

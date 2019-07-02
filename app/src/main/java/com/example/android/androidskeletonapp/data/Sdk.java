package com.example.android.androidskeletonapp.data;

import android.content.Context;
import android.content.pm.PackageInfo;

import com.example.android.androidskeletonapp.R;

import org.hisp.dhis.android.core.D2;
import org.hisp.dhis.android.core.d2manager.D2Configuration;
import org.hisp.dhis.android.core.d2manager.D2Manager;

import io.reactivex.Single;

public class Sdk {

    public static D2Configuration getD2Configuration(Context context) {


        // TODO Add configuration
        D2Configuration configuration = D2Configuration.builder()
                .appName(context.getString(R.string.app_name)).appVersion("0.0.1")
                .context(context)
                .readTimeoutInSeconds(30).connectTimeoutInSeconds(30).writeTimeoutInSeconds(30)
                .build();




        return configuration;
    }
}
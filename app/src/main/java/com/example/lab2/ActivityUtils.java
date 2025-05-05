package com.example.lab2;

import android.content.Context;
import android.content.Intent;

public class ActivityUtils {
    public static void switchActivity(Context fromContext, Class<?> toActivity) {
        Intent intent = new Intent(fromContext, toActivity);
        fromContext.startActivity(intent);
    }

    public static void switchActivityWithData(Context fromContext, Class<?> toActivity, String key, String value) {
        Intent intent = new Intent(fromContext, toActivity);
        intent.putExtra(key, value);
        fromContext.startActivity(intent);
    }
}
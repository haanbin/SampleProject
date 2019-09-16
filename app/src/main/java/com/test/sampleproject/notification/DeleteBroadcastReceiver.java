package com.test.sampleproject.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.orhanobut.hawk.Hawk;

public class DeleteBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Hawk.put("16_COUNT", 0);
        Log.e("123123", "onReceive: 123123213213123");

    }
}

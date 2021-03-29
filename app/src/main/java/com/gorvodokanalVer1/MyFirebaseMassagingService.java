package com.gorvodokanalVer1;

import android.util.Log;

import androidx.annotation.NonNull;
import com.google.firebase.messaging.FirebaseMessagingService;


public class MyFirebaseMassagingService extends FirebaseMessagingService {

 public MyFirebaseMassagingService(){
         super();
 }
    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);

        Log.e("test", "token is:"+ s);
    }

}

package com.gorvodokanalVer1;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static android.content.ContentValues.TAG;


public class MyFirebaseMassagingService extends FirebaseMessagingService {

 public MyFirebaseMassagingService(){
         super();
 }
    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        FirebaseMessaging.getInstance().subscribeToTopic("user.5")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {


                        Toast.makeText(MyFirebaseMassagingService.this, "subcscrube", Toast.LENGTH_SHORT).show();
                    }
                });

        Log.e("test", "token is:"+ s);
    }


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //  super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());

    }

}

package com.gorvodokanalVer1;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.gorvodokanalVer1.meters.activity.MainActivity;

import static android.content.ContentValues.TAG;
import static android.provider.Settings.System.getString;

public class MyFirebaseMassagingService extends FirebaseMessagingService {

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);

        Log.e("test", "token is:"+ s);
    }

}

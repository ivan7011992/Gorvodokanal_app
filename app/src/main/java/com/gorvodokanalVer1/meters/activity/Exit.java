package com.gorvodokanalVer1.meters.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gorvodokanalVer1.R;
import com.gorvodokanalVer1.meters.model.UserModel;
import com.gorvodokanalVer1.meters.net.RequestQueueSingleton;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;


public class Exit extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Bundle bundle = new Bundle();
       UserModel.clearInstance();

        RequestQueueSingleton.getInstance(getContext());
        CookieManager cookieManager = (CookieManager) CookieHandler.getDefault();
        CookieStore cookieStore = cookieManager.getCookieStore();
        cookieStore.removeAll();

        Intent intent = new Intent(getContext(),MainActivity.class);
        startActivity(intent);


        return inflater.inflate(R.layout.fragment_exit, container, false);

    }
}
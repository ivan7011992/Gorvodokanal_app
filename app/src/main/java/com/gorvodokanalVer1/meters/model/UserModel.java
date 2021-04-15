package com.gorvodokanalVer1.meters.model;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.gorvodokanalVer1.MyFirebaseMassagingService;
import com.gorvodokanalVer1.meters.activity.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class UserModel {
    private static UserModel instance;

    private String login;
    private Map<Integer, String> ls;
    private int countSupportItems;
    private boolean status;
    private String email;
    private int userId;
    private int statusAuth = 0;

    public void setStatusAuth(int statusAuth) {
        this.statusAuth = statusAuth;
    }

    public int getStatusAuth() {
        return statusAuth;
    }

    private UserModel(String login, Map<Integer, String> ls, int countSupportItems, boolean status, String email, int userId) {
        this.login = login;
        this.ls = ls;
        this.countSupportItems = countSupportItems;
        this.status = status;
        this.email = email;
        this.userId = userId;
        subcribePush();
    }

    public void removeLs(Integer lsUser) {
        ls.remove(lsUser);
    }

    public void addLs(Integer lsUser, String login) {
        ls.put(lsUser, login);
    }

    public String getLogin() {
        return login;
    }

    public int getCountSupportItems() {
        return countSupportItems;
    }

    public Map<Integer, String> getLs() {
        return ls;
    }

    public boolean isStatus() {
        return status;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static UserModel getInstance() {
        return instance;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public static void createInstance(String login, Map<Integer, String> ls, int countSupportItems, boolean status, String email, int userId) {
        instance = new UserModel(login, ls, countSupportItems, status, email, userId);
    }

    public static void clearInstance() {
        instance = null;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static void createInstanceFromJson(JSONObject json) throws JSONException {
        LinkedHashMap<Integer, String> ls = new LinkedHashMap<>();
        JSONArray lsList = json.getJSONArray("ls");
        Integer countSupportItems = Integer.parseInt(json.getString("SupportItems"));
        String login = json.getString("login");

        boolean status = json.getBoolean("statusConfirmMail");
        String email = json.getString("email");
        int userId = json.getInt("id");
        for (int i = 0; i < lsList.length(); i++) {
            JSONObject currentLs = (JSONObject) lsList.get(i);
            if (currentLs.getString("LOGIN").equals(login)) {
                ls.put(Integer.parseInt(currentLs.getString("ID")), currentLs.getString("LOGIN"));
            }
        }
        for (int i = 0; i < lsList.length(); i++) {
            JSONObject currentLs = (JSONObject) lsList.get(i);
            if (!currentLs.getString("LOGIN").equals(login)) {
                ls.put(Integer.parseInt(currentLs.getString("ID")), currentLs.getString("LOGIN"));
            }
        }

        UserModel.createInstance(login, ls, countSupportItems, status, email, userId);
    }

    public void clearLs() {
        this.ls = new LinkedHashMap<>();
    }

    private void subcribePush() {

      //  FirebaseMessaging.getInstance().unsubscribeFromTopic("user." + "341750");
        FirebaseMessaging.getInstance().subscribeToTopic("user." + getUserId())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {


                        Log.d("push", "subscrabe success");
                    }
                });
    }

    ;
}

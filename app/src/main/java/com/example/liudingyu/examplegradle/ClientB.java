package com.example.liudingyu.examplegradle;

import android.util.Log;

public class ClientB extends BaseClient {

    public void printName() {
        Log.d("d.d", "ClientB " + sName);
    }

    private static volatile ClientB INSTANCE;

    public static ClientB getInstance() {
        if (INSTANCE == null) {
            synchronized (ClientB.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ClientB();
                }
            }
        }
        return INSTANCE;
    }
}

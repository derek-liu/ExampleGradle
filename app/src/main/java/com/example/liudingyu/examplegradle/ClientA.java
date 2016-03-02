package com.example.liudingyu.examplegradle;

import android.util.Log;

public class ClientA extends BaseClient {

    public void printName() {
        Log.d("d.d", "ClientA " + sName);
    }

    private static volatile  ClientA INSTANCE;

    public static ClientA getInstance() {
        if (INSTANCE == null) {
            synchronized (ClientA.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ClientA();
                }
            }
        }
        return INSTANCE;
    }
}

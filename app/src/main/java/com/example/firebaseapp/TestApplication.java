package com.example.firebaseapp;

import android.app.Application;

import com.google.firebase.FirebaseApp;

class TestApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Mock FirebaseApp initialization here if needed
    }
}
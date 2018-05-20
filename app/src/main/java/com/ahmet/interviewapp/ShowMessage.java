package com.ahmet.interviewapp;

import android.app.Activity;
import android.support.v7.app.AlertDialog;

public class ShowMessage {

    public ShowMessage() {
    }

    public void show(Activity activity, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}

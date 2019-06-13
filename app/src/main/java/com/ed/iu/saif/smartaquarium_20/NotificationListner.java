package com.ed.iu.saif.smartaquarium_20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NotificationListner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Write a message to the database

        setContentView(R.layout.activity_notification_listner);
        Toast.makeText(this, "ALARAMMM", Toast.LENGTH_SHORT).show();
    }
}

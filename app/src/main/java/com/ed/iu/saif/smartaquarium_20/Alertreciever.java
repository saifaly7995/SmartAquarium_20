package com.ed.iu.saif.smartaquarium_20;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Alertreciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Broad Cast Reciever Done", Toast.LENGTH_SHORT).show();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("FEED");

        myRef.setValue(1);


        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(5000);
                    myRef.setValue("0");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();


        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);
    }
}

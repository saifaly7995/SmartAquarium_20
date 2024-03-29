package com.ed.iu.saif.smartaquarium_20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import me.itangqi.waveloadingview.WaveLoadingView;

public class waterlevel extends AppCompatActivity {

    WaveLoadingView waveLoadingView;
    EditText editText;
    Button button;
    SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterlevel);


        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("WATERLEVEL");
        waveLoadingView=findViewById(R.id.waveLoading);
        waveLoadingView.setProgressValue(0);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                waveLoadingView.setProgressValue(70);
                waveLoadingView.setCenterTitle(84+"%");

                Toast.makeText(waterlevel.this, ""+value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(waterlevel.this, ""+error, Toast.LENGTH_SHORT).show();
            }
        });




    }
}

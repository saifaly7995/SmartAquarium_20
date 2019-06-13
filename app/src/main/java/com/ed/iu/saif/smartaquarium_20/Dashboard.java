package com.ed.iu.saif.smartaquarium_20;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Dashboard extends AppCompatActivity {

    int r,g,b;
    Bitmap bitmap;
    CardView ledListner,cvfeed,cvwaterlevel,temperature,ph,live;
    ColorPickerView colorpickerr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

//        ledListner=(CardView)findViewById(R.id.ledlistner);
        cvwaterlevel=(CardView)findViewById(R.id.btnwaterlevel);
        cvfeed=(CardView)findViewById(R.id.cvfeed);

        live=(CardView)findViewById(R.id.live);
        temperature=(CardView)findViewById(R.id.tempeature);
        ph=(CardView)findViewById(R.id.ph);

        live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= getPackageManager().getLaunchIntentForPackage("com.macrovideo.v380s");
                startActivity(intent);
            }
        });

        ph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Dashboard.this,phlevel.class);
                startActivity(intent);
            }
        });

        temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Dashboard.this,Temperature.class);
                startActivity(intent);
            }
        });


        cvwaterlevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Dashboard.this,waterlevel.class);
                startActivity(intent);
            }
        });
        cvfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Dashboard.this,feedingSchedule.class);

                startActivity(intent);

                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");

                myRef.setValue("Hello, World!");

                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        String value = dataSnapshot.getValue(String.class);
                        Toast.makeText(Dashboard.this, "value is : "+value, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Toast.makeText(Dashboard.this, ""+error, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


//        ledListner.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(Dashboard.this,LEDlistener.class);
//                startActivity(intent);
//
//            }
//        });

    }

//    public void openDialog()
//    {
//        ColorPickerDialogBuilder
//                .with(this)
//                .setTitle("Choose color")
//                .initialColor(Color.blue(1))
//                .density(12)
//                .setOnColorSelectedListener(new OnColorSelectedListener() {
//                    @Override
//                    public void onColorSelected(int selectedColor) {
//
//                        r=Color.red(selectedColor);
//                        b=Color.blue(selectedColor);
//                        g=Color.green(selectedColor);
//
//
//                        Toast.makeText(Dashboard.this, "R G B :  "+ r +"  "+g +"  "+ b, Toast.LENGTH_SHORT).show();
//
//                    }
//                })
//                .setPositiveButton("set", new ColorPickerClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
//
//                    }
//                })
//                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                    }
//                })
//                .build().show();
//    }
}


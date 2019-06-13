package com.ed.iu.saif.smartaquarium_20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MotionEvent;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LEDlistener extends AppCompatActivity {

    CardView btnred,btngreen,btnblue,btnwhite,btndeeporange,btnlightgreen,btnlightblue,btnorange,btncyan,btnmargenda,btnyellow,btnlightb,btnpink,btnlime,btnseagreen,btnsmooth,btnfade,btnstrode,btnflash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ledlistener);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("LIGHT");
        btnred=findViewById(R.id.btnred);
        btngreen=findViewById(R.id.btngreen);
        btnblue=findViewById(R.id.btnblue);
        btnwhite=findViewById(R.id.btnwhite);
        btndeeporange=findViewById(R.id.btndeeporange);
        btnlightgreen=findViewById(R.id.btnlightgreen);
        btnlightblue=findViewById(R.id.btnlightblue);
        btnorange=findViewById(R.id.btnorange);
        btncyan=findViewById(R.id.btncyan);
        btnmargenda=findViewById(R.id.btnmargenda);
        btnyellow=findViewById(R.id.btnyellow);
        btnlightb=findViewById(R.id.btnlightb);
        btnpink=findViewById(R.id.btnpink);
        btnlime=findViewById(R.id.btnlime);
        btnseagreen=findViewById(R.id.btnseagreen);
        btnsmooth=findViewById(R.id.btnsmooth);
        btnfade=findViewById(R.id.btnfade);
        btnstrode=findViewById(R.id.btnstrobe);
        btnflash=findViewById(R.id.btnflash);


        btnred.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    myRef.setValue(1);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
//                    myRef.setValue(0);
                }
                return true;
            }
        });

        btngreen.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    myRef.setValue(2);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
//                    myRef.setValue(0);
                }
                return true;
            }
        });

        btnblue.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    myRef.setValue(3);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
//                    myRef.setValue(0);
                }
                return true;
            }
        });

        btnwhite.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    myRef.setValue(4);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
//                    myRef.setValue(0);
                }
                return true;
            }
        });

        btndeeporange.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    myRef.setValue(5);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
//                    myRef.setValue(0);
                }
                return true;
            }
        });

        btnlightgreen.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    myRef.setValue(6);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
//                    myRef.setValue(0);
                }
                return true;
            }
        });

        btnlightblue.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    myRef.setValue(7);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
//                    myRef.setValue(0);
                }
                return true;
            }
        });

        btnorange.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    myRef.setValue(8);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
//                    myRef.setValue(0);
                }
                return true;
            }
        });

        btncyan.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    myRef.setValue(9);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
//                    myRef.setValue(0);
                }
                return true;
            }
        });

        btnmargenda.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    myRef.setValue(10);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
//                    myRef.setValue(0);
                }
                return true;
            }
        });

        btnyellow.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    myRef.setValue(11);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
//                    myRef.setValue(0);
                }
                return true;
            }
        });

        btnlightb.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    myRef.setValue(12);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
//                    myRef.setValue(0);
                }
                return true;
            }
        });

        btnpink.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    myRef.setValue(13);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
//                    myRef.setValue(0);
                }
                return true;
            }
        });

        btnlime.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    myRef.setValue(14);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
//                    myRef.setValue(0);
                }
                return true;
            }
        });

        btnseagreen.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    myRef.setValue(15);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
//                    myRef.setValue(0);
                }
                return true;
            }
        });





    }
}

package com.ed.iu.saif.smartaquarium_20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
                                                                                                        
    EditText dt_email;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final String n=4+"";

        dt_email=(EditText)findViewById(R.id.et_email);
        btn=(Button)findViewById(R.id.btn_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//            dt_email.setText(("000" + n).substring(n.length()));
                if (dt_email.getText().toString().equals("5653"))
                {
                    Intent i = new Intent(Login.this,Dashboard.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(Login.this, "Invslid User", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

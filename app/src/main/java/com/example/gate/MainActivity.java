package com.example.gate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.gate.R;

public class MainActivity extends AppCompatActivity {

    EditText adEmail,adPassword;
    TextView adLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adEmail=(EditText)findViewById(R.id.email);
        adPassword=(EditText)findViewById(R.id.password);
        adLogin=findViewById(R.id.login);

        adLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!((TextUtils.isEmpty(adEmail.getText().toString()))||(TextUtils.isEmpty(adPassword.getText().toString())))){
                    if (adEmail.getText().toString().equals("projectcollege50@gmail.com")&&adPassword.getText().toString().equals("AdminPass50")){
                        Intent intent=new Intent(MainActivity.this,Dashboard.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Please enter all Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
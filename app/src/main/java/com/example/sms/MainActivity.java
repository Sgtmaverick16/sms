package com.example.sms;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b;
    EditText e;
    EditText e1;
    String s;
    String s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.button);
        e = findViewById(R.id.editTextTextPersonName);
        e1 = findViewById(R.id.editTextTextPersonName2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s = e.getText().toString();
                s2 = e1.getText().toString();
                SmsManager sm = SmsManager.getDefault();
                sm.sendTextMessage(s,null,s2,null,null);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.message,menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void method(MenuItem item) {
        Intent in  = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(in);
    }

    public void happy(MenuItem item) {
        Toast.makeText(this, "Settings bro", Toast.LENGTH_SHORT).show();
    }

    public void item(MenuItem item) {
        AlertDialog.Builder ar = new AlertDialog.Builder(MainActivity.this);
        ar.setTitle("Superb day!");
        ar.setIcon(android.R.drawable.ic_media_play);
        ar.setPositiveButton("Exactly!!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Nice!!", Toast.LENGTH_SHORT).show();
            }
        });
        ar.setMessage("Awesome Learning!");
        ar.show();
    }
}
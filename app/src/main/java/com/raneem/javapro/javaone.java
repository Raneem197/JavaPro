package com.raneem.javapro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;



public class javaone extends AppCompatActivity implements View.OnClickListener {
    Button slide,back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javaone);
   getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        slide = (Button) findViewById(R.id.slide);
        slide.setOnClickListener(this);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);




    }

    public void onClick(View v) {


        if (v.getId() == R.id.slide) {
            Intent intent = new Intent(getApplicationContext(), listofslides.class);
            startActivity(intent);
        }
        else
       if (v.getId() == R.id.back) {
            Intent intent = new Intent(javaone.this, LogIn.class);
            startActivity(intent);
        }
    }

}
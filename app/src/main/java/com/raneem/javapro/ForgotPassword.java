package com.raneem.javapro;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;




public class ForgotPassword extends AppCompatActivity {
     EditText editEmail;
    Button send_pass;
 FirebaseAuth mFirebaseAuth;
    String email2 = editEmail.getText().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        mFirebaseAuth = FirebaseAuth.getInstance();
        editEmail=(EditText)findViewById(R.id.editEmail_2);
        send_pass = (Button) findViewById(R.id.send_pass);
 }
    public void Send_Pass(View view) {




   mFirebaseAuth.sendPasswordResetEmail(email2)
    .addOnCompleteListener(this, new OnCompleteListener<Void>() {
     @Override
    public void onComplete(@NonNull Task<Void> task) {
     if (task.isSuccessful()) {
   Toast.makeText(getApplicationContext(), "Send password your email", Toast.LENGTH_SHORT).show();
    finish();
 }
     else {

    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
 }
 }
                    });}


}
package com.raneem.javapro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogIn extends AppCompatActivity {
    TextView notuser;
    EditText email,password;;
    Button login;
    TextView forgotPassword_textButton;
    FirebaseAuth mFirebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mFirebaseAuth = FirebaseAuth.getInstance();

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.button3);
        forgotPassword_textButton = (TextView) findViewById(R.id.texetButton);
        notuser = (TextView) findViewById(R.id.textView6);


    }

    public void RegisterPage(View view){


        Intent register=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(register);
    }

    public void Login(View view){
    String uEmail=email.getText().toString();
    String uPassword=forgotPassword_textButton.getText().toString();
    mFirebaseAuth.signInWithEmailAndPassword(uEmail, uPassword)
    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
    if (task.isSuccessful()) {
    // Sign in success, update UI with the signed-in user's information
    Log.d("my_stor", "createUserWithEmail:success");
     FirebaseUser user = mFirebaseAuth.getCurrentUser();
      Toast.makeText(getApplicationContext(),"You've logged in successfully",Toast.LENGTH_SHORT).show();
    }
    else {
      // If sign in fails, display a message to the user.
     Log.w("my_stor", "createUserWithEmail:failure", task.getException());
       Toast.makeText(getApplicationContext(),"login failed.\nMake sure you entered valid email and password",Toast.LENGTH_SHORT).show();
  }
 }
    });


    }


public void Forgot_Password(View view){

    Intent forgot_pass=new Intent(getApplicationContext(),ForgotPassword.class);
    startActivity(forgot_pass);

}


}



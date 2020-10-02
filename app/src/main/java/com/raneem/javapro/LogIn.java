package com.raneem.javapro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class LogIn extends AppCompatActivity {
    TextView notuser;
    EditText email,password;;
    Button login;
    TextView forgotPassword_textButton;
    FirebaseAuth mFirebaseAuth;
    DatabaseReference mDatabase;
    StorageReference storageRef;
    FirebaseDatabase firebaseDatabase;
    slide ss;


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
        storageRef= FirebaseStorage.getInstance().getReference();
        firebaseDatabase = FirebaseDatabase.getInstance();





    }

    public void RegisterPage(View view){


        Intent register=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(register);
    }

    public void Login(View view){
    String uEmail=email.getText().toString();
    String uPassword=password.getText().toString();
    mFirebaseAuth.signInWithEmailAndPassword(uEmail, uPassword)
    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
    if (task.isSuccessful()) {
        Intent intent = new Intent(getApplicationContext(), courses.class);
        startActivity(intent);
       /* slide s=new slide("title", "fipath");

        slide s1=new slide("Introduction", "https://firebasestorage.googleapis.com/v0/b/javapro-6e07e.appspot.com/o/upload%2F%20Introduction.pdf?alt=media&token=d6ddf8f4-04a1-4a9d-ad2e-ddafa3f0c3a5");
        slide s2=new slide("JavaBasics(I)", "https://firebasestorage.googleapis.com/v0/b/javapro-6e07e.appspot.com/o/upload%2FJavaBasics%20(I).pdf?alt=media&token=55a8db1e-3452-4698-a187-e509b1aea5fe");

        firebaseDatabase.getReference("javaoneslide").push().setValue(s1);
        *///firebaseDatabase.getReference("javaoneslide").push().setValue(s2);





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



package com.raneem.javapro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class courses extends AppCompatActivity {
Button jv1;
    StorageReference storageRef;
    FirebaseDatabase firebaseDatabase;
    slide ss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

    jv1=(Button)findViewById(R.id.jv1);

        storageRef= FirebaseStorage.getInstance().getReference();
        firebaseDatabase = FirebaseDatabase.getInstance();
       // ReadFairebaseFailes();
    jv1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(getApplicationContext(), javaone.class);
            startActivity(intent);
        }
    });
    }



public void ReadFairebaseFailes(){

    slide s=new slide("title", "fipath");

    slide s1=new slide("Introduction", "https://firebasestorage.googleapis.com/v0/b/javapro-6e07e.appspot.com/o/upload%2F%20Introduction.pdf?alt=media&token=d6ddf8f4-04a1-4a9d-ad2e-ddafa3f0c3a5");
    slide s2=new slide("JavaBasics(I)", "https://firebasestorage.googleapis.com/v0/b/javapro-6e07e.appspot.com/o/upload%2FJavaBasics%20(I).pdf?alt=media&token=55a8db1e-3452-4698-a187-e509b1aea5fe");

    firebaseDatabase.getReference("javaoneslide").push().setValue(s1);
    firebaseDatabase.getReference("javaoneslide").push().setValue(s2);


}
}
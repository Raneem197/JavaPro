package com.raneem.javapro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

public class listofslides extends AppCompatActivity {

    ListView lstview;
    Button back;

    private DatabaseReference mDatabase;
    StorageReference storageRef;
    FirebaseDatabase firebaseDatabase;
    //StorageReference storageRef = storageRef.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofslides);

        lstview = findViewById(R.id.listview);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        firebaseDatabase=FirebaseDatabase.getInstance();

        mDatabase=firebaseDatabase.getReference("listslidesofjavaone");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds:snapshot.getChildren()){


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






      DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReferenceFromUrl("https://javapro-6e07e.firebaseio.com");


        FirebaseListAdapter<String> firebaseListAdapter=new FirebaseListAdapter<String>(
                this,String.class,android.R.layout.simple_list_item_1,databaseReference
        ) {
            @Override
            protected void populateView(View v, String model, int position) {

            }
        };

        String [] titles = new String [] {
                "1. Introduction", "2. Java basics ( I )" ,
                "3. Java basics ( II )" , "4. Conditions" ,
                "5. Loops" , "6. Methods" ,
                "7. Arrays", "8. Objects & Classes"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                android.R.id.text1,titles);
        lstview.setAdapter(adapter);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listofslides.this, javaone.class);
                startActivity(intent);
            }
        });
    }

    }

package com.raneem.javapro;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;
import android.widget.TextView;

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

import java.util.ArrayList;
import java.util.List;

public class listofslides extends AppCompatActivity {

    ListView lstview;
    Button back;

     DatabaseReference mDatabase;

    FirebaseDatabase firebaseDatabase;

    List<slide>list;


    //StorageReference storageRef = storageRef.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofslides);

        lstview = findViewById(R.id.listview);
       // mDatabase = FirebaseDatabase.getInstance().getReference();

        list=new ArrayList<>();

        ViewAllFailes();

        lstview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                slide slide= list.get(i);

              /*  Intent intent=new Intent();
                intent.setData(Uri.parse(slide.getFipath()));
                *///startActivity(intent);
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(slide.getFipath()));
                startActivity(browserIntent);

            }
        });


        //adapter=new ArrayAdapter<slide>(this,)

      /*  mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds:snapshot.getChildren()){


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/






     // DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReferenceFromUrl("https://javapro-6e07e.firebaseio.com");


      //  FirebaseListAdapter<String> firebaseListAdapter=new FirebaseListAdapter<String>(
               // this,String.class,android.R.layout.simple_list_item_1,databaseReference
      //  ) {
            //@Override
          //  protected void populateView(View v, String model, int position) {


           // }
       // };


       // ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                //android.R.id.text1,titles);
        //lstview.setAdapter(adapter);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listofslides.this, javaone.class);
                startActivity(intent);
            }
        });
    }

    private void ViewAllFailes() {
        mDatabase = FirebaseDatabase.getInstance().getReference().child("javaoneslide");

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds:snapshot.getChildren()){

                    slide ss=ds.getValue(slide.class);
                    list.add(ss);

                }

                String [] uploadslide = new String [list.size()];
                for (int i=0;i<uploadslide.length;i++){

                    uploadslide[i]=list.get(i).getTitle();

                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploadslide);//{


                    //@Override
                   /* public View getView(int position, View convertView,  ViewGroup parent) {
                        View view=super.getView(position, convertView, parent);

                        TextView mytext=(TextView)view.findViewById(android.R.id.text1);
                        mytext.setTextColor(Color.BLACK);
                        return view;
                    }*/
                //};


                 lstview.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

}

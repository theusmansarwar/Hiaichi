package com.usmansarwar.hiaichi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Admin extends AppCompatActivity {
CardView Userpage,Visibility,Upload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Userpage=findViewById(R.id.Userpage);
        Visibility=findViewById(R.id.available);
        Upload=findViewById(R.id.UploadCourse);
        Userpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent( Admin.this,MainActivity2.class ) );

            }
        });
        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent( Admin.this,Add_Data.class ) );

            }
        });
        Visibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent( Admin.this,SetAvailibility.class ) );

            }
        });

    }
}
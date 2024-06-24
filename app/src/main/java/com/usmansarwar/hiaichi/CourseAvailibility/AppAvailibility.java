package com.usmansarwar.hiaichi.CourseAvailibility;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.usmansarwar.hiaichi.R;

public class AppAvailibility extends AppCompatActivity {

    EditText price, description,number;
    String n, e;
    Button update;
    int num;
    DatabaseReference dbreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editcoursevisibility);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        dbreference = FirebaseDatabase.getInstance().getReference().child("Courses");


        Intent intent= getIntent();

        price= findViewById(R.id.price);
        description= findViewById(R.id.description);
        number= findViewById(R.id.Visiblitty);
        update=findViewById(R.id.UpdateCourse);
        n= intent.getStringExtra("price");
        e= intent.getStringExtra("description");
        num=   intent.getIntExtra("number", 0);

        if(n!= null){
            price.setText(n);

        }
        if(e!= null){
            description.setText(e);

        }

        number.setText(Integer.toString(num));


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num= Integer.parseInt(number.getText().toString());
                String Price = price.getText().toString();
                String Description = description.getText().toString();



                if (Price.isEmpty() || Description.isEmpty()) {

                    Toast.makeText(AppAvailibility.this, "Some data missing ", Toast.LENGTH_SHORT).show();

                } else {

                    dbreference.child("App").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            try {
                                dbreference.child("App").child("Price").setValue(Price);
                                dbreference.child("App").child("Short").setValue(Description);
                                dbreference.child("App").child("type").setValue(num);
                                Toast.makeText(AppAvailibility.this, "Data Updated ", Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                }
            }
        });


    }
}
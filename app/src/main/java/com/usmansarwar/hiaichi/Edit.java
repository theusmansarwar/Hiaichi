package com.usmansarwar.hiaichi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class Edit extends AppCompatActivity {
    Spinner spinner1,spinner2,spinner3;
    Button update;
    EditText name,phone,username;

    String UserID="";
    DatabaseReference dbreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        username = findViewById(R.id.l_username);


        name = findViewById(R.id.l_name);
        phone = findViewById(R.id.l_phone);

        update = findViewById(R.id.update);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        UserID = user.getUid();

        dbreference = FirebaseDatabase.getInstance().getReference().child("Users");

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String Name = name.getText().toString();
                String Phone = phone.getText().toString();
                String City = username.getText().toString();


                if (Name.isEmpty() || Phone.isEmpty() || City.isEmpty()) {

                    Toast.makeText(Edit.this, "Some data missing ", Toast.LENGTH_SHORT).show();

                } else {

                    dbreference.child(UserID).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            try {
                                startActivity ( new Intent( Edit.this,MainActivity2.class ) );
                                dbreference.child(UserID).child("name").setValue(Name);
                                dbreference.child(UserID).child("phone").setValue(Phone);
                                dbreference.child(UserID).child("username").setValue(City);
                                Toast.makeText(Edit.this, "Data Updated ", Toast.LENGTH_SHORT).show();

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
    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        UserID=user.getUid();
        dbreference.child(UserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    name.setText(snapshot.child("name").getValue().toString());
                    phone.setText(snapshot.child("phone").getValue().toString());
                    username.setText(snapshot.child("username").getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
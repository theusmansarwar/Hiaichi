package com.usmansarwar.hiaichi;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    Button reg,log;
    EditText email,password;
    FirebaseAuth auth;
    TextView goToRegister,forgot;
    DatabaseReference reference;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth=FirebaseAuth.getInstance ();

        reference=FirebaseDatabase.getInstance().getReference().child("Users");
        user=auth.getCurrentUser();

        reg=findViewById(R.id.Register);
        log=findViewById(R.id.Login);
        email=findViewById(R.id.l_email);
        password=findViewById(R.id.l_password);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity ( new Intent( Login.this,Registration.class ) );
                finish ();
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                String Email = email.getText().toString();
                String Password = password.getText().toString();

                if (TextUtils.isEmpty ( Email ))
                {
                    email.setError ( "Continue with email" );
                    return;
                }
                if (TextUtils.isEmpty ( Password ))
                {
                    password.setError ( "Enter password" );
                    return;
                }
                else {

                    signIn(Email, Password);
                }
            }
        });
    }

    private void signIn(String Email,  String Password) {

        auth.signInWithEmailAndPassword ( Email,Password )
                .addOnCompleteListener ( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful ()) {


                            FirebaseUser user = auth.getCurrentUser();
                            //ceck if user is verified
                            if (user.isEmailVerified()) {
                                String uid =task.getResult().getUser().getUid();
                                FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();

                                firebaseDatabase.getReference().child("Users").child(uid).child("usertype")
                                        .addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        int User=snapshot.getValue(Integer.class);
                                        if(User==0){

                                            startActivity ( new Intent( Login.this,MainActivity2.class ) );
                                            finish ();
                                        }
                                        if(User==1){

                                            startActivity ( new Intent( Login.this,Admin.class ) );
                                            finish ();
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });


                            }else
                            {

                                Toast.makeText ( Login.this, "Please verify email", Toast.LENGTH_SHORT ).show ();
                            }





                        }
                        else {

                            Toast.makeText ( Login.this, "Error"+task.getException ().getMessage (), Toast.LENGTH_SHORT ).show ();
                        }
                    }
                } );

    }





}
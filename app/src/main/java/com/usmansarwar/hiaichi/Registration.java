package com.usmansarwar.hiaichi;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.usmansarwar.hiaichi.Models.UserModel;

public class Registration extends AppCompatActivity {

    FirebaseAuth auth;

    String deviceID;
    Button reg,log;
    EditText name,email,password,phone,city,username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        city = findViewById(R.id.city);
        name = findViewById(R.id.l_name);
        email = findViewById(R.id.l_email);
        phone = findViewById(R.id.l_phone);
        password = findViewById(R.id.l_password);
        reg = findViewById(R.id.Register);
        log=findViewById(R.id.Login);
        username=findViewById(R.id.l_username);



        auth=FirebaseAuth.getInstance ();
        deviceID= Settings.Secure.getString ( getContentResolver (), Settings.Secure.ANDROID_ID );



        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = name.getText().toString();
                String Email = email.getText().toString();
                String Phone = phone.getText().toString();
                String City = city.getText().toString();
                String Password = password.getText().toString();
                String Username = username.getText().toString();

                if (Name.isEmpty() || Email.isEmpty() || Phone.isEmpty() || Password.isEmpty()  || City.isEmpty()||Username.isEmpty()) {

                    Toast.makeText(Registration.this, "Make sure you fill complete form", Toast.LENGTH_SHORT).show();

                } else {

                    createAccount(Email,Password );


                }


            }


        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity ( new Intent( Registration.this,Login.class ) );
                finish ();
            }
        });

    }


    private void createAccount(final String email, final String pass) {




        auth.createUserWithEmailAndPassword ( email,pass )
                .addOnCompleteListener ( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful ())
                        {
                            final FirebaseUser user=auth.getCurrentUser ();
                            assert user != null;


                            //send email verification link

                            auth.getCurrentUser ().sendEmailVerification ()
                                    .addOnCompleteListener ( new OnCompleteListener<Void> () {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful ())
                                            {


                                                updateUi(user,email,pass);

                                            }else
                                            {
                                                Toast.makeText ( Registration.this, "Error:"+task.getException ().getMessage (), Toast.LENGTH_SHORT ).show ();
                                            }
                                        }
                                    } );

                        }else
                        {

                            Toast.makeText ( Registration.this, "Error"+task.getException ().getMessage (), Toast.LENGTH_SHORT ).show ();
                        }
                    }
                } );


    }

    private void updateUi(FirebaseUser user,String email,String password) {

        @SuppressLint("HardwareIds") String deviceID= Settings.Secure.getString ( getContentResolver (), Settings.Secure.ANDROID_ID );


        UserModel userModel=new UserModel();
        userModel.setName(name.getText().toString());
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setUid(user.getUid());
        userModel.setUsername(username.getText().toString());

        userModel.setPhone(phone.getText().toString());
        userModel.setAmazon(0);
        userModel.setGame(0);
        userModel.setWeb(0);
        userModel.setApp(0);
        userModel.setYoutube(0);
        userModel.setSeo(0);
        userModel.setSocial(0);
        userModel.setFreelancing(0);
        userModel.setBlockchain(0);
        userModel.setGraphic(0);
        userModel.setData(0);
        userModel.setUsertype(0);








        DatabaseReference reference= FirebaseDatabase.getInstance ().getReference ().child ( "Users" );
        reference.child ( user.getUid () ).setValue ( userModel )
                .addOnCompleteListener ( new OnCompleteListener<Void> () {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful ())
                        {
                            Toast.makeText ( Registration.this, "Please verify your email", Toast.LENGTH_SHORT ).show ();

                            startActivity ( new Intent ( Registration.this,Login.class ) );
                            finish ();
                        }else {
                            Toast.makeText ( Registration.this, "Error"+task.getException ().getMessage (), Toast.LENGTH_SHORT ).show ();
                        }



                    }
                } );

    }

}
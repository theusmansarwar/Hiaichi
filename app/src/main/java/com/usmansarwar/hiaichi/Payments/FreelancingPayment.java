package com.usmansarwar.hiaichi.Payments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.usmansarwar.hiaichi.Available;
import com.usmansarwar.hiaichi.Buy;
import com.usmansarwar.hiaichi.Contact;
import com.usmansarwar.hiaichi.Edit;
import com.usmansarwar.hiaichi.MainActivity2;
import com.usmansarwar.hiaichi.Models.UserModel2;
import com.usmansarwar.hiaichi.Policy;
import com.usmansarwar.hiaichi.R;

public class FreelancingPayment extends AppCompatActivity {
    EditText trxid;
    TextView bankname,holdername,accountnumber,Price,Username;
    Button btnupdate;
    DatabaseReference db,db2,db3,db4;
    String UserID="";
    FirebaseAuth fAuth;
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freelancing_payment);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        nav=(NavigationView)findViewById(R.id.navmenu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        bankname = findViewById(R.id.bankname);
        holdername = findViewById(R.id.accounttittle);
        accountnumber = findViewById(R.id.banknumber);
        trxid=findViewById(R.id.trxid);
        Price=findViewById(R.id.Courseprice);
        Username=findViewById(R.id.l_username);

        btnupdate = findViewById(R.id.Submitbtn);

        fAuth = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        user = fAuth.getCurrentUser();
        UserID = user.getUid();
        db = FirebaseDatabase.getInstance().getReference().child("paymentinfo");
        db2 = FirebaseDatabase.getInstance().getReference().child("Buyers");
        db3 = FirebaseDatabase.getInstance().getReference().child("Courses");
        db4=FirebaseDatabase.getInstance().getReference().child("Users");



        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String trx= trxid.getText().toString();
                String username= Username.getText().toString();
                String price= Price.getText().toString();
                if (trx.isEmpty() ) {

                    Toast.makeText(FreelancingPayment.this, "Make sure you fill complete form", Toast.LENGTH_SHORT).show();

                } else {
                    String key = db2.push().getKey();
                    UserModel2 userModel2 = new UserModel2();
                    userModel2.setTrxid(trx);
                    userModel2.setUsername(username);
                    userModel2.setPrice(price);

                    userModel2.setTittle("Freelancing");

                    db2.child(key).setValue(userModel2).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(FreelancingPayment.this, "Request Sent Successfully, Please Wait 48 hours to activate your course", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(FreelancingPayment.this, MainActivity2.class));
                        }

                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(FreelancingPayment.this, "Error" + e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });


                }
            }
        });
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {////////////////first
                int id = menuItem.getItemId();
                if(id== R.id.menu_home) {

                    Intent intent = new Intent(FreelancingPayment.this, MainActivity2.class);
                    startActivity(intent);
                    return true;

                }
                if(id== R.id.menu_Available) {

                    Intent intent = new Intent(FreelancingPayment.this, Available.class);
                    startActivity(intent);
                    return true;

                }
                if(id== R.id.menu_Buy) {

                    Intent intent = new Intent(FreelancingPayment.this, Buy.class);
                    startActivity(intent);
                    return true;

                }
                if(id== R.id.menu_Edit) {

                    Intent intent = new Intent(FreelancingPayment.this, Edit.class);
                    startActivity(intent);
                    return true;

                }
                if(id== R.id.menu_Contact) {

                    Intent intent = new Intent(FreelancingPayment.this, Contact.class);
                    startActivity(intent);
                    return true;

                }
                if(id== R.id.menu_policy) {
                    Intent intent = new Intent(FreelancingPayment.this, Policy.class);
                    startActivity(intent);

                    return true;

                }

                if(id== R.id.menu_Rate) {

                    gotoUri("https://play.google.com/store/apps/details?id=com.usmansarwar.hiaichi");
                    return true;

                }


                return true;
            }
        });
    }

    private void gotoUri(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }





    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        UserID=user.getUid();
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    holdername.setText(snapshot.child("accounttittle").getValue().toString());
                    bankname.setText(snapshot.child("bankname").getValue().toString());
                    accountnumber.setText(snapshot.child("accountnumber").getValue().toString());


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        db3.child("Freelancing").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    Price.setText(snapshot.child("Price").getValue().toString());



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        db4.child(UserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    Username.setText(snapshot.child("username").getValue().toString());



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

}
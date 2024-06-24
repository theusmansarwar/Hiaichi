package com.usmansarwar.hiaichi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {
    CardView available,buy,edit,contact,privacy,rate;
    TextView notification;

    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference reference = firebaseDatabase.getReference();
    private DatabaseReference childReference = reference.child("Notification");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        nav=(NavigationView)findViewById(R.id.navmenu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        available=findViewById(R.id.available);
        buy=findViewById(R.id.buy);
        edit=findViewById(R.id.Userpage);
        contact=findViewById(R.id.contact);
        privacy=findViewById(R.id.policy);
        rate=findViewById(R.id.rate);
        notification=findViewById(R.id.Notifi);



        childReference.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                notification.setText(m);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity ( new Intent( MainActivity2.this,Buy.class ) );

            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent( MainActivity2.this,Edit.class ) );

            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent( MainActivity2.this,Contact.class ) );

            }
        });
        available.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent( MainActivity2.this,Available.class ) );
            }
        });
        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent( MainActivity2.this,Policy.class ) );

            }
        });
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUri("https://play.google.com/store/apps/details?id=com.real.hiaichi");
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

                    Intent intent = new Intent(MainActivity2.this, MainActivity2.class);
                    startActivity(intent);
                    return true;

                }
                if(id== R.id.menu_Available) {

                    Intent intent = new Intent(MainActivity2.this, Available.class);
                    startActivity(intent);
                    return true;

                }
                if(id== R.id.menu_Buy) {

                    Intent intent = new Intent(MainActivity2.this,Buy.class);
                    startActivity(intent);
                    return true;

                }
                if(id== R.id.menu_Edit) {

                    Intent intent = new Intent(MainActivity2.this,Edit.class);
                    startActivity(intent);
                    return true;

                }
                if(id== R.id.menu_Contact) {

                    Toast.makeText(MainActivity2.this, "Temporary Disabled ", Toast.LENGTH_SHORT).show();
                    return true;

                }
                if(id== R.id.menu_policy) {
                    Intent intent = new Intent(MainActivity2.this,Policy.class);
                    startActivity(intent);

                    return true;

                }

                if(id== R.id.menu_Rate) {

                    gotoUri("https://play.google.com/store/apps/details?id=com.real.hiaichi");
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
}
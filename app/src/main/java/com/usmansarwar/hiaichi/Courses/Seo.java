package com.usmansarwar.hiaichi.Courses;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.usmansarwar.hiaichi.Adapter;
import com.usmansarwar.hiaichi.Available;
import com.usmansarwar.hiaichi.Buy;
import com.usmansarwar.hiaichi.Contact;
import com.usmansarwar.hiaichi.Edit;
import com.usmansarwar.hiaichi.MainActivity2;
import com.usmansarwar.hiaichi.Models.Model;
import com.usmansarwar.hiaichi.Policy;
import com.usmansarwar.hiaichi.R;

import java.util.ArrayList;
import java.util.List;

public class Seo extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    ImageView addData;
    String key,  tittle,  lacture,course,videoid;
    List<Model> list= new ArrayList<>();
    RecyclerView recyclerView;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.recyclerView);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        nav=(NavigationView)findViewById(R.id.navmenu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        getData();
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Seo.this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter (list, Seo.this);
        recyclerView.setAdapter(adapter);


        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {////////////////first
                int id = menuItem.getItemId();
                if(id== R.id.menu_home) {

                    Intent intent = new Intent(Seo.this, MainActivity2.class);
                    startActivity(intent);
                    return true;

                }
                if(id== R.id.menu_Available) {

                    Intent intent = new Intent(Seo.this, Available.class);
                    startActivity(intent);
                    return true;

                }
                if(id== R.id.menu_Buy) {

                    Intent intent = new Intent(Seo.this, Buy.class);
                    startActivity(intent);
                    return true;

                }
                if(id== R.id.menu_Edit) {

                    Intent intent = new Intent(Seo.this, Edit.class);
                    startActivity(intent);
                    return true;

                }
                if(id== R.id.menu_Contact) {

                    Intent intent = new Intent(Seo.this, Contact.class);
                    startActivity(intent);
                    return true;

                }
                if(id== R.id.menu_policy) {
                    Intent intent = new Intent(Seo.this, Policy.class);
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
    public void getData(){

        FirebaseDatabase.getInstance().getReference("Videos").child("SeoVideos")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                            if (snapshot.exists()) {
                                key = snapshot.child("key").getValue().toString();
                                tittle= snapshot.child("Tittle").getValue().toString();
                                lacture= snapshot.child("Lacture").getValue().toString();
                                course= snapshot.child("Course").getValue().toString();
                                videoid= snapshot.child("Videoid").getValue().toString();
                                Log.d("iddddFFFFF", tittle.toString());
                                list.add(new Model(key,tittle ,lacture, course, videoid));

                            }

                        }
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                        Toast.makeText(Seo.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });


    }

}
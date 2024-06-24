package com.usmansarwar.hiaichi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.usmansarwar.hiaichi.Courses.App;
import com.usmansarwar.hiaichi.Courses.Blockchain;
import com.usmansarwar.hiaichi.Courses.DataScience;
import com.usmansarwar.hiaichi.Courses.Freelancing;
import com.usmansarwar.hiaichi.Courses.Game;
import com.usmansarwar.hiaichi.Courses.GraphicsDesigning;
import com.usmansarwar.hiaichi.Courses.Seo;
import com.usmansarwar.hiaichi.Courses.Social;
import com.usmansarwar.hiaichi.Courses.Webdevelopmentcourse;
import com.usmansarwar.hiaichi.Courses.Youtube;

public class Available extends AppCompatActivity {
    FirebaseAuth auth;
    TextView goToRegister,forgot;
    DatabaseReference reference;
    FirebaseUser user;
   String  UserId;
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    TextView amazonprice,amazonedescription,gameprice,gamedescription,graphicprice,graphicdescription,blockchainprice,blockchaindescription,
            dataprice,datadescription,freelancingprice,freelancingdescription,youtubeprice,youtubedescription,appprice,appdescription,
            socialprice,socialdescription,seoprice,seodescription,webprice,webdescription;
    LinearLayout amazonl,gamel,graphicl,blockchainl,datasciencel,freelancingl,youtubel,appl,sociall,seol,webl;
    CardView amazon,game,graphic,blockchain,datascience,freelancing,youtube,app,social,seo,web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        nav=(NavigationView)findViewById(R.id.navmenu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        ////cards view
        amazon=findViewById(R.id.Amazon);
        game=findViewById(R.id.game);
        graphic=findViewById(R.id.Graphic);
        blockchain=findViewById(R.id.Blockchain);
        datascience=findViewById(R.id.datascience);
        freelancing=findViewById(R.id.Freelancing);
        youtube=findViewById(R.id.Youtube);
        app=findViewById(R.id.app);
        social=findViewById(R.id.social);
        seo=findViewById(R.id.seo);
        web=findViewById(R.id.web);

        amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent( Available.this, MainActivity.class ) );

            }
        });
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent( Available.this, Game.class ) );

            }
        });
        graphic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent( Available.this, GraphicsDesigning.class ) );

            }
        });
        blockchain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent( Available.this, Blockchain.class ) );

            }
        });
        datascience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent( Available.this, DataScience.class ) );

            }
        });
        freelancing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent( Available.this, Freelancing.class ) );

            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent( Available.this, Youtube.class ) );

            }
        });
       app.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity ( new Intent( Available.this, App.class ) );
                }
       });
        social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent( Available.this, Social.class ) );

            }
        });
        seo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent( Available.this, Seo.class ) );

            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent( Available.this, Webdevelopmentcourse.class ) );

            }
        });

        ////layouts
        amazonl=findViewById(R.id.Amazonl);
        gamel=findViewById(R.id.gamel);
        graphicl=findViewById(R.id.Graphicl);
        blockchainl=findViewById(R.id.Blockchainl);
        datasciencel=findViewById(R.id.datasciencel);
        freelancingl=findViewById(R.id.Freelancingl);
        youtubel=findViewById(R.id.Youtubel);
        appl=findViewById(R.id.appl);
        sociall=findViewById(R.id.sociall);
        seol=findViewById(R.id.seol);
        webl=findViewById(R.id.webl);

        /////Description

        amazonedescription=findViewById(R.id.amazonedes);
        gamedescription=findViewById(R.id.gamedes);
        graphicdescription=findViewById(R.id.graphicdes);
        blockchaindescription=findViewById(R.id.blockchaindes);
        datadescription=findViewById(R.id.datades);
        freelancingdescription=findViewById(R.id.freelancingdes);
        youtubedescription=findViewById(R.id.youtubedes);
        appdescription=findViewById(R.id.appdes);
        socialdescription=findViewById(R.id.socaildes);
        seodescription=findViewById(R.id.seodes);
        webdescription=findViewById(R.id.webdes);




        auth= FirebaseAuth.getInstance ();
        user=auth.getCurrentUser();

        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();

        firebaseDatabase.getReference().child("Users").child(user.getUid()).child("amazon").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){
                    amazonl.setVisibility(View.GONE);
                }
                if(User==1){
                    amazonl.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        firebaseDatabase.getReference().child("Users").child(user.getUid()).child("game").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){
                    gamel.setVisibility(View.GONE);
                }
                if(User==1){
                    gamel.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        firebaseDatabase.getReference().child("Users").child(user.getUid()).child("graphic").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){
                    graphicl.setVisibility(View.GONE);
                }
                if(User==1){
                    graphicl.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        firebaseDatabase.getReference().child("Users").child(user.getUid()).child("blockchain").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){
                    blockchainl.setVisibility(View.GONE);
                }
                if(User==1){
                    blockchainl.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        firebaseDatabase.getReference().child("Users").child(user.getUid()).child("data").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){
                    datasciencel.setVisibility(View.GONE);
                }
                if(User==1){
                    datasciencel.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        firebaseDatabase.getReference().child("Users").child(user.getUid()).child("freelancing").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){
                    freelancingl.setVisibility(View.GONE);
                }
                if(User==1){
                    freelancingl.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        firebaseDatabase.getReference().child("Users").child(user.getUid()).child("youtube").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){
                    youtubel.setVisibility(View.GONE);
                }
                if(User==1){
                    youtubel.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        firebaseDatabase.getReference().child("Users").child(user.getUid()).child("app").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){
                    appl.setVisibility(View.GONE);
                }
                if(User==1){
                    appl.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        firebaseDatabase.getReference().child("Users").child(user.getUid()).child("web").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){
                    webl .setVisibility(View.GONE);
                }
                if(User==1){
                    webl.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        firebaseDatabase.getReference().child("Users").child(user.getUid()).child("social").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){
                    sociall.setVisibility(View.GONE);
                }
                if(User==1){
                    sociall.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        firebaseDatabase.getReference().child("Users").child(user.getUid()).child("seo").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){
                    seol.setVisibility(View.GONE);
                }
                if(User==1){
                    seol.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        ///set price and short description

        firebaseDatabase.getReference().child("Courses").child("Amazon").child("Short").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                amazonedescription.setText(m);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        firebaseDatabase.getReference().child("Courses").child("Game").child("Short").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                gamedescription.setText(m);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        firebaseDatabase.getReference().child("Courses").child("Graphic").child("Short").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                graphicdescription.setText(m);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        firebaseDatabase.getReference().child("Courses").child("Blockchain").child("Short").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                blockchaindescription.setText(m);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        firebaseDatabase.getReference().child("Courses").child("Data").child("Short").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                datadescription.setText(m);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        firebaseDatabase.getReference().child("Courses").child("Freelancing").child("Short").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                freelancingdescription.setText(m);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        firebaseDatabase.getReference().child("Courses").child("Youtube").child("Short").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                youtubedescription.setText(m);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        firebaseDatabase.getReference().child("Courses").child("App").child("Short").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                appdescription.setText(m);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        firebaseDatabase.getReference().child("Courses").child("Web").child("Short").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                webdescription.setText(m);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        firebaseDatabase.getReference().child("Courses").child("Social").child("Short").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                socialdescription.setText(m);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        firebaseDatabase.getReference().child("Courses").child("Seo").child("Short").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String n=snapshot.getValue(String.class);
                seodescription.setText(n);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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

                    Intent intent = new Intent(Available.this, MainActivity2.class);
                    startActivity(intent);
                    return true;

                }
                if(id== R.id.menu_Available) {

                    Intent intent = new Intent(Available.this, Available.class);
                    startActivity(intent);
                    return true;

                }
                if(id== R.id.menu_Buy) {

                    Intent intent = new Intent(Available.this,Buy.class);
                    startActivity(intent);
                    return true;

                }
                if(id== R.id.menu_Edit) {

                    Intent intent = new Intent(Available.this,Edit.class);
                    startActivity(intent);
                    return true;

                }
                if(id== R.id.menu_Contact) {

                    Intent intent = new Intent(Available.this,Contact.class);
                    startActivity(intent);
                    return true;

                }
                if(id== R.id.menu_policy) {
                    Intent intent = new Intent(Available.this,Policy.class);
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



}
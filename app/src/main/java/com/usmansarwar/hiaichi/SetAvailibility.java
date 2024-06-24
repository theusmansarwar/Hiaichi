package com.usmansarwar.hiaichi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.usmansarwar.hiaichi.CourseAvailibility.AmazonVisibility;
import com.usmansarwar.hiaichi.CourseAvailibility.AppAvailibility;
import com.usmansarwar.hiaichi.CourseAvailibility.BlockchainAvailibility;
import com.usmansarwar.hiaichi.CourseAvailibility.DAtaAvailibility;
import com.usmansarwar.hiaichi.CourseAvailibility.Freelancingavailibility;
import com.usmansarwar.hiaichi.CourseAvailibility.GameAvailibility;
import com.usmansarwar.hiaichi.CourseAvailibility.GraphicAvailibility;
import com.usmansarwar.hiaichi.CourseAvailibility.SeoAvailibility;
import com.usmansarwar.hiaichi.CourseAvailibility.SocialAvailibility;
import com.usmansarwar.hiaichi.CourseAvailibility.WebAvailbility;
import com.usmansarwar.hiaichi.CourseAvailibility.YoutubeAvailibility;

public class SetAvailibility extends AppCompatActivity {
    FirebaseAuth auth;
    TextView goToRegister,forgot;
    DatabaseReference reference;
    FirebaseUser user;
    TextView amazonprice,amazonedescription,amazontype,gameprice,gamedescription,gametype,graphicprice,graphicdescription,graphictype,blockchaintype,blockchainprice,blockchaindescription,
            datatype,dataprice,datadescription,freelancingtype,freelancingprice,freelancingdescription,youtubetype,youtubeprice,youtubedescription,appprice,appdescription,apptype,
            socialprice,socialdescription,socialtype,seoprice,seodescription,seotype,webprice,webdescription,webtype;

    CardView amazon,game,graphic,blockchain,datascience,freelancing,youtube,app,social,seo,web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_availibility);

        ////cards view
        amazon=(CardView)findViewById(R.id.Amazon);
        game=(CardView)findViewById(R.id.game);
        graphic=(CardView)findViewById(R.id.Graphic);
        blockchain=(CardView)findViewById(R.id.Blockchain);
        datascience=(CardView)findViewById(R.id.datascience);
        freelancing=(CardView)findViewById(R.id.Freelancing);
        youtube=(CardView)findViewById(R.id.Youtube);
        app=(CardView)findViewById(R.id.app);
        social=(CardView)findViewById(R.id.social);
        seo=(CardView)findViewById(R.id.seo);
        web=(CardView)findViewById(R.id.web);
        amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SetAvailibility.this, AmazonVisibility.class);
                intent.putExtra("price", amazonprice.getText().toString());
                intent.putExtra("description", amazonedescription.getText().toString());
                intent.putExtra("number",amazontype.getText().toString());
                startActivity(intent);
            }
        });

        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SetAvailibility.this, GameAvailibility.class);
                intent.putExtra("price", gameprice.getText().toString());
                intent.putExtra("description", gamedescription.getText().toString());
                intent.putExtra("number",gametype.getText().toString());
                startActivity(intent);
            }
        });
        graphic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SetAvailibility.this, GraphicAvailibility.class);
                intent.putExtra("price", graphicprice.getText().toString());
                intent.putExtra("description", graphicdescription.getText().toString());
                intent.putExtra("number",graphictype.getText().toString());
                startActivity(intent);
            }
        });
        blockchain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SetAvailibility.this, BlockchainAvailibility.class);
                intent.putExtra("price", blockchainprice.getText().toString());
                intent.putExtra("description", blockchaindescription.getText().toString());
                intent.putExtra("number",blockchaintype.getText().toString());
                startActivity(intent);
            }
        });
        datascience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SetAvailibility.this, DAtaAvailibility.class);
                intent.putExtra("price", datatype.getText().toString());
                intent.putExtra("description", datadescription.getText().toString());
                intent.putExtra("number",datatype.getText().toString());
                startActivity(intent);
            }
        });
        freelancing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SetAvailibility.this, Freelancingavailibility.class);
                intent.putExtra("price", freelancingprice.getText().toString());
                intent.putExtra("description", freelancingdescription.getText().toString());
                intent.putExtra("number",freelancingtype.getText().toString());
                startActivity(intent);
            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SetAvailibility.this, YoutubeAvailibility.class);
                intent.putExtra("price", youtubeprice.getText().toString());
                intent.putExtra("description", youtubedescription.getText().toString());
                intent.putExtra("number",youtubetype.getText().toString());
                startActivity(intent);
            }
        });
        app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SetAvailibility.this, AppAvailibility.class);
                intent.putExtra("price", appprice.getText().toString());
                intent.putExtra("description", appdescription.getText().toString());
                intent.putExtra("number",apptype.getText().toString());
                startActivity(intent);
            }
        });
        social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SetAvailibility.this, SocialAvailibility.class);
                intent.putExtra("price", socialprice.getText().toString());
                intent.putExtra("description", socialdescription.getText().toString());
                intent.putExtra("number",socialtype.getText().toString());
                startActivity(intent);
            }
        });
        seo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SetAvailibility.this, SeoAvailibility.class);
                intent.putExtra("price", seoprice.getText().toString());
                intent.putExtra("description", seodescription.getText().toString());
                intent.putExtra("number",seotype.getText().toString());
                startActivity(intent);
            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SetAvailibility.this, WebAvailbility.class);
                intent.putExtra("price", webprice.getText().toString());
                intent.putExtra("description", webdescription.getText().toString());
                intent.putExtra("number",webtype.getText().toString());
                startActivity(intent);
            }
        });

        ////Price

        amazonprice=findViewById(R.id.amazoneprice);
        gameprice=findViewById(R.id.gameprice);
        graphicprice=findViewById(R.id.graphicprice);
        blockchainprice=findViewById(R.id.blockchainprice);
        dataprice=findViewById(R.id.dataprice);
        freelancingprice=findViewById(R.id.freelancingprice);
        youtubeprice=findViewById(R.id.youtubeprice);
        appprice=findViewById(R.id.appprice);
        socialprice=findViewById(R.id.socialprice);
        seoprice=findViewById(R.id.seoprice);
        webprice=findViewById(R.id.webprice);

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

/////types
        amazontype=findViewById(R.id.amazonVisibility);
        gametype=findViewById(R.id.gameVisibility);
        graphictype=findViewById(R.id.graphicVisibility);
        blockchaintype=findViewById(R.id.blockchainVisibility);
        datatype=findViewById(R.id.dataVisibility);
        freelancingtype=findViewById(R.id.freelancingVisibility);
        youtubetype=findViewById(R.id.ytVisibility);
        apptype=findViewById(R.id.appVisibility);
        socialtype=findViewById(R.id.socialVisibility);
        seotype=findViewById(R.id.seoVisibility);
        webtype=findViewById(R.id.webVisibility);


        auth= FirebaseAuth.getInstance ();
        user=auth.getCurrentUser();

        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();


        ///set price and short description

        firebaseDatabase.getReference().child("Courses").child("Amazon").child("Price").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                amazonprice.setText(m);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
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
        firebaseDatabase.getReference().child("Courses").child("Amazon").child("type").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){

                    amazontype.setText("Private");
                }
                if(User==1){

                    amazontype.setText("Public");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        firebaseDatabase.getReference().child("Courses").child("Game").child("Price").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                gameprice.setText(m);
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
        firebaseDatabase.getReference().child("Courses").child("Game").child("type").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){

                    gametype.setText("Private");
                }
                if(User==1){

                    gametype.setText("Public");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        firebaseDatabase.getReference().child("Courses").child("Graphic").child("Price").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                graphicprice.setText(m);
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
        firebaseDatabase.getReference().child("Courses").child("Graphic").child("type").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){

                    graphictype.setText("Private");
                }
                if(User==1){

                    graphictype.setText("Public");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        firebaseDatabase.getReference().child("Courses").child("Blockchain").child("Price").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                blockchainprice.setText(m);
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
        firebaseDatabase.getReference().child("Courses").child("Blockchain").child("type").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){

                    blockchaintype.setText("Private");
                }
                if(User==1){

                    blockchaintype.setText("Public");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        firebaseDatabase.getReference().child("Courses").child("Data").child("Price").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                dataprice.setText(m);
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
        firebaseDatabase.getReference().child("Courses").child("Data").child("type").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){

                    datatype.setText("Private");
                }
                if(User==1){

                    datatype.setText("Public");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        firebaseDatabase.getReference().child("Courses").child("Freelancing").child("Price").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                freelancingprice.setText(m);
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
        firebaseDatabase.getReference().child("Courses").child("Freelancing").child("type").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){

                    freelancingtype.setText("Private");
                }
                if(User==1){

                    freelancingtype.setText("Public");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        firebaseDatabase.getReference().child("Courses").child("Youtube").child("Price").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                youtubeprice.setText(m);
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
        firebaseDatabase.getReference().child("Courses").child("Youtube").child("type").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){

                    youtubetype.setText("Private");
                }
                if(User==1){

                    youtubetype.setText("Public");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        firebaseDatabase.getReference().child("Courses").child("App").child("Price").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                appprice.setText(m);
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
        firebaseDatabase.getReference().child("Courses").child("App").child("type").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){

                    apptype.setText("Private");
                }
                if(User==1){

                    apptype.setText("Public");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        firebaseDatabase.getReference().child("Courses").child("Web").child("Price").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                webprice.setText(m);
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
        firebaseDatabase.getReference().child("Courses").child("Web").child("type").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){

                    webtype.setText("Private");
                }
                if(User==1){

                    webtype.setText("Public");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        firebaseDatabase.getReference().child("Courses").child("Social").child("Price").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                socialprice.setText(m);
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
        firebaseDatabase.getReference().child("Courses").child("Social").child("type").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){

                    socialtype.setText("Private");
                }
                if(User==1){

                    socialtype.setText("Public");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        firebaseDatabase.getReference().child("Courses").child("Seo").child("Price").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m=snapshot.getValue(String.class);
                seoprice.setText(m);
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
        firebaseDatabase.getReference().child("Courses").child("Seo").child("type").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int User=snapshot.getValue(Integer.class);
                if(User==0){

                    seotype.setText("Private");
                }
                if(User==1){

                    seotype.setText("Public");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}
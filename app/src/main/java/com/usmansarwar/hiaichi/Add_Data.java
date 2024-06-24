package com.usmansarwar.hiaichi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Add_Data extends AppCompatActivity {

    String[]Courses={"Amazon commercial","Blockchain","Meta verse Game Development",
            "App Development","Web Development","Data Science","Graphics Designing",
            "Social Media Marketing","Youtube","Seo","Freelancing"};
    EditText tittle, lacture, videoid;
            Spinner course;
    FirebaseAuth auth;
    int num;
    DatabaseReference reference;
    Button add;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        tittle= findViewById(R.id.tittle);
        lacture= findViewById(R.id.lacture);
        videoid= findViewById(R.id.videoid);
        course= findViewById(R.id.category);
        FirebaseApp.initializeApp(this);

        add= findViewById(R.id.Upload);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, Courses);
        course.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addcontacts();
            }
        });


    }
    public  void addcontacts(){
          auth= FirebaseAuth.getInstance();
//        id= auth.getCurrentUser().getUid();
       String Tittle= tittle.getText().toString();
        String Lacture= lacture.getText().toString();
        String Course= course.getSelectedItem().toString();
        String Videoid= videoid.getText().toString();


if(Course=="Amazon commercial"){
        reference= FirebaseDatabase.getInstance().getReference("Videos").child("AmazonVideos");
        String key = reference.push().getKey();
        Map<String, Object> map= new HashMap<>();
        map.put("key", key);
        map.put("Tittle", Tittle);
        map.put("Lacture",Lacture );
        map.put("Course", Course);
        map.put("Videoid",Videoid );
        reference.child(key).setValue(map)
            .addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if (task.isSuccessful()) {
                        Toast.makeText(Add_Data.this, "Added", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Add_Data.this, MainActivity.class));
                        finish();
//                            trustedCEt.setText(" ");
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {

            Toast.makeText(Add_Data.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                progressDialog.dismiss();

        }
    });
}
        if(Course=="Blockchain"){
            reference= FirebaseDatabase.getInstance().getReference().child("Videos").child("BlockchainVideos");
            String key = reference.push().getKey();
            Map<String, Object> map= new HashMap<>();
            map.put("key", key);
            map.put("Tittle", Tittle);
            map.put("Lacture",Lacture );
            map.put("Course", Course);
            map.put("Videoid",Videoid );
            reference.child(key).setValue(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(Add_Data.this, "Added", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Add_Data.this, MainActivity.class));
                                finish();
//                            trustedCEt.setText(" ");
                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(Add_Data.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                progressDialog.dismiss();

                }
            });
        }
        if(Course=="Meta verse Game Development"){
            reference= FirebaseDatabase.getInstance().getReference().child("Videos").child("GameVideos");
            String key = reference.push().getKey();
            Map<String, Object> map= new HashMap<>();
            map.put("key", key);
            map.put("Tittle", Tittle);
            map.put("Lacture",Lacture );
            map.put("Course", Course);
            map.put("Videoid",Videoid );
            reference.child(key).setValue(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(Add_Data.this, "Added", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Add_Data.this, MainActivity.class));
                                finish();
//                            trustedCEt.setText(" ");
                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(Add_Data.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                progressDialog.dismiss();

                }
            });
        }
        if(Course=="App Development"){
            reference= FirebaseDatabase.getInstance().getReference().child("Videos").child("AppVideos");
            String key = reference.push().getKey();
            Map<String, Object> map= new HashMap<>();
            map.put("key", key);
            map.put("Tittle", Tittle);
            map.put("Lacture",Lacture );
            map.put("Course", Course);
            map.put("Videoid",Videoid );
            reference.child(key).setValue(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(Add_Data.this, "Added", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Add_Data.this, MainActivity.class));
                                finish();
//                            trustedCEt.setText(" ");
                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(Add_Data.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                progressDialog.dismiss();

                }
            });
        }
        if(Course=="Web Development"){
            reference= FirebaseDatabase.getInstance().getReference().child("Videos").child("WebVideos");
            String key = reference.push().getKey();
            Map<String, Object> map= new HashMap<>();
            map.put("key", key);
            map.put("Tittle", Tittle);
            map.put("Lacture",Lacture );
            map.put("Course", Course);
            map.put("Videoid",Videoid );
            reference.child(key).setValue(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(Add_Data.this, "Added", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Add_Data.this, MainActivity.class));
                                finish();
//                            trustedCEt.setText(" ");
                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(Add_Data.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                progressDialog.dismiss();

                }
            });
        }
        if(Course=="Data Science"){
            reference= FirebaseDatabase.getInstance().getReference().child("Videos").child("DataScienceVideos");
            String key = reference.push().getKey();
            Map<String, Object> map= new HashMap<>();
            map.put("key", key);
            map.put("Tittle", Tittle);
            map.put("Lacture",Lacture );
            map.put("Course", Course);
            map.put("Videoid",Videoid );
            reference.child(key).setValue(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(Add_Data.this, "Added", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Add_Data.this, MainActivity.class));
                                finish();
//                            trustedCEt.setText(" ");
                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(Add_Data.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                progressDialog.dismiss();

                }
            });
        }
        if(Course=="Graphics Designing"){
            reference= FirebaseDatabase.getInstance().getReference().child("Videos").child("GraphicsDesigningVideos");
            String key = reference.push().getKey();
            Map<String, Object> map= new HashMap<>();
            map.put("key", key);
            map.put("Tittle", Tittle);
            map.put("Lacture",Lacture );
            map.put("Course", Course);
            map.put("Videoid",Videoid );
            reference.child(key).setValue(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(Add_Data.this, "Added", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Add_Data.this, MainActivity.class));
                                finish();
//                            trustedCEt.setText(" ");
                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(Add_Data.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                progressDialog.dismiss();

                }
            });
        }
        if(Course=="Social Media Marketing"){
            reference= FirebaseDatabase.getInstance().getReference().child("Videos").child("SocialMediaMarketingVideos");
            String key = reference.push().getKey();
            Map<String, Object> map= new HashMap<>();
            map.put("key", key);
            map.put("Tittle", Tittle);
            map.put("Lacture",Lacture );
            map.put("Course", Course);
            map.put("Videoid",Videoid );
            reference.child(key).setValue(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(Add_Data.this, "Added", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Add_Data.this, MainActivity.class));
                                finish();
//                            trustedCEt.setText(" ");
                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(Add_Data.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                progressDialog.dismiss();

                }
            });
        }
        if(Course=="Youtube"){
            reference= FirebaseDatabase.getInstance().getReference().child("Videos").child("YoutubeVideos");
            String key = reference.push().getKey();
            Map<String, Object> map= new HashMap<>();
            map.put("key", key);
            map.put("Tittle", Tittle);
            map.put("Lacture",Lacture );
            map.put("Course", Course);
            map.put("Videoid",Videoid );
            reference.child(key).setValue(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(Add_Data.this, "Added", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Add_Data.this, MainActivity.class));
                                finish();
//                            trustedCEt.setText(" ");
                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(Add_Data.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                progressDialog.dismiss();

                }
            });
        }
        if(Course=="Seo"){
            reference= FirebaseDatabase.getInstance().getReference().child("Videos").child("SeoVideos");
            String key = reference.push().getKey();
            Map<String, Object> map= new HashMap<>();
            map.put("key", key);
            map.put("Tittle", Tittle);
            map.put("Lacture",Lacture );
            map.put("Course", Course);
            map.put("Videoid",Videoid );
            reference.child(key).setValue(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(Add_Data.this, "Added", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Add_Data.this, MainActivity.class));
                                finish();
//                            trustedCEt.setText(" ");
                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(Add_Data.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                progressDialog.dismiss();

                }
            });
        }
        if(Course=="Freelancing"){
            reference= FirebaseDatabase.getInstance().getReference().child("Videos").child("FreelancingVideos");
            String key = reference.push().getKey();
            Map<String, Object> map= new HashMap<>();
            map.put("key", key);
            map.put("Tittle", Tittle);
            map.put("Lacture",Lacture );
            map.put("Course", Course);
            map.put("Videoid",Videoid );
            reference.child(key).setValue(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(Add_Data.this, "Added", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Add_Data.this, MainActivity.class));
                                finish();
//                            trustedCEt.setText(" ");
                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(Add_Data.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                progressDialog.dismiss();

                }
            });
        }





    }
}
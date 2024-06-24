package com.usmansarwar.hiaichi;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Show_Detail extends YouTubeBaseActivity {
LinearLayout layout;
    TextView name, email, number;
    String n, e;
    ImageView play;
    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        Intent intent= getIntent();



        youTubePlayerView=findViewById(R.id.player);

        n= intent.getStringExtra("Tittle");
        e= intent.getStringExtra("Videoid");


        onInitializedListener=new YouTubePlayer.OnInitializedListener() {
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo(e);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

};







    }

    @Override
    protected void onStart() {
        super.onStart();
        youTubePlayerView.initialize("AIzaSyDEM3xXzBmY3IY02J3DTF9UJSI59rF74oI",onInitializedListener);
getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }
}
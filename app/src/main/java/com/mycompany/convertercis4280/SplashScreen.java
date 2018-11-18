package com.mycompany.convertercis4280;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class SplashScreen extends AppCompatActivity {
    VideoView logoVid;
    MediaController m;

    ImageView aniImg;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        setContentView(R.layout.activity_splash_screen);
        logoVid = (VideoView) findViewById(R.id.logoSplash);

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash_slide);
        logoVid.setVideoURI(video);


        logoVid.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                startNextActivity();
            }
        });

        logoVid.start();
    }

    private void startNextActivity() {
        if (isFinishing())
            return;
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}

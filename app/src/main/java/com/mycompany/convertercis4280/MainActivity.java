package com.mycompany.convertercis4280;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Button temperature;
    private Button weight ;
    private Button volume;
    private Button distance;

     AnimationDrawable anim;
     LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (LinearLayout) findViewById(R.id.container);
        anim = (AnimationDrawable) container.getBackground();
        anim.setEnterFadeDuration(6000);
        anim.setExitFadeDuration(2000);


        temperature = findViewById(R.id.temperature_button);
        weight = findViewById(R.id.weight_button);
        volume = findViewById(R.id.volume_button);
        distance = findViewById(R.id.distance_button);



    }

    public void openTemperature(View view){
       /* Intent intent = new Intent(this,Temperature.class);
        startActivity(intent);*/


        Intent intent = Temperature.makeIntent(MainActivity.this);
        startActivity(intent);

    }
    public void openWeight(View view){
       /* Intent intent = new Intent(this,Weight.class);
        startActivity(intent);*/

        Intent intent = Weight.makeIntent(MainActivity.this);
        startActivity(intent);
    }
    public void openVolume(View view){
       /* Intent intent = new Intent(this,Volume.class);
        startActivity(intent);*/

        Intent intent = Volume.makeIntent(MainActivity.this);
        startActivity(intent);
    }
    public void openDistance(View view){
       /* Intent intent = new Intent(this,Distance.class);
        startActivity(intent);*/
        Intent intent = Distance.makeIntent(MainActivity.this);
        startActivity(intent);
    }

    // pass intent from any activity to this activity
    // lets this activities make itself in other activity
    public static Intent makeIntent(Context context)
    {
        // context whats passed in
        // mainactivity is destination
        return new Intent(context, MainActivity.class);
    }

    //used
    @Override
    protected void onResume() {
        super.onResume();
        if (anim != null && !anim.isRunning())
            anim.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (anim != null && anim.isRunning())
            anim.stop();
    }


}



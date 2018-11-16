package com.mycompany.convertercis4280;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationViewHelper {

    //method to setup and customize the bottom navigation bar
    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){

        //change the behavior of the navigation bar here
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(true);

        }

    //method to switch between activities based on the menu item selected
    public static void enableNavigation(final Context context, final Activity callingActivity, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    //launching distance activity
                    case R.id.distance:
                        Intent intent1 = new Intent(context, Distance.class);
                        context.startActivity(intent1);
                        //Transition animation defined in res/anim
                        callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out); //ACTIVITY_NUM = 0
                        break;
                    //launching temperature activity
                    case R.id.temperature:
                        Intent intent2 = new Intent(context, Temperature.class);
                        context.startActivity(intent2);
                        //Transition animation defined in res/anim
                        callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out); //ACTIVITY_NUM = 1
                        break;
                    //launching volume activity
                    case R.id.volume:
                        Intent intent3 = new Intent(context, Volume.class);
                        context.startActivity(intent3);
                        //Transition animation defined in res/anim
                        callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out); //ACTIVITY_NUM = 2
                        break;
                    //launching weight activity
                    case R.id.weight:
                        Intent intent4 = new Intent(context, Weight.class);
                        context.startActivity(intent4);
                        //Transition animation defined in res/anim
                        callingActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out); //ACTIVITY_NUM = 3
                        break;
                }
                return false;
            }
        });
    }
}


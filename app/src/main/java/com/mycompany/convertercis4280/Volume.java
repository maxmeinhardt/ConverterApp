package com.mycompany.convertercis4280;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class Volume extends AppCompatActivity {
    private static final int ACTIVITY_NUM = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        setupBottomNavigationView();
    }

    private void setupBottomNavigationView(){

        //creating BottomNavigationView
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.BottomNavViewBar);

        //Customizing BottomNavigationView using BottomNavigationViewHelper.setupBottomNavigationView
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);

        //Setting up navigation between classes
        BottomNavigationViewHelper.enableNavigation(Volume.this, this, bottomNavigationViewEx);

        /*Getting the menu item from the menu item with the corresponding ACTIVITY_NUM in the switch
          statement in BottomNavigationViewHelper class and highlighting it using setChecked(true)
         */
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);


    }
}
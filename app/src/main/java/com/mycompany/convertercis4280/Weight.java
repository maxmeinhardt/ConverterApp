package com.mycompany.convertercis4280;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class Weight extends AppCompatActivity{

    // create variables
    private EditText editText;
    private TextView unitText;
    private RadioButton radioButton;
    private TextView result;
    private Button calculate;
    private RadioGroup radioGroup;
    private Button back;

    private static final int ACTIVITY_NUM = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        setupBottomNavigationView();
    }

    private void setupBottomNavigationView(){

        //creating BottomNavigationView
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.BottomNavViewBar);

        //Customizing BottomNavigationView using BottomNavigationViewHelper.setupBottomNavigationView
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);

        //Setting up navigation between classes
        BottomNavigationViewHelper.enableNavigation(Weight.this, this, bottomNavigationViewEx);

        /*Getting the menu item from the menu item with the corresponding ACTIVITY_NUM in the switch
          statement in BottomNavigationViewHelper class and highlighting it using setChecked(true)
         */
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);


    }
    // Method that is ran every time a radio button is clicked
    public void radioButtonClick(View v){
        // int to get the id of the checked radio button
        int radioId = radioGroup.getCheckedRadioButtonId();

        // set variable to checked radio button
        radioButton = findViewById(radioId);

        // set the unit text to match the units of the value to be converted
        if(radioGroup.getCheckedRadioButtonId() == Integer.valueOf(R.id.pounds))
        {
            unitText.setText(R.string.lbs);
        }
        else
        {
            unitText.setText(R.string.kg);
        }

        if(editText.getText().toString().trim().length() != 0 )
        {
            convert();
        }
        // display a toast to show that the radio button has been changed
        Toast.makeText(this,"Selected to convert from " + radioButton.getText(),Toast.LENGTH_SHORT).show();
    }// end of radio button click method

    // Method that is called whem regular button is clicked to calculate the converted result
    private void convert() {

        // convert the user input into a double
        double weight = Double.parseDouble(editText.getText().toString());




        // find out if the user is converting pounds or kilograms and set the result text to the
        // converted answer
        if(radioGroup.getCheckedRadioButtonId() != Integer.valueOf(R.id.pounds))
        {
            calculatePounds(weight);
        }
        else
        {
            calculateKilograms(weight);

        }// end if

    }// end of convert method

    // instantly calculate when text changes
    private final TextWatcher editTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start,int before, int count) {
            try {
                convert();
            }
            catch (NumberFormatException e) {
                result.setText("");

            }

        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
    };

    private void calculatePounds(double weight)
    {
        String text;
        text =editText.getText().toString() + unitText.getText().toString() + " = " + String.format("%.2f",(weight * 2.2046)) + "lbs";
        // set result with the user text , unit text , and the calculated value and units
        result.setText(text);
    }

    private void calculateKilograms(double weight)
    {
        String text;
        text = editText.getText().toString() + unitText.getText().toString() + " = " + String.format("%.2f",(weight/2.2046)) +"kg";
        // set result with the user text , unit text , and the calculated value and units
        result.setText(text);
    }

    // pass intent from any activity to this activity
    // lets this activities make itself in other activity
    public static Intent makeIntent(Context context)
    {
        // context whats passed in
        // weight class is destination
        return new Intent(context, Weight.class);
    }
}
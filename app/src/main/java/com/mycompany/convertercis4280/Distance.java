package com.mycompany.convertercis4280;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class Distance extends AppCompatActivity{



    // create variables
    private EditText editText;
    private TextView unitText;
    private RadioButton radioButton;
    private TextView result;
    private Button calculate;
    private RadioGroup radioGroup;

    private static final int ACTIVITY_NUM = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_distance);


            // assign variable to xml layout
            editText = findViewById(R.id.editText);
            editText.addTextChangedListener(editTextWatcher);
            unitText = findViewById(R.id.unit);
            result = findViewById(R.id.result);
            calculate = findViewById(R.id.calculate);
            radioGroup = findViewById(R.id.radioGroup);


            // set unit text
            unitText.setText(R.string.mi);
            // set result to empty string
            result.setText("");

            // create on click method for convert button
            calculate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // call convert method when button is clicked
                    convert();
                }
            }); // end of calculate on click



            setupBottomNavigationView();
        }

        private void setupBottomNavigationView(){

            //creating BottomNavigationView
            BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.BottomNavViewBar);

            //Customizing BottomNavigationView using BottomNavigationViewHelper.setupBottomNavigationView
            BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);

            //Setting up navigation between classes
            BottomNavigationViewHelper.enableNavigation(Distance.this, this, bottomNavigationViewEx);

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
        if(radioGroup.getCheckedRadioButtonId() == Integer.valueOf(R.id.miles))
        {
            unitText.setText(R.string.mi);
        }
        else
        {
            unitText.setText(R.string.km);
        }

        // display a toast to show that the radio button has been changed
        Toast.makeText(this,"Selected to convert from " + radioButton.getText(),Toast.LENGTH_SHORT).show();

        if(editText.getText().toString().trim().length() != 0 )
        {
            convert();
        }
    }// end of radio button click method

    // Method that is called whem regular button is clicked to calculate the converted result
    private void convert() {

        // convert the user input into a double
        double distance = Double.parseDouble(editText.getText().toString());

        // create local variable
        String text;



        // find out if the user is converting miles or kilometers and set the result text to the
        // converted answer
        if(radioGroup.getCheckedRadioButtonId() != Integer.valueOf(R.id.miles))
        {
            calculateMiles(distance);
        }
        else
        {
            calculateKilometers(distance);
        }// end if

    }// end of convert method

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

    private void calculateMiles(double distance )
    {
        String text;
        text = editText.getText().toString() + unitText.getText().toString() + " = " + String.format("%.2f", (distance/1.609)) + "mi.";
        // set result with the user text , unit text , and the calculated value and units
        result.setText(text);
    }

    private void calculateKilometers(double distance )
    {
        String text;
        text = editText.getText().toString() + unitText.getText().toString() + " = " + String.format("%.2f", (distance*1.609)) +"KM";
        // set result with the user text , unit text , and the calculated value and units
        result.setText(text);
    }


    // pass intent from any activity to this activity
    // lets this activities make itself in other activity
    public static Intent makeIntent(Context context)
    {
        // context whats passed in
        // distance class is destination
        return new Intent(context, Distance.class);
    }
}



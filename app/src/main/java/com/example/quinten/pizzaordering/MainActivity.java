//Name: Quinten Whitaker
//Date: 8-23-18
//Assignment: Lab 2 - Pizza Ordering System


package com.example.quinten.pizzaordering;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    DecimalFormat df2 = new DecimalFormat("##.##");
    //Crust Radio Button Declarations
    RadioGroup crustRadioGroup;
    RadioButton ptRadioButton;
    RadioButton thinRadioButton;
    RadioButton ddRadioButton;

    //Checkbox Declarations
    CheckBox pepperoni;
    CheckBox spinach;
    CheckBox pineapple;
    CheckBox bacon;

    //Location Radio Group Declarations
    RadioGroup locationRadioGroup;
    RadioButton restRadioButton;
    RadioButton pickupRadioButton;
    RadioButton deliveryRadioButton;

    //Seekbar Declarations
    SeekBar sizeSeekBar;
    TextView pizzaSizeTextView;

    //Price integers
    TextView priceTextView;
    double crustPrice;
    int numToppings;
    int pizzaSize = 22;
    double deliveryPrice;
    double totalPrice;

    //Update Price Method
    public void update(){
        double sizeSquared = Math.PI * Math.pow((pizzaSize / 2), 2);
        totalPrice = crustPrice + (numToppings * sizeSquared * .05) + deliveryPrice + (sizeSquared * .05);
        priceTextView.setText("$" + String.valueOf(df2.format(totalPrice)));

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        update();

    }

    public void init(){

        //Assigning views by ID for Crust Radio Group
        crustRadioGroup = (RadioGroup)findViewById(R.id.crustRadioGroup);
        ptRadioButton = (RadioButton)findViewById(R.id.ptRadioButton);
        thinRadioButton = (RadioButton)findViewById(R.id.thinRadioButton);
        ddRadioButton = (RadioButton)findViewById(R.id.ddRadioButton);

        //Assign Views by ID for checkboxes
        pepperoni = (CheckBox)findViewById(R.id.pepCheckBox);
        spinach = (CheckBox)findViewById(R.id.spinachCheckBox);
        pineapple = (CheckBox)findViewById(R.id.pineappleCheckBox);
        bacon = (CheckBox)findViewById(R.id.baconCheckBox);

        //Assign View by ID for location Radio Group
        locationRadioGroup = (RadioGroup)findViewById(R.id.locationRadioGroup);
        restRadioButton = (RadioButton)findViewById(R.id.restRadioButton);
        pickupRadioButton = (RadioButton)findViewById(R.id.pickupRadioButton);
        deliveryRadioButton = (RadioButton)findViewById(R.id.deliveryRadioButton);


        //Assign view by ID seekbar
        sizeSeekBar = (SeekBar)findViewById(R.id.sizeSeekBar);
        pizzaSizeTextView = (TextView)findViewById(R.id.pizzaSizeTextView);

        //Assign view by ID price
        priceTextView = (TextView)findViewById(R.id.priceTextView);

        //Radio Group Listener
        crustRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int currentId = crustRadioGroup.getCheckedRadioButtonId();
                RadioButton currentRb = (RadioButton)findViewById(currentId);
                Toast.makeText(MainActivity.this, currentRb.getText().toString(), Toast.LENGTH_SHORT).show();
                switch(currentRb.getText().toString()){
                    case "Pan Tossed": crustPrice = 0; break;
                    case "Thin": crustPrice = 2.5; break;
                    case "Deep Dish": crustPrice = 5; break;
                }
                update();

            }
        });

        //Radio Group Listener
        locationRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int currentId = locationRadioGroup.getCheckedRadioButtonId();
                RadioButton currentRb = (RadioButton)findViewById(currentId);
                Toast.makeText(MainActivity.this, currentRb.getText().toString(), Toast.LENGTH_SHORT).show();
                switch(currentRb.getText().toString()){
                    case "Restaurant": deliveryPrice = 0; break;
                    case "Pickup": deliveryPrice = 0; break;
                    case "Delivery": deliveryPrice = 3; break;
                }
                update();

            }
        });


        //Check Box Listeners
        //pepperoni
        pepperoni.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked)
                        {
                            numToppings++;
                            Toast.makeText(MainActivity.this,  pepperoni.getText().toString() + " Added", Toast.LENGTH_SHORT).show();
                        }

                    else
                        {
                            numToppings--;
                            Toast.makeText(MainActivity.this, pepperoni.getText().toString() + " Removed", Toast.LENGTH_SHORT).show();
                        }

                update();
            }
        });
        //pineapple
        pineapple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    numToppings++;
                    Toast.makeText(MainActivity.this,  pineapple.getText().toString() + " Added", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    numToppings--;
                    Toast.makeText(MainActivity.this, pineapple.getText().toString() + " Removed", Toast.LENGTH_SHORT).show();
                }

                update();
            }
        });
        //spinach
        spinach.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    numToppings++;
                    Toast.makeText(MainActivity.this,  spinach.getText().toString() + " Added", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    numToppings--;
                    Toast.makeText(MainActivity.this, spinach.getText().toString() + " Removed", Toast.LENGTH_SHORT).show();
                }

                update();
            }
        });
        //bacon
        bacon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    numToppings++;
                    Toast.makeText(MainActivity.this,  bacon.getText().toString() + " Added", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    numToppings--;
                    Toast.makeText(MainActivity.this, bacon.getText().toString() + " Removed", Toast.LENGTH_SHORT).show();
                }

                update();
            }
        });

        //Seekbar listener
        sizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch(progress)
                {
                    case 0: pizzaSizeTextView.setText("12\""); pizzaSize = 12; break;
                    case 1: pizzaSizeTextView.setText("14\""); pizzaSize = 14; break;
                    case 2: pizzaSizeTextView.setText("16\""); pizzaSize = 16; break;
                    case 3: pizzaSizeTextView.setText("18\""); pizzaSize = 18; break;
                    case 4: pizzaSizeTextView.setText("20\""); pizzaSize = 20; break;
                    case 5: pizzaSizeTextView.setText("22\""); pizzaSize = 22; break;
                    case 6: pizzaSizeTextView.setText("24\""); pizzaSize = 24; break;
                    case 7: pizzaSizeTextView.setText("26\""); pizzaSize = 26; break;
                    case 8: pizzaSizeTextView.setText("28\""); pizzaSize = 28; break;
                    case 9: pizzaSizeTextView.setText("30\""); pizzaSize = 30; break;
                }

                update();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}

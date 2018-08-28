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

public class MainActivity extends AppCompatActivity {

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
    double toppingPrice;
    double deliveryPrice;
    double sizePrice;
    double totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                switch(){
                    case ptRadioButton: crustPrice = 0; break;
                    case thinRadioButton: crustPrice = 2.5; break;
                    case ddRadioButton: crustPrice = 5; break;
                }
                update();

            }
        });

        //Check Box Listeners
            //pepperoni
                pepperoni.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            Toast.makeText(MainActivity.this, pepperoni.getText().toString() + " is added", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                //pineapple
                pineapple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            Toast.makeText(MainActivity.this, pineapple.getText().toString() + " is added", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                //spinach
                spinach.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            Toast.makeText(MainActivity.this, spinach.getText().toString() + " is added", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                //bacon
                bacon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            Toast.makeText(MainActivity.this, bacon.getText().toString() + " is added", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                //Seekbar listener
                sizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        switch(progress)
                        {
                            case 0: pizzaSizeTextView.setText("12\""); break;
                            case 1: pizzaSizeTextView.setText("14\""); break;
                            case 2: pizzaSizeTextView.setText("16\""); break;
                            case 3: pizzaSizeTextView.setText("18\""); break;
                            case 4: pizzaSizeTextView.setText("20\""); break;
                            case 5: pizzaSizeTextView.setText("22\""); break;
                            case 6: pizzaSizeTextView.setText("24\""); break;
                            case 7: pizzaSizeTextView.setText("26\""); break;
                            case 8: pizzaSizeTextView.setText("28\""); break;
                            case 9: pizzaSizeTextView.setText("30\""); break;
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
    }

    public void update(){
        totalPrice = crustPrice + toppingPrice + deliveryPrice + sizePrice;
        priceTextView.setText("$" + String.valueOf(totalPrice));

    }
}

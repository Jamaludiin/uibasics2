package com.example.uibasics2;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    // define all checkbox in online since they are same
    private CheckBox ckBox1, ckBox2, ckBox3, ckBox4, ckBox5, ckBox6;
    private RadioGroup rdGrpDayNight;

    private ProgressBar progressBar1;
    private ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //----------------------------------------------
        ckBox1 = findViewById(R.id.ckBox1);
        ckBox2 = findViewById(R.id.ckBox2);
        ckBox3 = findViewById(R.id.ckBox3);

        rdGrpDayNight = findViewById(R.id.rdGrpDayNight);

        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);


        //----------------------------------------------
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    progressBar2.incrementProgressBy(10);
                    SystemClock.sleep(500);
                }
            }
        });

        thread.start();

        int progressStatus = progressBar2.getProgress();
        Toast.makeText(this,"Progress " + progressStatus, Toast.LENGTH_SHORT).show();

        //----------------------------------------------
        rdGrpDayNight.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // ERROR IF USED R.id.rdBtnNight: IN THE CASE LEVEL OR SWITCH IS ABUT THE GRADLE ERROR USE IF
                /*  switch (checkedId){
                    case R.id.rdBtnNight:
                        Toast.makeText(MainActivity.this, "It is a Night", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdBtnDay:
                        Toast.makeText(MainActivity.this, "It is a Day", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }*/

                if (checkedId == R.id.rdBtnNight) {
                    Toast.makeText(MainActivity.this, "It is a Night", Toast.LENGTH_SHORT).show();
                    //progressBar2.setVisibility(View.VISIBLE);

                } else if (checkedId == R.id.rdBtnDay) {
                    Toast.makeText(MainActivity.this, "It is a Day", Toast.LENGTH_SHORT).show();
                    progressBar1.setVisibility(View.VISIBLE);
                }
                else if (checkedId == R.id.rdBtnNoneOFthem) {
                    Toast.makeText(MainActivity.this, "It is None of Them", Toast.LENGTH_SHORT).show();
                    progressBar1.setVisibility(View.GONE);
                    //progressBar2.setVisibility(View.GONE);


                }
            }
        });

        //------------------------------------------------
        int checkedRdBtn = rdGrpDayNight.getCheckedRadioButtonId();

        if (checkedRdBtn == R.id.rdBtnNight) {
            Toast.makeText(MainActivity.this, "It is a Night", Toast.LENGTH_SHORT).show();
        } else if (checkedRdBtn == R.id.rdBtnDay) {
            Toast.makeText(MainActivity.this, "It is a Day", Toast.LENGTH_SHORT).show();
        }
        else if (checkedRdBtn == R.id.rdBtnNoneOFthem) {
            Toast.makeText(MainActivity.this, "It is None of Them", Toast.LENGTH_SHORT).show();
        }


        //----------------------------------------------
        // AFTER LOADING THE LAYOUT CHECK THE CHECKBOX CHECKED OR NOT
        if(ckBox1.isChecked()){
            Toast.makeText(this, "You checked the CheckBox 1", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Not checked the CheckBox 1", Toast.LENGTH_SHORT).show();
        }


        //----------------------------------------------
        // create clicklistner
        ckBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You clicked ChekBox 1", Toast.LENGTH_SHORT).show();
            }
        });

        ckBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You clicked ChekBox 2", Toast.LENGTH_SHORT).show();
            }
        });

        ckBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You clicked ChekBox 3", Toast.LENGTH_SHORT).show();
            }
        });


        //----------------------------------------------
        // answers checkbox
        // setOnCheckedChangeListener
        ckBox4 = findViewById(R.id.ckBox4);
        ckBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Answered 1", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Not Answered 1", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ckBox5 = findViewById(R.id.ckBox5);
        ckBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Answered 2", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Not Answered 2", Toast.LENGTH_SHORT).show();
                }
            }
        });


        ckBox6 = findViewById(R.id.ckBox6);
        ckBox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Answered 3", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Not Answered 3", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
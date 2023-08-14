package com.example.trial_unit_converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView cv_temp,cv_len,cv_wt,cv_speed,cv_time,cv_area,cv_vol,cv_press,cv_str,cv_cook;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cv_temp =findViewById(R.id.cv_temp);
        cv_len=findViewById(R.id.cv_len);
        cv_wt=findViewById(R.id.cv_wt);
        cv_speed=findViewById(R.id.cv_speed);
        cv_time=findViewById(R.id.cv_time);
        cv_area=findViewById(R.id.cv_area);
        cv_vol=findViewById(R.id.cv_vol);
        cv_press=findViewById(R.id.cv_press);


        cv_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, temp_cal.class));
            }
        });

        cv_len.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,len_cal.class));
            }
        });

        cv_wt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,wt_cal.class));
            }
        });

        cv_speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,speed_cal.class));
            }
        });

        cv_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,time_cal.class));
            }
        });

        cv_area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,area_cal.class));
            }
        });

        cv_vol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,vol_cal.class));
            }
        });

        cv_press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,press_cal.class));
            }
        });


    }
}
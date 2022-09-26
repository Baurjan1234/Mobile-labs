package com.example.lab2_6dal;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Chronometer chr1;
    Button bt1, bt2;
    RadioButton rd1, rd2;
    CalendarView calv;
    TimePicker tp;
    TextView ty, tm, td, th, tmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chr1 = (Chronometer) findViewById(R.id.chronometer1);
        bt1 = (Button) findViewById(R.id.btnStart);
        bt2 = (Button) findViewById(R.id.Done);
        rd1 = (RadioButton) findViewById(R.id.dateRadio);
        rd2 = (RadioButton) findViewById(R.id.timeRadio);
        calv = (CalendarView) findViewById(R.id.calendarView1);
        tp = (TimePicker) findViewById(R.id.timePicker1);
        ty = (TextView) findViewById(R.id.txt5);
        tm = (TextView) findViewById(R.id.txt3);
        td = (TextView) findViewById(R.id.txt1);
        th = (TextView) findViewById(R.id.txt7);
        tmi = (TextView) findViewById(R.id.txt9);
        tp.setVisibility(View.INVISIBLE);
        calv.setVisibility(View.INVISIBLE);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.raGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rd1.isChecked()) {
                    tp.setVisibility(View.INVISIBLE);
                    calv.setVisibility(View.VISIBLE); }
                else if(rd2.isChecked()) {
                    tp.setVisibility(View.VISIBLE);
                    calv.setVisibility(View.INVISIBLE); }
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chr1.setBase(SystemClock.elapsedRealtime());
                chr1.start();
                chr1.setTextColor(Color.RED);
                java.util.Date curD = new java.util.Date(calv.getDate());
                ty.setText(Integer.toString(1900+curD.getYear()));
                tm.setText(Integer.toString(1+curD.getMonth()));
                td.setText(Integer.toString(curD.getDate())); }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chr1.stop();
                chr1.setTextColor(Color.BLUE);
                th.setText(Integer.toString(tp.getCurrentHour()));
                tmi.setText(Integer.toString(tp.getCurrentMinute())); }
        });
    }



}
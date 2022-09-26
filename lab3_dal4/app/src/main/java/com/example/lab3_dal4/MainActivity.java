package com.example.lab3_dal4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.*;
import android.widget.*;



public class MainActivity extends AppCompatActivity {


    private LinearLayout lay;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        LinearLayout lay;
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        lay = (LinearLayout) findViewById(R.id.baseLayout);
        bt1 = (Button) findViewById(R.id.button1);

    }

    @SuppressLint("ResourceType")
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.layout.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.menu_red:
                lay.setBackgroundColor(Color.RED);
                return true;
            case R.id.menu_green:
                lay.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.menu_blue:
                lay.setBackgroundColor(Color.BLUE);
                return true;
        }
        return false;
    }


}
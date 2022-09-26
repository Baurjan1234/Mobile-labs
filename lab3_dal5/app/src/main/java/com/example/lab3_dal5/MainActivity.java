package com.example.lab3_dal5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    LinearLayout lay;
    private Button bt1, bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lay = (LinearLayout) findViewById(R.id.baseLayout);
        bt1 = (Button) findViewById(R.id.button1);
        bt2 = (Button) findViewById(R.id.button2);
        registerForContextMenu(bt1);
        registerForContextMenu(bt2);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
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
            case R.id.menu_gray:
                bt2.setBackgroundColor(Color.GRAY);
//                lay.setBackgroundColor(Color.GRAY);
                return true;
            case R.id.menu_yellow:
                bt2.setBackgroundColor(Color.YELLOW);
//                lay.setBackgroundColor(Color.YELLOW);
                return true;
        }
        return false;
    }
    @SuppressLint("ResourceType")
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mInflater = getMenuInflater();
        if (v == bt1) {
            menu.setHeaderTitle("Changing the background color");
            mInflater.inflate(R.layout.menu, menu);
        }
        if (v == bt2) {
            mInflater.inflate(R.layout.menu2, menu);
        }
    }
}
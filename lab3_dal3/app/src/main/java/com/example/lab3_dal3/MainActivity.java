package com.example.lab3_dal3;
import androidx.appcompat.app.AppCompatActivity;

import android.app.*;
import android.content.*;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }
}

class MyGridAdapter extends BaseAdapter {
    Context context;
    Integer[] posterID = {R.drawable.cute, R.drawable.boy, R.drawable.farshad, R.drawable.jeremy_bishop, R.drawable.cute};
    public MyGridAdapter(Context c) {
        context = c;
    }
    @Override
    public int getCount() {
        return posterID.length;
    }
    @Override
    public Object getItem(int arg0) {
        return arg0;
    }
    @Override
    public long getItemId(int arg0) {
        return arg0;
    }
    public View getView(int position, View arg1, ViewGroup arg2) {
        final ImageView imView = new ImageView(context);
        imView.setLayoutParams(new GridView.LayoutParams(100,
                150));
        imView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imView.setPadding(5, 5, 5, 5);
        imView.setImageResource(posterID[position]);
        final int pos = position;
        imView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View dialogView = (View) View.inflate(context, R.layout.dialog, null);
                AlertDialog.Builder dbl = new AlertDialog.Builder(context);
                ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                ivPoster.setImageResource(posterID[pos]);
                dbl.setTitle("Томруулсан зураг");
                dbl.setIcon(R.drawable.cute);
                dbl.setView(dialogView);
                dbl.setNegativeButton("Хаах", null);
                dbl.show();
            }
        });
        return imView;
    }
}
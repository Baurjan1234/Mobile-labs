package com.example.demolab2bodlogo;

import static com.example.demolab2bodlogo.MainActivity.CIRCLE;
import static com.example.demolab2bodlogo.MainActivity.LINE;
import static com.example.demolab2bodlogo.MainActivity.curShape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.*;
import android.os.Bundle;
import android.view.*;


public class MainActivity extends AppCompatActivity {

    final static int LINE = 1, CIRCLE = 2;
    static int curShape = LINE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "Drawing line");
        menu.add(0, 2, 0, "Drawing circle");
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case 1: curShape = LINE; return true;
            case 2: curShape = CIRCLE; return true;
        }
        return super.onContextItemSelected(item);
    }


}



 class MyGraphicView extends View {


    int startX = -1, startY = -1, stopX = -1, stopY = -1;


    public MyGraphicView(Context context) {
        super(context);
    }

    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = (int) event.getX();
                startY = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                stopX = (int) event.getX();
                stopY = (int) event.getY();
                this.invalidate();
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        switch (curShape) {
            case LINE:
                canvas.drawLine(startX, startY, stopX, stopY, paint);
                break;
            case CIRCLE:
                int radius = (int) (Math.sqrt(Math.pow(stopX - startX, 2))
                        + Math.sqrt(Math.pow(stopX - startX, 2)));
                canvas.drawCircle(startX, startY, radius, paint);
                break;
        }
    }
}

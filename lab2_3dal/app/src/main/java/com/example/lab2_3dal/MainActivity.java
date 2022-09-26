package com.example.lab2_3dal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {


    EditText nu1, nu2;
    Button addB, subB, multB, divB;
    TextView resT;
    String num1, num2;
    Integer result;
    Button[] btnArray = new Button[10];
    Integer[] btnId = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nu1 = (EditText) findViewById(R.id.number1);
        nu2 = (EditText) findViewById(R.id.number2);
        addB = (Button) findViewById(R.id.btnAdd);
        subB = (Button) findViewById(R.id.btnSub);
        multB = (Button) findViewById(R.id.btnMult);
        divB = (Button) findViewById(R.id.btnDiv);
        resT = (TextView) findViewById(R.id.resText);

        addB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = nu1.getText().toString();
                num2 = nu2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                resT.setText("Result: " + result.toString());
            }
        });
        subB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = nu1.getText().toString();
                num2 = nu2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                resT.setText("Result: " + result.toString());
            }
        });
        multB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = nu1.getText().toString();
                num2 = nu2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                resT.setText("Result: " + result.toString());
            }
        });
        divB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = nu1.getText().toString();
                num2 = nu2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                resT.setText("Result: " + result.toString());
            }
        });
        for(i = 0; i<btnArray.length;i++) {
            btnArray[i] = (Button) findViewById(btnId[i]); }
        for(i = 0; i<btnArray.length;i++){
            final int index; index = i;
            btnArray[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (nu1.isFocused() == true) {
                        num1 = nu1.getText().toString() + btnArray[index].getText().toString();
                        nu1.setText(num1);
                    } else if (nu2.isFocused() == true) {
                        num2 = nu2.getText().toString() + btnArray[index].getText().toString();
                        nu2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(), "Click on the TextEdit", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
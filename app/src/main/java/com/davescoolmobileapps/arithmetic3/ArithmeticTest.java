package com.davescoolmobileapps.arithmetic3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

import static com.davescoolmobileapps.arithmetic3.R.id.textView3;
import static com.davescoolmobileapps.arithmetic3.R.id.textView4;
import static com.davescoolmobileapps.arithmetic3.R.id.textView5;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class ArithmeticTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arithmetic_test);
        Bundle extras = getIntent().getExtras();
        int level = parseInt(extras.getString("LEVEL"));
        String probType = extras.getString("PROB_TYPE");
        TextView tv5 = (TextView) findViewById(textView5);
        Random rnd = new Random();
        int a=0,b=0,result;
        if (probType.compareTo("Addition") == 0)
        {
            tv5.setText("+");
            int min = level==1?0:(int) pow(10,level-1);
            int max = (int) pow(10,level) -1;
            a = min + rnd.nextInt(max-min);
            b = min + rnd.nextInt(max-min);
            result=a+b;
        }
        else if (probType.compareTo("Subtraction") == 0)
        {
            tv5.setText("-");
        }
        TextView tv3 = (TextView) findViewById(textView3);
        tv3.setText(""+a);
        TextView tv4 = (TextView) findViewById(textView4);
        tv4.setText(""+b);
    }
}

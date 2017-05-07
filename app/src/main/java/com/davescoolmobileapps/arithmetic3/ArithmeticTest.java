package com.davescoolmobileapps.arithmetic3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import static com.davescoolmobileapps.arithmetic3.R.id.stuGuess;
import static com.davescoolmobileapps.arithmetic3.R.id.textView3;
import static com.davescoolmobileapps.arithmetic3.R.id.textView4;
import static com.davescoolmobileapps.arithmetic3.R.id.textView5;
import static com.davescoolmobileapps.arithmetic3.R.id.textView6;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class ArithmeticTest extends AppCompatActivity {

    int result,level,counter=0;
    String probType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arithmetic_test);
        Bundle extras = getIntent().getExtras();
        level = parseInt(extras.getString("LEVEL"));
        probType = extras.getString("PROB_TYPE");
        changeProb();
    }
    protected void compareResult(View view){
        EditText et1 = (EditText) findViewById(stuGuess);
        int guess = parseInt(et1.getText().toString());
        TextView tv6 = (TextView) findViewById(textView6);
        if(guess == result){
            counter++;
            tv6.setText("Good Job!");
            if(counter < 10)
                changeProb();
        }
        else{
            tv6.setText("Try again");
        }
        et1.setText("");
    }
    protected void changeProb(){
        TextView tv5 = (TextView) findViewById(textView5);
        Random rnd = new Random();
        int a=0,b=0;
        int min = level==(int) pow(10,level-1);
        int max = (int) pow(10,level) -1;
        a = min + rnd.nextInt(max-min);
        b = min + rnd.nextInt(max-min);
        if (probType.compareTo("Addition") == 0)
        {
            tv5.setText("+");
            result=a+b;
        }
        else if (probType.compareTo("Subtraction") == 0)
        {
            result=a;
            a+=b;
            tv5.setText("-");
        }
        else if (probType.compareTo("Multiplication") == 0)
        {
            tv5.setText("*");
            result=a*b;
        }
        else
        {
            result=a;
            a*=b;
            tv5.setText("/");
        }
        TextView tv3 = (TextView) findViewById(textView3);
        tv3.setText(""+a);
        TextView tv4 = (TextView) findViewById(textView4);
        tv4.setText(""+b);
    }
}

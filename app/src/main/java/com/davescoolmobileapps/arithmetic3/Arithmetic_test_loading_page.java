package com.davescoolmobileapps.arithmetic3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import static com.davescoolmobileapps.arithmetic3.R.id.difficulty_spinner;
import static com.davescoolmobileapps.arithmetic3.R.id.problem_type_spinner;
import static com.davescoolmobileapps.arithmetic3.R.id.textView7;

public class Arithmetic_test_loading_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arithmetic_test_loading_page);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //switch(requestCode) {
            //case (STATIC_INTEGER_VALUE) : {
                if (resultCode == Activity.RESULT_OK) {
                    int score;
                    score = data.getIntExtra("SCORE",0);
                    TextView tv7 = (TextView) findViewById(textView7);
                    tv7.setText("Your score is "+score+"%");
                }
                //break;
            //}
        //}
    }

    public void launchMathQuiz(View view) {
        Intent intent = new Intent(this, ArithmeticTest.class);
        Spinner ds = (Spinner) findViewById(difficulty_spinner);
        Spinner pts = (Spinner) findViewById(problem_type_spinner);
        intent.putExtra("LEVEL", ds.getSelectedItem().toString());
        intent.putExtra("PROB_TYPE", pts.getSelectedItem().toString());
        startActivityForResult(intent,0);
    }

}

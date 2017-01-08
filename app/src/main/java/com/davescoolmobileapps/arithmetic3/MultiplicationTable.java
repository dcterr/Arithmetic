package com.davescoolmobileapps.arithmetic3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MultiplicationTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication_table);
    }

    public void prod(View view) {
        EditText viewX = (EditText) findViewById(R.id.x);
        EditText viewY = (EditText) findViewById(R.id.y);
        if ( viewX.getText().length() == 0 || viewY.getText().length() == 0 ) return;
        String xText = viewX.getText().toString();
        String yText = viewY.getText().toString();
        int X = Integer.parseInt(xText);
        int Y = Integer.parseInt(yText);
        int Z = X * Y;
        TextView viewProduct = (TextView) findViewById(R.id.z);
        viewProduct.setText(Integer.toString(Z));
    }
}

package com.jetpack.androidx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView jsonResponseTxt = (TextView) findViewById(R.id.idJsonResponse);
//        jsonResponseTxt.setText("");

    }
}
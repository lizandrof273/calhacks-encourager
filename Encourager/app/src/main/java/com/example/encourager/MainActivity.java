package com.example.encourager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button submitButton;
    private TextView encourgmentTv;
    private TextView setTv;
    private ArrayList<String> wordsOfEncourgment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String> wordsOfEncourgment = new ArrayList<String>();

        submitButton = findViewById(R.id.submitButton);
        encourgmentTv = findViewById(R.id.encourgmentTv);
        setTv = findViewById(R.id.setTv);

        wordsOfEncourgment.add("hello");

        //submitButton.setOnClickListener((View.OnClickListener) this);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTv.setText(wordsOfEncourgment.get(0));
            }
        });

    }
}

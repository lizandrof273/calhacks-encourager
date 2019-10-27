package com.example.encourager;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.transition.Transition;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button submitButton;
    private TextView encourgmentTv;
    private TextView setTv;
    private ArrayList<String> wordsOfEncourgment;
    private ImageView bg;
    private int[] backgrounds;
    private Drawable[] current;
    private int prev;
    private int next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String> wordsOfEncourgment = new ArrayList<String>();
        backgrounds = new int[] { R.drawable.beach, R.drawable.rock_ocean, R.drawable.snow_hill,
                                 R.drawable.sun_trees

        };

        submitButton = findViewById(R.id.submitButton);
        encourgmentTv = findViewById(R.id.encourgmentTv);
        setTv = findViewById(R.id.setTv);
        bg = findViewById(R.id.imageView);

        wordsOfEncourgment.add("hello");

        //submitButton.setOnClickListener((View.OnClickListener) this);

        next = (int) (Math.random() * backgrounds.length);
        current = new Drawable[] {bg.getDrawable(),
                getResources().getDrawable(backgrounds[next])};

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTv.setText(wordsOfEncourgment.get(0));
                nextTransition();

            }
        });


    }

    public void nextTransition() {
        TransitionDrawable transition = new TransitionDrawable(current);
        bg.setImageDrawable(transition);
        transition.startTransition(2000);
        prev = next;
        current[0] = getResources().getDrawable(backgrounds[prev]);
        while (prev == next) {
            next = (int) (Math.random() * backgrounds.length);
        }
        current[1] = getResources().getDrawable(backgrounds[next]);
    }
}

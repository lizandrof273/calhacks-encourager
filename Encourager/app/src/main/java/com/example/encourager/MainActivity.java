package com.example.encourager;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.transition.Transition;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button submitButton;
    private TextView setTv;
    private ArrayList<String> wordsOfEncourgment;
    private ImageView bg;
    private int[] backgrounds;
    private Drawable[] current;
    private int prev;
    private int next;
    private int randIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String> wordsOfEncourgment = new ArrayList<String>();
        backgrounds = new int[] { R.drawable.beach, R.drawable.rock_ocean, R.drawable.snow_hill,
                                 R.drawable.sun_trees

        };

        submitButton = findViewById(R.id.submitButton);
        setTv = findViewById(R.id.setTv);
        bg = findViewById(R.id.imageView);

        wordsOfEncourgment.add("Trust the process.");
        wordsOfEncourgment.add("If it’s meant to be, it’ll happen.");
        wordsOfEncourgment.add( "Take 12 deep breaths.");
        wordsOfEncourgment.add("Sometimes a break is the best idea");
        wordsOfEncourgment.add("Close your eyes and picture your happy place.");
        wordsOfEncourgment.add("Try making a checklist of everything on your mind.");
        wordsOfEncourgment.add("It’s ok, it really is.");
        wordsOfEncourgment.add("You can do it!");
        wordsOfEncourgment.add("I believe in you!");
        wordsOfEncourgment.add("Remember your goal!");
        wordsOfEncourgment.add(" It does not matter how slowly you go as long as you do not stop.");
        wordsOfEncourgment.add("Lose the fear of being wrong.");
        wordsOfEncourgment.add("You are capable.");
        wordsOfEncourgment.add("It’s never too late to start.");
        wordsOfEncourgment.add("Good things come to people who wait, but better things come to those who go out and get them.");
        wordsOfEncourgment.add("If you do what you always did, you will get what you always got.");
        wordsOfEncourgment.add("There’s no lemon too sour to turn into lemonade.");
        wordsOfEncourgment.add("If you are not willing to risk the usual you will have to settle for the ordinary.");
        wordsOfEncourgment.add("Opportunities don’t happen, you create them.");
        wordsOfEncourgment.add("Keep trying your best and doing good, and you won’t stray too far from your dreams.");
        wordsOfEncourgment.add("Do it for the ones looking up to you.");
        wordsOfEncourgment.add("Everything happens for a reason.");
        wordsOfEncourgment.add("Look for the light in the darkness.");
        wordsOfEncourgment.add("Focus on those who love you.");
        wordsOfEncourgment.add("Success is walking from failure to failure with no loss of enthusiasm.");
        wordsOfEncourgment.add("Just when the caterpillar thought the world was ending, he turned into a butterfly.");
        wordsOfEncourgment.add("You really have done so much and come so far.");


        next = (int) (Math.random() * backgrounds.length);
        current = new Drawable[] {bg.getDrawable(),
                getResources().getDrawable(backgrounds[next])};

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                randIndex = rand.nextInt(wordsOfEncourgment.size());
                setTv.setText(wordsOfEncourgment.get(randIndex));
                setTv.setBackgroundColor(Color.BLACK);
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


    public void addEncourgment() {

    }
}

package com.example.tuttifruitti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Difficulty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);

        Button playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Liaison avec l'activité GameActivity
                Intent intent = new Intent("com.example.tuttifruitti.GameActivity");
                startActivity(intent);
            }
        });


        //chooseLevel();


        Button returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Liaison avec l'activité MainActivity (menu principal)
                Intent intent = new Intent("com.example.tuttifruitti.MainActivity");
                startActivity(intent);
            }
        });


    }

    public void chooseLevel() {
        RadioButton myButton = null;
        if (myButton == findViewById(R.id.radioButtonEasy)) {

            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent("com.example.tuttifruitti.Difficulty");
                    startActivity(intent1);
                    TextView tries = findViewById(R.id.tries);
                    tries.setText("10");
                    //play();

                }
            });
        } else if (myButton == findViewById(R.id.radioButtonMedium)) {

            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent("com.example.tuttifruitti.Difficulty");
                    startActivity(intent1);
                    TextView tries = findViewById(R.id.tries);
                    tries.setText("7");
                    //play();

                }
            });
        } else if (myButton == findViewById(R.id.radioButtonHard)) {

            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent("com.example.tuttifruitti.Difficulty");
                    startActivity(intent1);
                    TextView tries = findViewById(R.id.tries);
                    tries.setText("5");
                    //play();

                }
            });
        } else {
            throw new IllegalStateException("Unexpected value: " + myButton);
        }
    }


}



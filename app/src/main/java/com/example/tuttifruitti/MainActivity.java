package com.example.tuttifruitti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button startButton = findViewById(R.id.bt_start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Liaison avec l'activité Difficulty
                Intent intent = new Intent("com.example.tuttifruitti.GameActivity");
                startActivity(intent);
                }
            });

        Button scoreButton = findViewById(R.id.bt_score);
        scoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // créer l'activité pour le score et set contentview de l'activité correspondante
            }
        });


        Button quitButton = findViewById(R.id.bt_quit);
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });



        }




    }


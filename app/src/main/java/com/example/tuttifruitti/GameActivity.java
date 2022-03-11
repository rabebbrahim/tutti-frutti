package com.example.tuttifruitti;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    ArrayList<DataSources> dataSourceArrayList;
    String randomFruit1,randomFruit2,randomFruit3,randomFruit4;
    String spinnerChoice1,spinnerChoice2,spinnerChoice3,spinnerChoice4;
    public String[] arrayRandomFruit = {randomFruit1, randomFruit2, randomFruit3, randomFruit4};
    public String[] arrayChoices={spinnerChoice1,spinnerChoice2,spinnerChoice3,spinnerChoice4};
    public Map<String,Drawable > associate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getRandomFruit();
        associate = new HashMap<>();
        associate.put(getResources().getStringArray(R.array.fruitsSelection)[0],getResources().getDrawable(R.drawable.prune));
        associate.put(getResources().getStringArray(R.array.fruitsSelection)[1],getResources().getDrawable(R.drawable.fraise));
        associate.put(getResources().getStringArray(R.array.fruitsSelection)[2],getResources().getDrawable(R.drawable.orange));
        associate.put(getResources().getStringArray(R.array.fruitsSelection)[3],getResources().getDrawable(R.drawable.framboises));
        associate.put(getResources().getStringArray(R.array.fruitsSelection)[4],getResources().getDrawable(R.drawable.kiwi));
        associate.put(getResources().getStringArray(R.array.fruitsSelection)[5],getResources().getDrawable(R.drawable.citron));
        associate.put(getResources().getStringArray(R.array.fruitsSelection)[6],getResources().getDrawable(R.drawable.raisins));
        associate.put(getResources().getStringArray(R.array.fruitsSelection)[7],getResources().getDrawable(R.drawable.bananes));
        //getResult();

        Button validateChoiceButton = findViewById(R.id.validateChoiceButton);
        validateChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] userEntryChoice;


                // Selectionner le choix du spinner et le transformer en string pour l'ajouter au tableau userEntryChoice
               getChoices();
                playGame();


            }
        });


        Button returnMenuButton = findViewById(R.id.menuReturnButton);
        returnMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Liaison avec l'activité MainActivity (menu principal)
                Intent intent = new Intent("com.example.tuttifruitti.MainActivity");
                startActivity(intent);
            }
        });


        Spinner myspinner1 = findViewById(R.id.spinnerChoice1);
        myspinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                myspinner1.getItemAtPosition(position);
                ImageView myImg = findViewById(R.id.prop1);
                myImg.setImageDrawable(associate.get(myspinner1.getItemAtPosition(position)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        Spinner myspinner2 = findViewById(R.id.spinnerChoice2);
        myspinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                myspinner2.getItemAtPosition(position);
                ImageView myImg = findViewById(R.id.prop2);
                myImg.setImageDrawable(associate.get(myspinner2.getItemAtPosition(position)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        Spinner myspinner3 = findViewById(R.id.spinnerChoice3);
        myspinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                myspinner3.getItemAtPosition(position);
                ImageView myImg = findViewById(R.id.prop3);
                myImg.setImageDrawable(associate.get(myspinner3.getItemAtPosition(position)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        Spinner myspinner4 = findViewById(R.id.spinnerChoice4);
        myspinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                myspinner4.getItemAtPosition(position);
                ImageView myImg = findViewById(R.id.prop4);
                myImg.setImageDrawable(associate.get(myspinner4.getItemAtPosition(position)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        Button changeDifficultyButton = findViewById(R.id.changeDifficultyButton);
        changeDifficultyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.tuttifruitti.Difficulty");
                startActivity(intent);
            }
        });


        RecyclerView rvDataSources = (RecyclerView) findViewById(R.id.recyclerViewData);
        dataSourceArrayList = DataSources.createsDataSourcesList(1);
        MyAdapter dataAdapter = new MyAdapter(dataSourceArrayList);
        rvDataSources.setAdapter(dataAdapter);
        rvDataSources.setLayoutManager(new LinearLayoutManager(this));


    }


      public void getRandomFruit() {
          String[] array = getResources().getStringArray(R.array.fruitsSelection);


          //do{
          String[] arrayRandomFruit = {randomFruit1, randomFruit2, randomFruit3, randomFruit4};


          randomFruit1 = array[new Random().nextInt(array.length)];
          randomFruit2 = array[new Random().nextInt(array.length)];
          randomFruit3 = array[new Random().nextInt(array.length)];
          randomFruit4 = array[new Random().nextInt(array.length)];

          //}while (!(randomFruit1.equals(randomFruit2)) && !(randomFruit1.equals(randomFruit3)) && !(randomFruit1.equals(randomFruit4)) && !(randomFruit2.equals(randomFruit3)) && !(randomFruit2.equals(randomFruit4)) && !(randomFruit3.equals(randomFruit4)));
          TextView myRan = findViewById(R.id.testrandom);
          myRan.setText("Random : " + randomFruit1 + " - " + randomFruit2 + " - " + randomFruit3 + " - " + randomFruit4);

      }


        // Méthode permettant de recuperer les choices de fruits
        public void getChoices(){
            String[] array = getResources().getStringArray(R.array.fruitsSelection);
            Spinner mySpinnerChoice1 = (Spinner) findViewById(R.id.spinnerChoice1);
            spinnerChoice1 = mySpinnerChoice1.getSelectedItem().toString();

            Spinner mySpinnerChoice2 = (Spinner) findViewById(R.id.spinnerChoice2);
            spinnerChoice2 = mySpinnerChoice2.getSelectedItem().toString();

            Spinner mySpinnerChoice3 = (Spinner) findViewById(R.id.spinnerChoice3);
            spinnerChoice3 = mySpinnerChoice3.getSelectedItem().toString();

            Spinner mySpinnerChoice4 = (Spinner) findViewById(R.id.spinnerChoice4);
            spinnerChoice4 = mySpinnerChoice4.getSelectedItem().toString();

            String[] userEntryChoice = {spinnerChoice1, spinnerChoice2, spinnerChoice3, spinnerChoice4};

            TextView choixUser1 = findViewById(R.id.printChoice1);
            choixUser1.setText(userEntryChoice[0]);

            TextView choixUser2 = findViewById(R.id.printChoice2);
            choixUser2.setText(userEntryChoice[1]);

            TextView choixUser3 = findViewById(R.id.printChoice3);
            choixUser3.setText(userEntryChoice[2]);

            TextView choixUser4 = findViewById(R.id.printChoice4);
            choixUser4.setText(userEntryChoice[3]);
        }



        //public static String[] getUserEntryChoiceArray() {
        //return arrayChoices;
        //}


        // Methode pour pour comparer le user choice et le random result
     public void setScore(){

     for (int i = 1; i <9 ; i++) {
        TextView score = findViewById(R.id.scoreNumber);
        score.setText(i);

    }
}
     public void setTries(){

     }

    public void playGame(){

           //if ((randomFruit1.equals(spinnerChoice1) && randomFruit2.equals(spinnerChoice2)) && (randomFruit3.equals(spinnerChoice3)) && (randomFruit4.equals(spinnerChoice4)) ) {
        String[] arrayRandomFruit = {randomFruit1, randomFruit2, randomFruit3, randomFruit4};
        String[] arrayChoices={spinnerChoice1,spinnerChoice2,spinnerChoice3,spinnerChoice4};
        for (int i = 0; i < arrayRandomFruit.length; i++) {
            for (int j = 0; j < arrayChoices.length; j++) {
                if (!arrayRandomFruit[0].equals(arrayChoices[0]) || (!arrayRandomFruit[1].equals(arrayChoices[1])) || (!arrayRandomFruit[2].equals(arrayChoices[2])) || (!arrayRandomFruit[3].equals(arrayChoices[3]))) {
                    if ((arrayRandomFruit[0].equals(arrayChoices[j]) && j!=0 ) || (arrayRandomFruit[1].equals(arrayChoices[j]) && j!=1 ) ||
                    (arrayRandomFruit[2].equals(arrayChoices[j]) && j!=2 ) || (arrayRandomFruit[3].equals(arrayChoices[j]) && j!=3 )){
                        new AlertDialog.Builder(this)
                                .setTitle(" OK :)")
                                .setMessage("you have a good Choice in a Bad Place ")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        Intent intent2 = new Intent("com.example.tuttifruitti.GameActivity");
                                        startActivity(intent2);
                                        Toast.makeText(getApplicationContext(),"Please try Chosing again !", Toast.LENGTH_LONG).show();
                                        finish();
                                    }
                                })
                                .show();
                    }
                    else if(!(arrayRandomFruit[i].equals(arrayChoices[j])) && (i==j || i!=j)){
                        new AlertDialog.Builder(this)
                                .setTitle(" OUPS !!! :( ")
                                .setMessage(" OUPS !!! There are No Good CHOICE , Please choose other items !!! ")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        Intent intent2 = new Intent("com.example.tuttifruitti.GameActivity");
                                        startActivity(intent2);
                                        Toast.makeText(getApplicationContext(),"Choice other items !", Toast.LENGTH_LONG).show();
                                        finish();
                                    }
                                })
                                .show();

                    }
                } else {
                    new AlertDialog.Builder(this)
                            .setTitle("Well Done!!! :)")
                            .setMessage("All fruits are well placed ")
                            .setPositiveButton("Re-Play", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent1 = new Intent("com.example.tuttifruitti.Difficulty");
                                    startActivity(intent1);
                                    Toast.makeText(getApplicationContext(),"Please replay again !", Toast.LENGTH_LONG).show();
                                    setScore();
                                    finish();
                                }
                            })
                            .show();

                }


            }
        }



       // }

    }





}

//RecyclerView recyclerView;

// String s1 [];
// int images [] = {R.drawable.bananes, R.drawable.citron, R.drawable.fraise, R.drawable.framboises,
// R.drawable.kiwi, R.drawable.orange, R.drawable.prune, R.drawable.raisins};
// @Override
// protected void onCreate(Bundle savedInstanceState) {
// super.onCreate(savedInstanceState);
// setContentView(R.layout.activity_game2);
// recyclerView.findViewById(R.id.recyclerView);
// s1 = getResources().getStringArray(R.array.fruitsSelection);
// MyAdapter myAdapter = new MyAdapter(this, s1, images);






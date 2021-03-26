package com.example.colormemory2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;


import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class ModeDifficile extends AppCompatActivity {

    Random rand = new Random();
    private Button[] btns = new Button[15];
    int[] nombreAleatoire = new int[15];
    int[] PlayerBlock = new int[15];
    int maxBlock = 0;
    Handler handler = new Handler();
    TextView t1;
    TextView t2;
    int point = 0;
    int NbVie = 2;
    int iteration = 0;
    int compteurPoint = 0;
    int niveau = 1;
    int colorindex = 0;
    int nombreBlock = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_difficile);

        t1 = (TextView) findViewById(R.id.Nbvie);
        t2 = (TextView) findViewById(R.id.point);
        btns[0]= findViewById(R.id.btn1);
        btns[1] = findViewById(R.id.btn2);
        btns[2] = findViewById(R.id.btn3);
        btns[3] = findViewById(R.id.btn4);
        btns[4] = findViewById(R.id.btn5);
        btns[5] = findViewById(R.id.btn6);
        btns[6] = findViewById(R.id.btn7);
        btns[7] = findViewById(R.id.btn8);
        btns[8] = findViewById(R.id.btn9);
        btns[9]= findViewById(R.id.btn10);
        btns[10] = findViewById(R.id.btn11);
        btns[11] = findViewById(R.id.btn12);
        btns[12] = findViewById(R.id.btn13);
        btns[13] = findViewById(R.id.btn14);
        btns[14] = findViewById(R.id.btn15);

        btns[0].setBackgroundColor(Color.BLUE);
        btns[1].setBackgroundColor(Color.RED);
        btns[2].setBackgroundColor(Color.GREEN);
        btns[3].setBackgroundColor(Color.YELLOW);
        btns[4].setBackgroundColor(Color.BLUE);
        btns[5].setBackgroundColor(Color.BLUE);
        btns[6].setBackgroundColor(Color.YELLOW);
        btns[7].setBackgroundColor(Color.GREEN);
        btns[8].setBackgroundColor(Color.BLUE);
        btns[9].setBackgroundColor(Color.RED);
        btns[10].setBackgroundColor(Color.GREEN);
        btns[11].setBackgroundColor(Color.BLUE);
        btns[12].setBackgroundColor(Color.RED);
        btns[13].setBackgroundColor(Color.YELLOW);
        btns[14].setBackgroundColor(Color.GREEN);


        game();


    }


    public void RandomBlock() {
        for (int idx = 0; idx < maxBlock; idx++) {
            nombreAleatoire[idx] = rand.nextInt(nombreBlock) ;
        }
    }

    Runnable ButtonColor = new Runnable() {
        @Override
        public void run() {

            btns[nombreAleatoire[colorindex]].setBackgroundColor(Color.BLACK);
            colorindex++;
        }
    };

    Runnable ButtonColorNormal = new Runnable() {
        @Override
        public void run() {
            btns[1].setBackgroundColor(Color.RED);
            btns[2].setBackgroundColor(Color.GREEN);
            btns[3].setBackgroundColor(Color.YELLOW);
            btns[4].setBackgroundColor(Color.BLUE);
            btns[5].setBackgroundColor(Color.BLUE);
            btns[6].setBackgroundColor(Color.YELLOW);
            btns[7].setBackgroundColor(Color.GREEN);
            btns[8].setBackgroundColor(Color.BLUE);
            btns[9].setBackgroundColor(Color.RED);
            btns[10].setBackgroundColor(Color.GREEN);
            btns[11].setBackgroundColor(Color.BLUE);
            btns[12].setBackgroundColor(Color.RED);
            btns[13].setBackgroundColor(Color.YELLOW);
            btns[14].setBackgroundColor(Color.GREEN);
            btns[0].setBackgroundColor(Color.BLUE);
        }
    };


    public void test()
    {

        if (iteration < maxBlock)
        {
            if(PlayerBlock[iteration] == nombreAleatoire[iteration])
            {
                compteurPoint ++;
                iteration++;
                Toast.makeText(getApplicationContext(), "Bravo", Toast.LENGTH_LONG).show();

            }
            else{
                compteurPoint--;
                iteration++;
            }
        }
        if(iteration==maxBlock) {
            if (compteurPoint == maxBlock) {
                niveau += 1;
                point += 1 * niveau;
                game();
            } else {
                niveau = 1;
                NbVie -= 1;
                game();
            }
        }



    }






    public void CLickJoueur(){

        btns[0].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PlayerBlock[iteration] = 0;
                test();
                Toast.makeText(getApplicationContext(), ""+nombreAleatoire[0], Toast.LENGTH_LONG).show();
                t1.setText("nombre de vie: "+NbVie);
                t2.setText("Point: "+point);

            }
        });

        btns[1].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PlayerBlock[iteration] = 1;
                test();
                Toast.makeText(getApplicationContext(), ""+nombreAleatoire[0], Toast.LENGTH_LONG).show();

                t1.setText("nombre de vie: "+NbVie);
                t2.setText("Point: "+point);

            }
        });

        btns[2].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PlayerBlock[iteration] = 2;
                test();
                Toast.makeText(getApplicationContext(), ""+nombreAleatoire[0], Toast.LENGTH_LONG).show();

                t1.setText("nombre de vie: "+NbVie);
                t2.setText("Point: "+point);

            }
        });

        btns[3].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PlayerBlock[iteration] = 3;
                test();
                t1.setText("nombre de vie: "+NbVie);
                t2.setText("Point: "+point);

            }
        });

        btns[4].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PlayerBlock[iteration] = 4;
                test();

                t1.setText("nombre de vie: "+NbVie);
                t2.setText("Point: "+point);

            }
        });

        btns[5].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PlayerBlock[iteration] = 5;
                test();

                t1.setText("nombre de vie: "+NbVie);
                t2.setText("Point: "+point);

            }
        });

        btns[6].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PlayerBlock[iteration] = 6;
                test();

                t1.setText("nombre de vie: "+NbVie);
                t2.setText("Point: "+point);

            }
        });

        btns[7].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PlayerBlock[iteration] = 7;
                test();

                t1.setText("nombre de vie: "+NbVie);
                t2.setText("Point: "+point);

            }
        });
        btns[8].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PlayerBlock[iteration] = 8;
                test();

                t1.setText("nombre de vie: "+NbVie);
                t2.setText("Point: "+point);

            }
        });
        btns[9].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PlayerBlock[iteration] = 9;
                test();

                t1.setText("nombre de vie: "+NbVie);
                t2.setText("Point: "+point);

            }
        });

        btns[10].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PlayerBlock[iteration] = 10;
                test();

                t1.setText("nombre de vie: "+NbVie);
                t2.setText("Point: "+point);

            }
        });

        btns[11].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PlayerBlock[iteration] = 11;
                test();

                t1.setText("nombre de vie: "+NbVie);
                t2.setText("Point: "+point);

            }
        });

        btns[12].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PlayerBlock[iteration] = 12;
                test();

                t1.setText("nombre de vie: "+NbVie);
                t2.setText("Point: "+point);

            }
        });

        btns[13].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PlayerBlock[iteration] = 13;
                test();

                t1.setText("nombre de vie: "+NbVie);
                t2.setText("Point: "+point);

            }
        });

        btns[14].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PlayerBlock[iteration] = 14;
                test();

                t1.setText("nombre de vie: "+NbVie);
                t2.setText("Point: "+point);

            }
        });
    }

    public void  game()
    {
        if(NbVie != 0) {


            t1.setText("nombre de vie: " + NbVie);
            t2.setText("Point: " + point);
            colorindex = 0;
            iteration = 0;
            compteurPoint = 0;
            maxBlock += 1;
            RandomBlock();
            handler.postDelayed(ButtonColor, 2000);
            handler.postDelayed(ButtonColorNormal, 2400);
            if (maxBlock > 1) {
                handler.postDelayed(ButtonColor, 2700);
                handler.postDelayed(ButtonColorNormal, 3100);
            }
            if (maxBlock > 2) {
                handler.postDelayed(ButtonColor, 3400);
                handler.postDelayed(ButtonColorNormal, 3800);
            }
            if (maxBlock > 3) {
                handler.postDelayed(ButtonColor, 4100);
                handler.postDelayed(ButtonColorNormal, 4500);
            }
            if (maxBlock > 4) {
                handler.postDelayed(ButtonColor, 4800);
                handler.postDelayed(ButtonColorNormal, 5200);
            }
            if (maxBlock > 5) {
                handler.postDelayed(ButtonColor, 5500);
                handler.postDelayed(ButtonColorNormal, 5900);
            }
            if (maxBlock > 6) {
                handler.postDelayed(ButtonColor, 6200);
                handler.postDelayed(ButtonColorNormal, 6600);
            }
            if (maxBlock > 7) {
                handler.postDelayed(ButtonColor, 6900);
                handler.postDelayed(ButtonColorNormal, 7300);
            }
            if (maxBlock > 8) {
                handler.postDelayed(ButtonColor, 7600);
                handler.postDelayed(ButtonColorNormal, 8000);
            }
            if (maxBlock > 9) {
                handler.postDelayed(ButtonColor, 8300);
                handler.postDelayed(ButtonColorNormal, 8700);
            }

            if (maxBlock > 10) {
                handler.postDelayed(ButtonColor, 9000);
                handler.postDelayed(ButtonColorNormal, 9400);
            }

            if (maxBlock > 11) {
                handler.postDelayed(ButtonColor, 9700);
                handler.postDelayed(ButtonColorNormal, 10000);
            }

            if (maxBlock > 12) {
                handler.postDelayed(ButtonColor, 10300);
                handler.postDelayed(ButtonColorNormal, 10700);
            }

            if (maxBlock > 13) {
                handler.postDelayed(ButtonColor, 11000);
                handler.postDelayed(ButtonColorNormal, 11400);
            }

            if (maxBlock > 14) {
                handler.postDelayed(ButtonColor, 11700);
                handler.postDelayed(ButtonColorNormal, 12100);
            }
            CLickJoueur();

            if((niveau>1)&&(niveau<12))
            {
                btns[niveau+1].setVisibility(View.VISIBLE);
            }

        }
        else{
            Toast.makeText(getApplicationContext(), "Perdu", Toast.LENGTH_LONG).show();
        }




    }




}


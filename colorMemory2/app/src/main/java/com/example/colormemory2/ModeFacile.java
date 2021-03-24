package com.example.colormemory2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class ModeFacile extends AppCompatActivity {

    Random rand = new Random();
    private Button[] btns = new Button[10];
    int[] nombreAleatoire = new int[10];
    int[] PlayerBlock = new int[10];
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
    int nombreBlock = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.Nbvie);
        t2 = (TextView) findViewById(R.id.point);
        btns[1] = findViewById(R.id.btn1);
        btns[2] = findViewById(R.id.btn2);
        btns[3] = findViewById(R.id.btn3);
        btns[4] = findViewById(R.id.btn4);
        btns[5] = findViewById(R.id.btn5);
        btns[6] = findViewById(R.id.btn6);
        btns[7] = findViewById(R.id.btn7);
        btns[8] = findViewById(R.id.btn8);
        btns[9]= findViewById(R.id.btn9);
        btns[0]= findViewById(R.id.btn10);

        btns[1].setBackgroundColor(Color.RED);
        btns[2].setBackgroundColor(Color.GREEN);
        btns[3].setBackgroundColor(Color.YELLOW);
        btns[4].setBackgroundColor(Color.BLUE);
        btns[5].setBackgroundColor(Color.BLUE);
        btns[6].setBackgroundColor(Color.YELLOW);
        btns[7].setBackgroundColor(Color.GREEN);
        btns[8].setBackgroundColor(Color.BLUE);
        btns[9].setBackgroundColor(Color.RED);
        btns[0].setBackgroundColor(Color.GREEN);

        game();


    }


    public void RandomBlock() {
        for (int idx = 0; idx < maxBlock; idx++) {
            nombreAleatoire[idx] = rand.nextInt(nombreBlock) + 1;
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
            btns[0].setBackgroundColor(Color.GREEN);
        }
    };


    public void test()
    {

        if (iteration < maxBlock)
        {
            if(PlayerBlock[iteration] == nombreAleatoire[iteration])
            {
                compteurPoint ++;
                Toast.makeText(getApplicationContext(), "Bravo", Toast.LENGTH_LONG).show();
            }
            else{
                compteurPoint--;
            }
        }

        if(compteurPoint == maxBlock-1)
        {
            niveau+=1;
            point+=1*niveau;
            game();
        }
        else{
            niveau = 1;
            NbVie -= 1;
            game();
        }







    }


    public void CLickJoueur(){

        btns[1].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PlayerBlock[iteration] = 1;
                test();
                t1.setText("nombre de vie: "+NbVie);
                t2.setText("Point: "+point);

            }
        });

        btns[2].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PlayerBlock[iteration] = 2;
                test();
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
            CLickJoueur();
        }
        else{
            Toast.makeText(getApplicationContext(), "Perdu", Toast.LENGTH_LONG).show();
        }




    }




}


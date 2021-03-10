package com.example.memorycolor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;




public class MainActivity extends AppCompatActivity {

    Random rand = new Random();
    private Button[] btns = new Button[10];
    int nbBlock = 4;
    int [] nombreAleatoire= new int[10];
    int [] PlayerBlock= new int[10];
    int nbBlockIlumine = 0;
    int maxBlock = 1;
    boolean test;
    Handler handler = new Handler();
    TextView t1;
    int NbVie = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.Nbvie);
        btns[1] = findViewById(R.id.btn1);
        btns[2] = findViewById(R.id.btn2);
        btns[3] = findViewById(R.id.btn3);
        btns[4] = findViewById(R.id.btn4);
        nbBlockIlumine += 2;
        game();
        if (test)
        {
            btns[1].setBackgroundColor(Color.BLACK);
        }
        else{
            NbVie -=1;

        }
    }



    public void RandomBlock()
    {
        for (int idx=0; idx<maxBlock; idx++){
            nombreAleatoire[idx] = rand.nextInt(4)+1;
        }
    }

    public  void  SimonSay()
    {

        for (int idx=0; idx<nbBlockIlumine; idx++)
        {
            if (nombreAleatoire[idx] == 1){

                Thread chrono = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        btns[1].setBackgroundColor(Color.RED);
                    }
                });

                chrono.start();
                Thread chrono2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        btns[1].setBackgroundColor(Color.GREEN);
                    }
                });
                chrono2.start();
            }

            if (nombreAleatoire[idx] == 2){

                Thread chrono = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        btns[2].setBackgroundColor(Color.RED);
                    }
                });

                chrono.start();
                Thread chrono2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(4200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        btns[2].setBackgroundColor(Color.GREEN);
                    }
                });
                chrono2.start();
            }

            if (nombreAleatoire[idx] == 3){

                Thread chrono = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        btns[3].setBackgroundColor(Color.RED);
                    }
                });

                chrono.start();
                Thread chrono2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        btns[3].setBackgroundColor(Color.GREEN);
                    }
                });
                chrono2.start();
            }

            if (nombreAleatoire[idx] == 4){

                Thread chrono = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(6000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        btns[4].setBackgroundColor(Color.RED);
                    }
                });

                chrono.start();

                Thread chrono2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(6200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        btns[4].setBackgroundColor(Color.GREEN);
                    }
                });
                chrono2.start();

            }
        }

    }

    public void verification()
    {

                NbVie -= 1;

    }

    public void game(){

            t1.setText("Nombre de vie : "+ NbVie);
            Thread tempsMort = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    RandomBlock();
                    SimonSay();
                    for (int idx=0; idx<maxBlock; idx++){
                        int finalIdx = idx;

                        btns[1].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (nombreAleatoire[finalIdx] == 1)
                                {
                                    test = true;
                                }
                                else{
                                    btns[1].setBackgroundColor(Color.BLACK);
                                }
                                btns[1].setBackgroundColor(Color.BLACK);
                            }
                        });

                        btns[2].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (nombreAleatoire[finalIdx] == 2)
                                {
                                    test = true;
                                }
                                else{
                                    btns[1].setBackgroundColor(Color.BLACK);
                                }
                            }
                        });

                        btns[3].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (nombreAleatoire[finalIdx] == 3)
                                {
                                    test = true;
                                }
                                else{
                                    btns[1].setBackgroundColor(Color.BLACK);
                                }
                            }
                        });

                        btns[4].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (nombreAleatoire[finalIdx] == 4)
                                {
                                    test = true;
                                }
                                else{
                                    btns[1].setBackgroundColor(Color.BLACK);
                                }
                            }
                        });
                    }




                }
            });
            tempsMort.start();



        }





}
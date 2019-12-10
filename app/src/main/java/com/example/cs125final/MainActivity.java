package com.example.cs125final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private int score;
    private TextView sc, col;
    //private int[] colorArray;
    private Button one, two, three, four;
    private ArrayList<int[]> combo;
    private String[] questions = {"RED", "BLUE", "GREEN", "YELLOW"};

    //int yellow = Color.parseColor("E1D89F");
    //int blue = Color.parseColor("5B85AA");
    //int green = Color.parseColor("A1CDA8");
    //int red = Color.parseColor("B25053");
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //colors

        //Button Inflation
        score = 0;
        one = findViewById(R.id.button1);
        two = findViewById(R.id.button2);
        three = findViewById(R.id.button3);
        four = findViewById(R.id.button4);
        //TextView colorLabel = findViewById(R.id.color);
        //Button begin = findViewById(R.id.beginButton);



        //TextView Inflation
        sc = findViewById(R.id.score);
        col = findViewById(R.id.color);

        int[] a = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
        int[] b = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE};
        int[] c = {Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN};
        int[] d = {Color.GREEN, Color.BLUE, Color.RED, Color.YELLOW};
        int[] e = {Color.GREEN, Color.YELLOW, Color.BLUE, Color.RED};
        int[] f = {Color.GREEN, Color.RED, Color.YELLOW, Color.BLUE};
        int[] g = {Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW};
        int[] h = {Color.BLUE, Color.YELLOW, Color.GREEN, Color.RED};
        int[] i = {Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN};
        int[] j = {Color.YELLOW, Color.GREEN, Color.BLUE, Color.RED};
        int[] k = {Color.YELLOW, Color.RED, Color.GREEN, Color.BLUE};
        int[] l = {Color.YELLOW, Color.BLUE, Color.RED, Color.GREEN};

        combo = new ArrayList<>();
        combo.add(a);
        combo.add(b);
        combo.add(c);
        combo.add(d);
        combo.add(e);
        combo.add(f);
        combo.add(g);
        combo.add(h);
        combo.add(i);
        combo.add(j);
        combo.add(k);
        combo.add(l);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //System.out.println("Reached");
                checkAnswer(one);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(two);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(three);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(four);
            }
        });
        /**begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();



            }
        });
         **/


    }

    private void checkAnswer(Button selected) {
        String q = col.getText().toString().toUpperCase();
        System.out.println(q);
        int color = ((ColorDrawable) selected.getBackground()).getColor();
       //System.out.println("Button Color: " + color + " Color.RED: " + Color.RED);
        if (q.equals("RED") && color == Color.RED) {
            score++;
            sc.setText("Score: " + score);
            final MediaPlayer m = MediaPlayer.create(MainActivity.this, R.raw.win);
            m.start();
            update();
        } else if (q.equals("BLUE") && color == Color.BLUE) {
            score++;
            sc.setText("Score: " + score);
            final MediaPlayer m = MediaPlayer.create(MainActivity.this, R.raw.win);
            m.start();
            update();
        } else if (q.equals("GREEN") && color == Color.GREEN) {
            score++;
            sc.setText("Score: " + score);
            final MediaPlayer m = MediaPlayer.create(MainActivity.this, R.raw.win);
            m.start();
            update();
        } else if (q.equals("YELLOW") && color == Color.YELLOW) {
            score++;
            sc.setText("Score: " + score);
            final MediaPlayer m = MediaPlayer.create(MainActivity.this, R.raw.win);
            m.start();
            update();
        } else {
            score--;
            sc.setText("Score: " + score);
            final MediaPlayer m = MediaPlayer.create(MainActivity.this, R.raw.die);
            m.start();
            update();
        }
    }



    // called to change the colors of each button after
    public void update() {
        // math.random to find a color
        // check if color is already used
        /*
        int[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
        String[] questions = {"RED", "BLUE", "GREEN", "YELLOW"};
        col.setText(questions[(int) (Math.random() * 4)]);
        Set<Integer> randomC = new HashSet<>();

        while (randomC.size() < colors.length) {
            int index = (int) (Math.random() * colors.length);
            randomC.add(colors[index]);
        }
        //System.out.println("Reached");

        int[] colorNum = new int[4];
        int count = 0;
        for (int i : randomC) {
            colorNum[count] = i;
            count++;
        }

        one.setBackgroundColor(colorNum[3]);
        two.setBackgroundColor(colorNum[2]);
        three.setBackgroundColor(colorNum[1]);
        four.setBackgroundColor(colorNum[0]);
        randomC.clear();
        */

        String text = questions[(int)(Math.random() * 4)];
        col.setText(text);
        int index = (int) (Math.random() * combo.size());
        int[] scheme = combo.get(index);
        one.setBackgroundColor(scheme[0]);
        two.setBackgroundColor(scheme[1]);
        three.setBackgroundColor(scheme[2]);
        four.setBackgroundColor(scheme[3]);


    }


}

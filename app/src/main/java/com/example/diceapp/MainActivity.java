package com.example.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {

        }
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.img1);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(MainActivity.this).load(R.drawable.dice).into(imageView);
                Random random = new Random();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        switch (random.nextInt(6)+1) {
                            case 1: Glide.with(MainActivity.this).load(R.mipmap.one_foreground).into(imageView); break;
                            case 2: Glide.with(MainActivity.this).load(R.mipmap.two_foreground).into(imageView); break;
                            case 3: Glide.with(MainActivity.this).load(R.mipmap.three_foreground).into(imageView); break;
                            case 4: Glide.with(MainActivity.this).load(R.mipmap.four_foreground).into(imageView); break;
                            case 5: Glide.with(MainActivity.this).load(R.mipmap.five_foreground).into(imageView); break;
                            case 6: Glide.with(MainActivity.this).load(R.mipmap.six_foreground).into(imageView); break;
                            default:
                                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                },2*2000);
            }
        });
    }
}
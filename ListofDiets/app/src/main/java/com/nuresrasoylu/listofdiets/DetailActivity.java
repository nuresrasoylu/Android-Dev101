package com.nuresrasoylu.listofdiets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.imageView);
        TextView foodNameText = findViewById(R.id.foodNameText);
        TextView calorieText = findViewById(R.id.calorieText);

        Intent intent = getIntent();
        String foodName = intent.getStringExtra("name");
        String foodCalorie = intent.getStringExtra("calorie");

        foodNameText.setText(foodName);
        calorieText.setText("Calorie: " + foodCalorie);

        Singleton singleton = Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());

    }
}
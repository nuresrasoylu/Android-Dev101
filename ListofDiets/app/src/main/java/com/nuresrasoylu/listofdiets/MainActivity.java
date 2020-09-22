package com.nuresrasoylu.listofdiets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static Bitmap selectedImaged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        //Data

        final ArrayList<String> foodNames = new ArrayList<>();
        foodNames.add("Fitbrownie");
        foodNames.add("Peanutbutter");
        foodNames.add("Snackballs");

        final ArrayList<String> foodCalories = new ArrayList<>();
        foodCalories.add("300");
        foodCalories.add("200");
        foodCalories.add("200");

        Bitmap fitbrownie = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.fitbrownie);
        Bitmap peanutbutter = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.peanutbutter);
        Bitmap snackballs = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.snackballs);

        final ArrayList<Bitmap> foodImages =new ArrayList<>();

        foodImages.add(fitbrownie);
        foodImages.add(peanutbutter);
        foodImages.add(snackballs);

        //ListView

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,foodNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //System.out.println(foodNames.get(position));
                //System.out.println(foodCalories.get(position));

                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("name",foodNames.get(position));
                intent.putExtra("calorie",foodCalories.get(position));
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(foodImages.get(position));


                startActivity(intent);


            }
        });

    }
}
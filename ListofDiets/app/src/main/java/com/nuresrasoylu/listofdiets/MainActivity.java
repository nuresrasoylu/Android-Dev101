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

        final ArrayList<String> foodRecipe = new ArrayList<>();
        foodRecipe.add("Ingredients for Fit Browni Recipe:\n\n" +
                "1 small banana\n" +
                "2 eggs\n" +
                "8 tiny square dark chocolate bars\n" +
                "1 tablespoon of cocoa\n" +
                "1 tablespoon of honey\n" +
                "3 tablespoons of whole wheat flour (not heaped)\n" +
                "2 teaspoons of butter\n" +
                "1 packet of baking powder");
        foodRecipe.add("I think don't bother preparing it. Buy it directly and spread it to your bread!");
        foodRecipe.add("Ingredients for Cocoa Oat Bran Balls Recipe: \n\n" +
                "7 pieces\n" +
                "3 dried apricots\n" +
                "1 small banana\n" +
                "2 teaspoons of oat bran\n" +
                "4 tablespoons ground hazelnuts (not roasted)\n" +
                "1 dessert spoon cocoa\n" +
                "2 tablespoons milk\n" +
                "2 teaspoons of cinnamon");

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
                intent.putExtra("recipe",foodRecipe.get(position));
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(foodImages.get(position));


                startActivity(intent);


            }
        });

    }
}
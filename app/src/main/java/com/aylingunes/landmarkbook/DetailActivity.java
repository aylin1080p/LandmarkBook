package com.aylingunes.landmarkbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

//import static com.aylingunes.landmarkbook.MainActivity.selectedImage; //burxdan import etti static olarak

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // sayfa açılınca yapılması istenen aktiviteler hemen burada yer almalı
        ImageView imageView = findViewById(R.id.imageView);
        TextView landmarkNameText = findViewById(R.id.landmarkNameText);
        TextView countryNameText = findViewById(R.id.countryNameText);
        // tanımlamalar yapıldı bunların isimlerini layoutta verdiğin id'lere göre ver

        Intent intent = getIntent(); // yollanan intenti aldık
       String landMarkName = intent.getStringExtra("name");
       String countryName = intent.getStringExtra("country");


     //  imageView.setImageBitmap(selectedImage);
        landmarkNameText.setText(landMarkName);
        countryNameText.setText(countryName);
 Singleton singleton = Singleton.getInstance();
imageView.setImageBitmap(singleton.getChosenImage());

    }
}
package com.aylingunes.landmarkbook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   // static Bitmap selectedImage; // görselleri almak için tanımladı erişime her yerden açık


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // app çalışır çalışmaz olması gerekenleri oncreate altına atalım
        // liste oluşmasını istiyoruz
        ListView listView = findViewById(R.id.listView); //id'si listView olan listView yaratılıp çekildi
        final ArrayList<String> landMarkNames =  new ArrayList<>(); //yeni bir liste oluşturdu landMarkNames adında
        // --> henüz içi boş bu listenin
        landMarkNames.add("Pisa"); // add methoduyla String bekleyecek yapısı gereği
        landMarkNames.add("Eiffel");
        landMarkNames.add("Coleseo");
        landMarkNames.add("London Bridge");
        // arrayliste eklemeler sürekli yapılabilir fakat şimdilik bu kadar içeriği var
        // bu eklemeleri listeye atmak için arrayAdapter kullanılıyor

        final ArrayList<String> countryNames = new ArrayList<>();
        countryNames.add("Italy");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("United Kingdom");
        // bunları aynı sırada vermemiz lazım yoksa karışıklık olacak
// görselleri nesneleştirmek
        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eiffel);
       Bitmap coleseo = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.coleseo);
       Bitmap londonbridge = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.londonbridge);


       final ArrayList<Bitmap> landmarkImages = new ArrayList<>();
       landmarkImages.add(pisa);
       landmarkImages.add(eiffel);
       landmarkImages.add(coleseo);
       landmarkImages.add(londonbridge);

// listView işlemleri
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,landMarkNames);
        // liste içinde sadece metin göstereceksek ve tek satırsa bunu kullancağız -->simple list item1 hazır kalıp
        // bir kontekst -->mainactivity, bir layoutRes-->
        listView.setAdapter(arrayAdapter); // her şeyi birbirine bağlamış olduk
// row tıklanığında ne olacağını belirleme;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // bu yapı otomatik oluştu burada herhangi bir iteme tıklanınca ne olacağını yaacağız
                // poisitionda ilk kutuya tıklamak bunun değerini 0 yapar
                // ikinci kutuda position değişkeni 1 değerini alır buna göre düşün

            //    System.out.println(landMarkNames.get(position));
              //  System.out.println(countryNames.get(position));

                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("name:",landMarkNames.get(position));
                intent.putExtra("country",countryNames.get(position));
                // görsel putextrayla aktaılmıyor

                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(landmarkImages.get(position));
               // selectedImage = landmarkImages.get(position); // en baştaki bitmape atadık

                startActivity(intent);

            }
        });
// dinleyici: aksiyon halinde ,tıklama vs ne çağırılacak onu belirler

  //oncreate end
        }
}
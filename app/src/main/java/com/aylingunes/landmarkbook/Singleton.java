package com.aylingunes.landmarkbook;

import android.graphics.Bitmap;

public class Singleton {
  private   Bitmap chosenImage;
private  static Singleton singleton;


        //constructor
       private Singleton() {
        }

    public Bitmap getChosenImage() {
        return chosenImage;
    }

    public void setChosenImage(Bitmap chosenImage) {
        this.chosenImage = chosenImage;
    }

    public static Singleton getInstance() {
           // bu metoda dışardan erişilebilir
        if(singleton == null){
            singleton= new Singleton();
        } return singleton;

    }

}

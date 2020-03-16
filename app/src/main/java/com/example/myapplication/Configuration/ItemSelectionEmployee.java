package com.example.myapplication.Configuration;

public class ItemSelectionEmployee {
    private String nom_;
    private String heuresTravail_;
    private int imageRessource_; //Image devra etre eventuellement changé à une bitmap

    public ItemSelectionEmployee(int imageRessource,String nom, String heuresTravail) {
        imageRessource_=imageRessource;
        nom_ = nom;
        heuresTravail_ = heuresTravail;
    }

    public String getNom(){return nom_;}

    public String getHeuresTravail(){return heuresTravail_;}

    public int getImageRessource(){return imageRessource_;}
}

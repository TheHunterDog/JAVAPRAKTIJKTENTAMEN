package com.company;

import java.awt.*;

public abstract class Persoon {
    private final String naam;
    private int blij;

    public Persoon(String naam, int blij) {
        this.naam = naam;
        if (blij < 0){
            blij = 0;
        }
        else if(blij > 100){
            blij = 100;
        }
        this.blij = blij;
    }
    public int getBlij(){
        return blij;
    }
    public String getNaam(){
        return this.naam;
    }
    public void maakBlij(int waarde){
        int cc = this.blij + waarde;
        if(cc < 0){
            cc = 0;
        }
        else if(cc > 100){
            cc = 100;
        }
//        This overbodig
        this.blij = cc;
    }
    public String toString(){
       return getNaam()+" ("+getBeschrijving()+") \t \t"+getBlij()+"\t "+ getSmiley();
    }
    public Color getKleur(){
        if(blij <= 25){
            return Color.red;
        }
        else if(blij > 25 && blij < 50){
            return Color.orange;
        }
        else if(blij > 50 && blij < 75){
            return Color.yellow;
        }
            return  Color.green;
    }
    public abstract String getBeschrijving();
    public abstract String getSmiley();


}

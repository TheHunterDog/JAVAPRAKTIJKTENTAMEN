package com.company;

import java.awt.*;
import java.util.ArrayList;

import static com.company.KlasGraphics.drawStringRotated;

public class Klas {
    private String naam;
    private final ArrayList<Persoon> personenlijst = new ArrayList<>();
    private Persoon docent;

    public Klas(String naam) {
        if(naam != "###" && naam.length() >= 3 && naam != null){
            this.naam = naam;
        }
        else{
            this.naam = "\"klas???\"";
        }
    }
    public Persoon getDocent(){
        return docent;
    }
    public String getNaam(){
        return naam;
    }
    public void setNaam(String nieuweNaam){
//        This overbodig
        if(nieuweNaam != "###" && nieuweNaam.length() >= 3 && nieuweNaam != null) {
            this.naam = nieuweNaam;
        }
    }
    public void print(){
        System.out.println("=== Klas:"+naam+" ===");
        for (Persoon persoon:
             personenlijst) {
            System.out.println(persoon);
        }
    }
    public void printGUIIcons(Graphics g,int x, int y, Dimension d){
        int index = 0;
        for (Persoon persoon :
                personenlijst) {
            g.setFont(new Font("default",Font.BOLD,35));
            g.setColor(persoon.getKleur());
            if (persoon.getBeschrijving().equals("Docent")) {
                g.fillRect(x, y, 70, 70);
                g.setColor(Color.black);
                g.drawRect(x,y,70,70);


            } else {
                g.fillOval(x, y, 70, 70);
                g.setColor(Color.black);
                g.drawOval(x,y,70,70);

            }
            g.setFont(new Font("default",Font.BOLD,13));
            g.drawString(persoon.getNaam(),x,y+80);
            g.drawString(persoon.getBeschrijving(),x,y+90);
            g.drawString(Integer.toString(persoon.getBlij()),x,y+100);

            drawStringRotated(g, persoon.getSmiley(), x + 70 / 3, y + 70 / 3, 90);
        x+= 80;
        index++;
        if(index % (d.getWidth() / 100) == 0){
            y+= 130;
            x = 10;
        }
        }

        }
    public void voegToe(String naam, String studentnummer, int blij){
        personenlijst.add(new Student(naam,studentnummer,blij));
    }
    public void voegToe(Persoon persoon){
        if(persoon.getBeschrijving().equals("Docent")){
//            Een docent mag nooit weg van 1 klas
            if(this.docent == null) {
                this.docent = persoon;
                personenlijst.add(persoon);
            }
        }
        else{
            personenlijst.add(persoon);
        }
    }
    public void maakBlij(int hoeveelheid){
        for (Persoon p :
                personenlijst) {
            p.maakBlij(hoeveelheid);

        }
    }
    public boolean maakBlij(String naam, int hoeveelheid){
        for (Persoon p:
             personenlijst) {
            if(p.getNaam().equals(naam)){
                p.maakBlij(hoeveelheid);
                return true;
            }
        }
        return false;
    }
}

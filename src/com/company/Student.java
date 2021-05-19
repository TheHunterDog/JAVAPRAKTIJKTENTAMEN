package com.company;

public class Student extends Persoon{
    private final String studentnummer;

    public Student(String naam, String studentnummer, int blij) {
        super(naam,blij);
        this.studentnummer = studentnummer;
    }
    public Student(String naam, String studentnummer){
        super(naam,50);
        this.studentnummer = studentnummer;
    }

    @Override
    public String getBeschrijving() {
        return this.studentnummer;
    }

    @Override
    public String getSmiley() {
        int blij = getBlij();
        if(blij <= 25){
            return ":-(";
        }
        else if(blij > 25 && blij<= 50){
            return ":-|";

        }
        else if(blij > 50 && blij <= 75){
            return ":-)";
        }
        else {
            return ":-D";
        }
    }
}

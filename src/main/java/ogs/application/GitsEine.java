package ogs.application;

import java.util.Random;

public class GitsEine {

    public int luck;
    public String[] schnupfs;
    
    public GitsEine() {
        this.luck = 0;
        this.schnupfs = new String[] { "McCrystal","Helvetica" };
    }
    
    public void modifyLuck(String mod) {
        String[] mods = mod.split(" ");
        if(mods[0].equals("inc")) {
            if(mods.length > 1) {
                try {
                    this.luck += Integer.parseInt(mods[1]);                    
                    System.out.println("Luck increased by " + Integer.parseInt(mods[1]));
                } catch(Exception e) {
                    System.out.println("Bitte gültige Nummer eingeben");
                } 
            } else {     
                this.luck++;
                System.out.println("Luck increased by 1");
            }
        }
    }
    
    public boolean gitsEine() {
        return new Random().nextInt(2 + luck) <= luck;
    }

}

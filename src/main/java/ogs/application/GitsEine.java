package ogs.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GitsEine {
    
    public static final String VERSION = "v2.0";
    
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
    
    public static void main(String[] args) throws IOException {
        
        GitsEine gitsEine = new GitsEine();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean run = false;
        
        System.out.println("Willkommen bei 'Gits Eine " + VERSION + "'");
        System.out.println("Um zu entscheiden, ob es einen gibt, bitte 'run' eingeben!");
        while(!run) {
            String eingabe = br.readLine();
            
            if(eingabe.equals("run")) {
                run = true;
            } else if(eingabe.startsWith("luck ")) {
                gitsEine.modifyLuck(eingabe.substring(5));
            }
        }
        
        clearConsole();
        System.out.println("Gits eine?");        
        
        if(gitsEine.gitsEine()) {
            System.out.println("Ja sicher!");
        } else {
            System.out.println("Nope sorry :(");
        }
        
    }

    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

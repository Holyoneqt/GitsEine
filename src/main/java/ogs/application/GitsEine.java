package ogs.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GitsEine {

    public int luck;
    public List<String> schnupfs;
    
    public GitsEine() {
        this.luck = 0;
        this.schnupfs = readSchnupfs();
    }
    
    public boolean run(String mod) {
        String[] mods = mod.split(" ");
        Main.clearConsole();
        System.out.println("Gits eine?");
        if(mods.length <= 1) {
            if (gitsEine()) {
                System.out.println("Ja sicher!");
            } else {
                System.out.println("Nope sorry :(");
            }
            return true;            
        } else {
            switch (mods[1]) {
                case "all":
                    String schnupf = schnupfs.get(new Random().nextInt(schnupfs.size()));
                    if (gitsEine()) {
                        System.out.println("Ja sicher, en " + schnupf);
                    } else {
                        System.out.println("Nope sorry :(");
                    }
                    return true;
                default:
                    Main.clearConsole();
                    return false;
            }
        }
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
        } else if(mods[0].equals("dec")) {
            if(mods.length > 1) {
                try {
                    this.luck -= Integer.parseInt(mods[1]);                    
                    System.out.println("Luck decreased by " + Integer.parseInt(mods[1]));
                } catch(Exception e) {
                    System.out.println("Bitte gültige Nummer eingeben");
                } 
            } else {     
                this.luck--;
                System.out.println("Luck decreased by 1");
            }
            if(this.luck < 0) {
                this.luck = 0;
            }
        }
    }
    
    public boolean gitsEine() {
        return new Random().nextInt(2 + luck) <= luck;
    }

    private ArrayList<String> readSchnupfs() {
        ArrayList<String> list = new ArrayList<String>();
        String line = "";
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("resources/schnupf.txt"));
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
}

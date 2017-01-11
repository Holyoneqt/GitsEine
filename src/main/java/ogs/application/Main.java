package ogs.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final String VERSION = "v2.0";
    
    public static void main(String[] args) throws IOException {

        GitsEine gitsEine = new GitsEine();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean run = false;

        System.out.println("Willkommen bei 'Gits Eine " + VERSION + "'");
        System.out.println("Um zu entscheiden, ob es einen gibt, bitte 'run' eingeben!");
        while (!run) {
            String eingabe = br.readLine();

            if (eingabe.equals("run")) {
                run = true;
            } else if (eingabe.startsWith("luck ")) {
                gitsEine.modifyLuck(eingabe.substring(5));
            }
        }

        clearConsole();
        System.out.println("Gits eine?");

        if (gitsEine.gitsEine()) {
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

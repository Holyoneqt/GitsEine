package ogs.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final String VERSION = "v2.1";
    
    public static void main(String[] args) throws IOException {

        GitsEine gitsEine = new GitsEine();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean run = false;

        System.out.println("Willkommen bei 'Gits Eine " + VERSION + "'");
        System.out.println("Um zu entscheiden, ob es einen gibt, bitte 'run' eingeben!");
        while (!run) {
            String eingabe = br.readLine();

            if (eingabe.startsWith("run")) {
                run = gitsEine.run(eingabe);
            } else if (eingabe.startsWith("luck ")) {
                gitsEine.modifyLuck(eingabe.substring(5));
            } else if(eingabe.equals("69")) {
                doTheDance();
            }
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

    private static void doTheDance() {
        clearConsole();
        String danceLeft = "\\(*_*)\n" + 
                           " (  (>\n" + 
                           " /  \\";
        String danceRight = " (*_*)/\n" + 
                            "<)  )\n" +
                            "/  \\";
        for(int i = 0; i < 20; i++) {
            if((i%2) == 0) {
                System.out.println(danceLeft);
            } else {
                System.out.println(danceRight);
            }
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearConsole();
        }
    }
    
}

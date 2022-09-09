/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.vithushan.lerntool;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Ganz unten in der initialize Methode kann man neue Sätze einfügen.
 *
 * @author Vithushan Jeevanantham
 */
public class Lerntool {

    private ArrayList<Satz> liste = new ArrayList<>();
    private Random rnd = new Random();
    private String korrektesWort = "";
    private Satz aktuellerSatz = null;
    private Scanner sc = new Scanner(System.in);

    public void run() {
        System.out.println("Willkommen zum Lerntool!\n");
        while (true) {
            initialize();
            System.out.println(getOriginalSprache());
            System.out.println(getFremdSprache());
            System.out.print("Eingabe: ");
            if (kontrolle(sc.next().toLowerCase())) {
                System.out.println("Richtig!");
            } else {
                System.out.println("Leider Falsch!");
            }
            System.out.println("Gib Y ein um nochmal zu spielen!");
            if (!sc.next().toLowerCase().equals("y")) {
                break;
            }
            System.out.println("");
        }
    }

    //nur Buchstaben behalten in einem String -> .replaceAll("[^A-Za-z]+", "")
    //Kontrolle, ob nur noch Buchstaben im String sich befinden -> .matches("[a-zA-Z]+")
    private String getFremdSprache() {
        String fremdSatzNurWoerter = aktuellerSatz.getFremdSprache().replaceAll("[^A-Za-z]+", " ");
        int anzWoerter = fremdSatzNurWoerter.split(" ").length;
        return ersetzeWort(aktuellerSatz.getFremdSprache(), rnd.nextInt(anzWoerter));
    }

    private String getOriginalSprache() {
        return aktuellerSatz.getOriginalSprache();
    }

    private boolean kontrolle(String eingabe) {
        return eingabe.equals(korrektesWort);
    }

    //Ersetzt ein Random Wort vom Satz mit Unterstrich
    private String ersetzeWort(String satz, int welchesWort) {
        int indexAnfang = 0;
        int indexSchluss = -1;
        boolean naechstesWort = true;
        String ret = "";

        for (int i = 1; i < satz.length(); i++) {
            if (welchesWort == 0) {
                break;
            }
            if (satz.substring(indexAnfang, i).matches("[a-zA-Z]+")) {
                if (naechstesWort) {
                    welchesWort--;
                    naechstesWort = false;
                }
            } else {
                indexAnfang = i;
                naechstesWort = true;
            }
        }
        ret = satz.substring(0, indexAnfang);
        for (int i = indexAnfang + 1; i < satz.length(); i++) {
            if (!satz.substring(indexAnfang, i).matches("[a-zA-Z]+")) {
                indexSchluss = i;
                break;
            }
        }
        for (int i = indexAnfang + 1; i < indexSchluss; i++) {
            ret += "_";
        }
        korrektesWort = satz.substring(indexAnfang, indexSchluss - 1).toLowerCase();
        ret += satz.substring(indexSchluss - 1);
        return ret;
    }

    //Alle Sätze werden hier eingefügt
    private void initialize() {
        liste.clear();
        liste.add(new Satz("Guten Morgen, Herr Friedrich!", "Good morning, mister Friedrich!"));
        liste.add(new Satz("Working at Andeo is a great experience!", "Bei Andeo zu arbeiten ist eine grossartige Erfahrung!"));
        aktuellerSatz = liste.get(rnd.nextInt(liste.size()));
    }
}

import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

import static java.lang.Integer.parseInt;

public class DateiHandler {
    Scanner scan;

    public DateiHandler(File f) {
        try {
            scan = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Produkt lesen() {

        if (scan.hasNext()) {
            String name = scan.next();
            String kategorie = scan.next();
            String produktID = scan.next();
            String lagerbestand = scan.next();
            return new Produkt(name, kategorie, produktID, Integer.parseInt(lagerbestand));
        }
        return null;
    }

    public void einlagern(String name, String kategorie, String produktID, int lagerbestand) throws IOException {
        FileWriter fw = new FileWriter("ausgabe.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        String n = System.getProperty("line.separator");

        //bw.append("puffer puffer 000 0");
        //bw.append(n);
        bw.append(name + " " + kategorie + " " + produktID + " " + lagerbestand);

        bw.append(n);


        bw.close();


    }


    public void schliessen() {
        scan.close();
    }
}

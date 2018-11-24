import java.sql.SQLOutput;
import java.util.*;
import java.io.*;


public class Datenbank {


    ArrayList<Produkt> liste = new ArrayList<Produkt>();
    ArrayList<Produkt> tmpListe = new ArrayList<Produkt>();
    Produkt letzteAusgabe = null;

    public void ladeListe() throws IOException {

        boolean booli = true;
        File f = new File("D:/IT-Kolleg/POS DOBL/Lagerverwalt_grassmayr/ausgabe.txt");
        DateiHandler dh = new DateiHandler(f);


        while (dh.scan.hasNext()) {
            Produkt p = dh.lesen();
            this.liste.add(p);

        }
        System.out.println("Listeneinträge: " + liste.size());
        dh.schliessen();
    }

    public void ausgabeListe() {
        for (Produkt ausgabe : liste) {
            System.out.println("Produktname: " + ausgabe.name + " Produktkategorie: " + ausgabe.kategorie + " ProduktID: " + ausgabe.produktID + " Lagerbestand: " + ausgabe.lagerbestand);
        }
    }

    public void sortiereListe() {

        for (Produkt ausgabe : liste) {

            if (ausgabe.produktID.equals(letzteAusgabe.produktID)) {
                this.letzteAusgabe.lagerbestand += 1;

                this.tmpListe.add(ausgabe);
                this.tmpListe.remove(ausgabe);
            } else {
                this.tmpListe.add(ausgabe);
            }
            this.letzteAusgabe = ausgabe;
        }
        liste.clear();
        liste.addAll(tmpListe);


    }

    public void removeDuplicatedEntries(ArrayList<Produkt> arrayList) {
        HashSet<Produkt> hashSet = new HashSet<Produkt>(arrayList);
        arrayList.clear();
        arrayList.addAll(hashSet);
    }


}

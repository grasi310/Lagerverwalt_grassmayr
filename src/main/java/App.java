import java.util.*;
import java.io.*;

public class App
{

    public static void main(String [] args) throws IOException
    {

          /*  boolean booli = true;
            File f = new File("D:/IT-Kolleg/POS DOBL/Lagerverwalt_grassmayr/ausgabe.txt");
            DateiHandler dh = new DateiHandler(f);
            dh.einlagern("apfel", "obst", "001", "1");
            while(booli != false)
            {

                if(dh.lesen() != null) {
                    Produkt produkt1 = dh.lesen();

                    booli = true;
                }
                else {
                    booli = false;
                }

            }

            dh.schliessen();*/
        File f = new File("D:/IT-Kolleg/POS DOBL/Lagerverwalt_grassmayr/ausgabe.txt");
        DateiHandler dh = new DateiHandler(f);
        dh.einlagern("apfel", "obst", "001", 1);
            Datenbank data = new Datenbank();
            data.ladeListe();
            data.sortiereListe();
            //data.removeDuplicatedEntries(data.liste);
            data.ausgabeListe();





    }



}





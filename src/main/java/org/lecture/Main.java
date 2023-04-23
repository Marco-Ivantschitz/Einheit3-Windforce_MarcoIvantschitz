package org.lecture;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * In the Main class the programm starts.
 * The FileReader and FileREader will also be declared and also the Path.
 * There is also the calculation for the Knoten and Beaufort.
 */

public class Main {
    public static void main(String[] args) {
        int id = 0;
        Menu menu = new Menu();
        ArrayList<Windforce> list = null;
        FileReader fileReader = new FileReader();
        FileWriter fileWriter = new FileWriter();
        Path path = Paths.get("src/main/resources/entries.csv");

        try {
            list = fileReader.readFile(path);

            for (Windforce f : list) {
                if(id <= f.getId())
                    id = f.getId() + 1;
            }

            for (Windforce f : list) {
                calcKnotenAndBeaufort(f);
            }
        } catch (Exception e) {
            System.out.println("Datei wurde nicht gefunden!");
            System.exit(1);
        }

        while(true) {
            menu.menu();
            int eingabe = menu.consoleInput();

            if (eingabe == 1) {
                Windforce f = askWindforce(menu, id);
                calcKnotenAndBeaufort(f);
                list.add(f);
                id++;
            }

            if (eingabe == 2) {
                writeFile(list, fileWriter);
            }

            if (eingabe == 3) {
                printWindforce(list);
            }

            if (eingabe == 4) {
                printExtremeWeather(list);
            }
        }
    }

    public static Windforce askWindforce(Menu menu, int id) {
        Windforce f = new Windforce();

        f.setId(id);
        f.setWindforce(menu.askWindforce());
        f.setDateTime(new Date());
        f.setStation(menu.askStation());

        String bearing = "NA";
        Double temp = menu.askTemp();
        if(temp != null) {
            f.setTemp(temp);
            bearing = menu.askBearing();
            if(bearing.isEmpty())
                bearing = "NA";
            f.setBearing(bearing);
        } else {
            f.setBearing(bearing);
        }

        f.setWeather(menu.askWeather());

        return f;
    }

    public static void printWindforce(ArrayList<Windforce> list) {
        ArrayList<Integer> windforceList = new ArrayList<>();

        for (Windforce f : list) {
            windforceList.add(f.getId());
        }

        Collections.sort(windforceList);

        for (int id : windforceList) {
            for (Windforce f : list) {
                if(id == f.getId()) {
                    printText(f);
                }
            }
        }
    }

    public static void printExtremeWeather(ArrayList<Windforce> list) {

        for (Windforce f : list) {
            printText(f);
        }
    }

    public static void printText(Windforce f) {

        String t = "";
            if (f.getWindforce() < 2) {
                t = "It was windless. ";
            } else if (f.getWindforce() >= 120) {
                t = "It was a orkan. ";
            }

            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            String strDate = dateFormat.format(f.getDateTime());

            String s = f.getId() + ". Entry. At " + strDate + " the windforce was " + f.getWindforce() +
                    " km/h measured at " + f.getStation() + ". The bearing was " + f.getBearing() + ". " + t +
                    "The windforce equals " + f.getKnoten() + " knots. On the Beaufort scale it equals a " + f.getBeaufort();

            System.out.println(s);
    }

    public static void calcKnotenAndBeaufort(Windforce f) {
        BigDecimal value = new BigDecimal(0.53996);
        int beaufort = 0;

            BigDecimal knoten = new BigDecimal(f.getWindforce()).multiply(value);
            knoten = knoten.setScale(4, RoundingMode.HALF_DOWN);
            f.setKnoten(knoten);

            knoten.add(new BigDecimal(5));
            knoten.divide(new BigDecimal(5));
            beaufort = knoten.intValue();
            if(beaufort < 0) {
                beaufort = 0;
            } else if (beaufort > 12) {
                beaufort = 12;
            }

            f.setBeaufort(beaufort);
    }

    public static void writeFile(ArrayList<Windforce> list, FileWriter fileWriter) {
        Path path = Paths.get("src/main/resources/saveEntries.csv");

        try {
            fileWriter.writeFile(path, list);
        } catch (Exception e) {
            System.out.println("Datei konnte nicht gespeichert werden!");
            System.exit(1);
        }
    }
}
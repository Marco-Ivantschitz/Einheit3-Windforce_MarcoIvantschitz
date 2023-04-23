package org.lecture;

import java.util.Scanner;

/**
 * In the Menu class the Menu will be created.
 */

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        System.out.println("1 - create via Console and save log entries into a file.");
        System.out.println("2 - create log entries via a file and save intto file");
        System.out.println("3 - print all Windforces in ascending order");
        System.out.println("4 - print all extreme weather conditions");
    }

    /**
     * The consoleInput checks the input on the console.
     */

    public int consoleInput() {
        while (true) {
            try {
                System.out.print("Bitte wählen Sie eine Zahl: ");
                int eingabe = Integer.parseInt(scanner.nextLine());
                if (eingabe < 1 || eingabe > 4) {
                    System.out.println("Einagbe fehlerhaft");
                    menu();
                    continue;
                }

                return eingabe;

            } catch (Exception e) {
                System.out.println("Einagbe fehlerhaft");
                menu();
                continue;
            }
        }
    }

    /**
     * With askWindforce you are able to input a Windforce.
     * If the input is valid you are able to chose a correct input again.
     */

    public double askWindforce() {
        while (true) {
            try {
                System.out.print("Bitte geben Sie die Windgeschwindigkeit ein: ");
                double eingabe = Double.parseDouble(scanner.nextLine());

                return eingabe;

            } catch (Exception e) {
                System.out.println("Einagbe fehlerhaft");
                continue;
            }
        }
    }

    /**
     * With askStation you can input a Station.
     * If the input is valid you are able to chose a correct input again.
     */

    public String askStation() {
        while (true) {
            try {
                System.out.print("Bitte geben Sie die Station ein: ");
                String eingabe = scanner.nextLine();

                return eingabe;

            } catch (Exception e) {
                System.out.println("Einagbe fehlerhaft");
                continue;
            }
        }
    }

    /**
     * With askTemp you can input the Temperature.
     * If the input is valid you are able to chose a correct input again.
     */

    public Double askTemp() {
        while (true) {
            try {
                System.out.print("Bitte geben Sie die Temperatur ein (Enter ohne Temperatur): ");
                String eingabe = scanner.nextLine();

                if (eingabe.isEmpty()) {
                    return null;
                }

                return Double.parseDouble(eingabe);

            } catch (Exception e) {
                System.out.println("Einagbe fehlerhaft");
                continue;
            }
        }
    }

    /**
     * With askBearing you can input a Bearing.
     * If the input is valid you are able to chose a correct input again.
     * With equalsIgnoreCase the case is not important
     */

    public String askBearing() {
        while (true) {
            try {
                System.out.print("Bitte geben Sie die Windrichtung ein (Enter ohne Windrichtung): ");
                String eingabe = scanner.nextLine();

                if (eingabe.isEmpty())
                    return eingabe;

                if (!"N".equalsIgnoreCase(eingabe) && !"NO".equalsIgnoreCase(eingabe) && !"O".equalsIgnoreCase(eingabe) && !"SO".equalsIgnoreCase(eingabe) &&
                        !"S".equalsIgnoreCase(eingabe) && !"SW".equalsIgnoreCase(eingabe) && !"W".equalsIgnoreCase(eingabe) && !"NW".equalsIgnoreCase(eingabe)) {
                    System.out.println("Einagbe fehlerhaft");
                    continue;
                }

                return eingabe;

            } catch (Exception e) {
                System.out.println("Einagbe fehlerhaft");
                continue;
            }
        }
    }

    /**
     * With askWeather you can input the Weather.
     * If the input is valid you are able to chose a correct input again.
     * With equalsIgnoreCase the case is not important
     */

    public String askWeather() {
        while (true) {
            try {
                System.out.print("Bitte geben Sie das Wetter ein (Enter ohne Wetter): ");
                String eingabe = scanner.nextLine();

                if (eingabe.isEmpty())
                    return "sonnig";

                if (!"sonnig".equalsIgnoreCase(eingabe) && !"bewölkt".equalsIgnoreCase(eingabe) && !"nebelig".equalsIgnoreCase(eingabe) &&
                        !"Regen".equalsIgnoreCase(eingabe) && !"Schnee".equalsIgnoreCase(eingabe)) {
                    System.out.println("Einagbe fehlerhaft");
                    continue;
                }

                return eingabe;

            } catch (Exception e) {
                System.out.println("Einagbe fehlerhaft");
                continue;
            }
        }
    }
}

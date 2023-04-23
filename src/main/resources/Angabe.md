# Assignment: Windstärken 

Denken Sie an Menüführung (Case (in)sensitive etc), CleanCode Rules, Design Patterns, Unit Tests (15%)
und Javadoc!

Laden Sie beim Programmstart alle Windgeschwindigkeiten einmalig aus einer Datei (entries.csv).

Erstellen Sie das Grundgerüst mit dazugehörigen Benutzereingabe, zB

1 - create via Console and save log entries into a file.
2 - create log entries via a file and save intto file
3 - print all Windforces in ascending order
4 - print all extreme weather conditions
  

Zu erfassende Werte:
Eine fortlaufende ID (die ID ist nur aufsteigend pro File, dh, wenn Sie ein zweites File einlesen, muss die bisherige letzte ID miteinbezogen werden), 
die Windgeschwindigkeit in km/h. Datum und lokale Uhrzeit der Eingabe. 
Die Messtation wird verpflichtend erfasst, die Außentemperatur in °C ist optional. Wenn vorhanden, wird
auch die Windrichtung abgespeichtert (N, NO, O, SO, S, SW, W, NW). Wird keine Windrichtung angegebene, so ist NA (Not Available) zu setzen.
Ebenso kann die allgemeine Wetterlage (sonnig, bewölkt, nebelig, Regen, Schnee) erfasst werden. Per default wird davon ausgegangen, dass es sonnig ist.

Ausgaben:

- Windgeschwindigkeiten können aufsteigend nach ID ausgegeben werden.
- Es können die Extremwerte ausgegeben werden (Windstille oder Orkan)

Definitionen:
Windstill: < 2 km/h Orkan: >= 120km/h

Für jede Windgeschwindigkeit in km/h berechnen Sie Knoten (km/h*0,53996) mit genau 4 Nachkommastellen (BigDecimal) und 
ebenso die Beaufort ((Knoten + 5)/5) unter Beachtung der Skala (Maximalwert!) - Beaufort sind ganzzahlige Werte.

Das Datum soll wie folgt formatiert werden: 13.03.2023 14:15:36 -> "dd.MM.yyyy HH:mm:ss".
Werden die Logeinträge gespeichert, ist das unformatierte Datum (2023-03-13T14:44:36) zu nehmen, damit das File theoretisch wieder eingelesen werden kann
Abzuspeichern sind die logEntries in savedEntries.csv. Das File muss alle derzeit erfassten einträge in de r richtigen Reihenfolge enthalten.

Ausgabe der Windgeschwindigkeit auf die Konsole umfasst alle Parameter mit einem sinnvollen Text. Wenn es windstill ist oder ein Orkan
herrscht, soll dies ausgegeben werden.

Zum Beipiel:

2. Entry. At 28.02.2022 11:43:00 the windforce was 120.0 km/h measured at Graz. The bearing was N. It was a hurricane.
   The windforce equals 64.7952 knots. On the Beaufort scale it equals a 12. 
   Wobei "2. Entry" die fortlaufende ID widerspiegelt.


Hinweis: How to parse a date:
public String getParsedDateTime() {
   var pattern = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
   return this.dateTime.format(pattern);
}
package org.lecture;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * In the FileWriter class the informations will be written in correct format.
 */

public class FileWriter {
    public void writeFile(Path p, ArrayList<Windforce> windforceList) throws Exception {

        for (Windforce f : windforceList) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            String strDate = dateFormat.format(f.getDateTime());

            String s = strDate;
            s = s + ",";
            s = s + f.getBearing();
            s = s + ",";
            s = s + f.getStation();
            s = s + ",";
            s = s + f.getTemp();
            s = s + ",";
            s = s + f.getWeather();
            s = s + ",";
            s = s + f.getId();
            s = s + ",";
            s = s + f.getWindforce();
            s = s + "\n";

            Files.write(p, s.getBytes(), Files.exists(p) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
        }
    }
}

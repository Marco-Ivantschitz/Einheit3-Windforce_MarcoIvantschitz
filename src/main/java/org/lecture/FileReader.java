package org.lecture;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 * In the FileReader the File gets all the information.
 * We have also the ParsedDateTime and it will be correct splitted.
 * In the getParsedDateTime the ParsedDateTime is declared.
 */

public class FileReader {
    public ArrayList<Windforce> readFile(Path p) throws Exception {
        ArrayList<Windforce> result = new ArrayList<>();
        if (!Files.exists(p)) {
            throw new Exception();
        } else {
            var list = (ArrayList<String>) Files.readAllLines(p);
            list.remove(0);
            for (String line : list) {
                String[] split = line.split(",");

                Date date = getParsedDateTime(split[0]);
                String bearing = split[1];
                String station = split[2];

                double temp = 0.0;
                if(!split[3].isEmpty())
                    temp = Double.parseDouble(split[3]);

                String weather = split[4];

                int id = 0;
                if(!split[5].isEmpty())
                    id = Integer.parseInt(split[5]);

                double windforce = 0.0;
                if(!split[6].isEmpty())
                    windforce = Double.parseDouble(split[6]);

                result.add(new Windforce(id, date, bearing, station, temp, weather, windforce));
            }
        }
        return result;
    }

    public Date getParsedDateTime(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(date);
        } catch (Exception e) {
            try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(date);
            } catch (Exception e1) {
                return null;
            }
        }
    }
}

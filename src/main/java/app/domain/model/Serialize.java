package app.domain.model;

import java.io.*;
import java.util.*;
import java.util.logging.*;

public class Serialize {

    public static boolean serialize(List objects, String fileName) {
        String filePath = String.format("save/%s.txt", fileName);

        try {
            File directory = new File("save");
            File file = new File(filePath);

            if (!directory.exists())
                directory.mkdir();

            if (!file.exists())
                file.createNewFile();

            try (FileOutputStream out = new FileOutputStream(file)) {

                ObjectOutputStream writer = new ObjectOutputStream(out);
                writer.writeObject(objects);
            }

            return true;
        } catch (Exception ex) {
            Logger.getGlobal().log(Level.SEVERE, ex.getMessage());
        }

        return false;
    }

    public static List deserialize(String fileName) {
        List<Objects> list = new ArrayList<>();
        String filePath = String.format("save/%s.txt", fileName);

        try {
            File file = new File(filePath);

            if (file.exists()) {
                try (FileInputStream in = new FileInputStream(file)) {
                    ObjectInputStream reader = new ObjectInputStream(in);

                    list = (List<Objects>) reader.readObject();
                }
            }

        } catch (Exception ex) {
            Logger.getGlobal().log(Level.SEVERE, ex.getMessage());
        }

        return list;
    }
}

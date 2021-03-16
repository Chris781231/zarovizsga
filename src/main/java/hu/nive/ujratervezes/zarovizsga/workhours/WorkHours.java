package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkHours {

    public String minWork(String path) {
        String result = "";
        int minHours = Integer.MAX_VALUE;

        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int actualHours = Integer.parseInt(parts[1]);
                if (actualHours < minHours) {
                    result = parts[0] + ": " + parts[2];
                    minHours = actualHours;
                }
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Cannot read file");
        }
        return result;
    }
}

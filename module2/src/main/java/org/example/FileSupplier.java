package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class FileSupplier {


    public List<Fight> readFightsListFromFile(Path path) {
        List<Fight> fights;


        File file = new File(path.toString());
        if (file.exists() && file.length() == 0) {

            return Collections.emptyList();
        }

        try (Stream<String> fileStream = Files.lines(path)){
            fights = fileStream
                    .map(line -> line.split(";"))
                    .map(fields -> {
                        LocalDate date = LocalDate.parse(fields[0]);
                        String name = fields[1];
                        Ludus ludus = Ludus.getByString(fields[2]);
                        Animal animal = Animal.getByString(fields[3]);
                        boolean win = Boolean.parseBoolean(fields[4]);
                        boolean pardoned = Boolean.parseBoolean(fields[5]);
                        return new Fight(date, name, ludus, animal, win, pardoned);
            }).toList();
        } catch (IOException exception) {

            throw new RuntimeException();
        }

        return fights;
    }
}

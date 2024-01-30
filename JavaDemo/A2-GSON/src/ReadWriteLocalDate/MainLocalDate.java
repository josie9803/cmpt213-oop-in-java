package ReadWriteLocalDate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class MainLocalDate {
    public static void main(String[] args){
        Rock rck = new Rock("Punice YAY", LocalDate.parse("1980-05-19"));

        //Create GSON object
//        Gson gson = new Gson();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        //Write to file
        try (FileWriter writer = new FileWriter("rockDate.json");){
            gson.toJson(rck, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Read from file
        try {
            Rock readRock = gson.fromJson(new FileReader("rockDate.json"), Rock.class);
            System.out.println("From fromJson(FileReader,...): " + readRock);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

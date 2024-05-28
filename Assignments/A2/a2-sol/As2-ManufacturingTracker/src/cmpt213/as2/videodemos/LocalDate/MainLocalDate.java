package cmpt213.as2.videodemos.LocalDate;

import cmpt213.as2.model.LocalDateAdapter;
import cmpt213.as2.videodemos.Location;
import cmpt213.as2.videodemos.PetRock;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainLocalDate {

    public static void main(String[] args) {
        List<PetRock> rocks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Location loc = new Location(40 + i, 123 + i);
            PetRock rck = new PetRock("Stoney " + i, 25 + i, loc);
            rocks.add(rck);
        }
        Rock rck = new Rock("Pumice", LocalDate.parse("1980-05-19"));

//        Gson gson = new Gson();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();

        try (FileWriter writer = new FileWriter("rockLocalDate.json")){
            gson.toJson(rck, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Rock readRock = gson.fromJson(new FileReader("rockLocalDate.json"), Rock.class);
            System.out.println("From fromJson(FileReader, ...): " + readRock);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

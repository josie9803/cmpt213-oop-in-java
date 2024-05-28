package cmpt213.as2.videodemos;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainSimpleSol {

    public static void main(String[] args){
        Location loc = new Location(49.45, 123.45);
        PetRock rck = new PetRock("Stoney", 25.5, loc);

        Gson gson = new Gson();

        String asJson = gson.toJson(rck);
//        System.out.println("From toJson(): " + asJson);

        try (FileWriter writer = new FileWriter("rock.json")){
            gson.toJson(rck, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            PetRock readRock = gson.fromJson(new FileReader("rock.json"), PetRock.class);
            System.out.println("From fromJson(FileReader, ...): " + readRock);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

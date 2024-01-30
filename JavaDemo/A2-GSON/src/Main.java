import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Location loc = new Location(49.45,123.45);
        PetRock rck = new PetRock("Stoney",25.5, loc);

        //1.Work with GSON library
        Gson gson = new Gson();

        //2.Convert to JSON
        String myJson = gson.toJson(rck);
        System.out.println(myJson); //print out the JSON format of object PetRock

        //3.Write to a file
        try {
            FileWriter writer = new FileWriter("rock.json");
            gson.toJson(rck, writer);
            writer.close(); //if doesn't have this line, the created json file will be empty
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //initialize the write inside try() -> no need to close
        try (FileWriter writer = new FileWriter("rock2.json");) {
            gson.toJson(rck, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //4.Read from a file
        try {
            FileReader reader = new FileReader("rock.json");
            PetRock rocky = gson.fromJson(reader, PetRock.class);
            System.out.println(rocky);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
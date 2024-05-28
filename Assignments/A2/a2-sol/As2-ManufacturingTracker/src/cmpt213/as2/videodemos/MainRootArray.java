package cmpt213.as2.videodemos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainRootArray {
    public static void main(String[] args){
        List<PetRock> rocks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Location loc = new Location(40 + i, 123 + i);
            PetRock rck = new PetRock("Stoney " + i, 25 + i, loc);
            rocks.add(rck);
        }

//        Gson gson = new Gson();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String asJson = gson.toJson(rocks);
        System.out.println("From toJson(): " + asJson);

        try (FileWriter writer = new FileWriter("rockArray.json")){
            gson.toJson(rocks, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            // Array
            PetRock[] readRocks = gson.fromJson(new FileReader("rockArray.json"), PetRock[].class);

//            Type rockListType = new TypeToken<ArrayList<PetRock>>(){}.getType();
//            List<Rock> readRocks = gson.fromJson(new FileReader("rockArray.json"), rockListType);

            for (PetRock r : readRocks) {
                System.out.println("readRocks: " + r);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

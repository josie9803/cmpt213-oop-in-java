package ReadWriteFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainArray {
    public static void main(String[] args){
        List<PetRock> rocks = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            Location loc = new Location(40 + i, 123 + i);
            PetRock rck = new PetRock("Stoney" + i, 25 + i, loc);
            rocks.add(rck);
        }

        //1.Create my GSON using built-in static factory method
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //2.Write my list/array to the file
        //NOTE: GSON & Java object notation do not differentiate list & arraylist
        try (FileWriter writer = new FileWriter("rockArray.json")){
            gson.toJson(rocks, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //3.Read from file
        try {
            //..as an array
//            FileReader reader = new FileReader("rockArray.json");
//            ReadWriteFile.PetRock[] myRocks = gson.fromJson(reader, ReadWriteFile.PetRock[].class);

            //..as a list (little different syntax)
            FileReader reader = new FileReader("rockArray.json");
            Type rockListType = new TypeToken<ArrayList<PetRock>>(){}.getType();
            List<PetRock> myRocks = gson.fromJson(reader, rockListType);

            for (PetRock r : myRocks){
                System.out.println(r);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

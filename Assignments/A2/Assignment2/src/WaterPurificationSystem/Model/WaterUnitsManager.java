package WaterPurificationSystem.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;

public class WaterUnitsManager implements Iterable<WaterUnit>{
    static List<WaterUnit> waterUnits = new ArrayList<>();
    @Override
    public Iterator<WaterUnit> iterator() {
        return waterUnits.iterator();
    }

    public int getSize() {
        return waterUnits.size();
    }

    public boolean isEmpty() {
        return waterUnits.isEmpty();
    }

    public void add(WaterUnit unit){
        waterUnits.add(unit);
    }

    public WaterUnit getUnitBySerialNumber(String serialNumber){
        for (WaterUnit waterUnit : waterUnits) {
            if (waterUnit.getSerialNumber().equals(serialNumber)) {
                return waterUnit;
            }
        }
        return null;
    }

    public List<WaterUnit> getWaterUnits() {
        return waterUnits;
    }

    public List<WaterUnit> getDefectiveUnits(){
        List<WaterUnit> defectiveUnits = new ArrayList<>();

        for (WaterUnit waterUnit : waterUnits) {
            if (!waterUnit.getTests().isEmpty()) {
                Test mostRecentTest = waterUnit.getMostRecentTest();

                if (!mostRecentTest.isTestPassed()) {
                    defectiveUnits.add(waterUnit);
                }
            }
        }

        return defectiveUnits;
    }

    public List<WaterUnit> getReadyToShipUnits(){
        List<WaterUnit> readyToShipUnits = new ArrayList<>();

        for (WaterUnit waterUnit : waterUnits) {
            if (!waterUnit.getTests().isEmpty()) {
                Test mostRecentTest = waterUnit.getMostRecentTest();

                if (mostRecentTest.isTestPassed() && !waterUnit.isShipped()) {
                    readyToShipUnits.add(waterUnit);
                }
            }
        }

        return readyToShipUnits;
    }
    public void loadJSONFile(String filePath){
        if (filePath.isEmpty()){
            return;
        }
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        try {
            FileReader reader = new FileReader(filePath);
            Type waterListType = new TypeToken<ArrayList<WaterUnit>>(){}.getType();
            waterUnits = gson.fromJson(reader, waterListType);
            System.out.println("Read " + waterUnits.size() + " products from JSON file '" + filePath + "'");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sortBySerialNumber(){
        Collections.sort(waterUnits, new Sorting.bySerialNumber());
    }

    public static void sortByModelAndSerialNumber(){
        Collections.sort(waterUnits, new Sorting.byModelAndSerialNumber());
    }

    public static void sortByRecentTestDate(){
        Collections.sort(waterUnits, new Sorting.byRecentTestDate());
    }
}

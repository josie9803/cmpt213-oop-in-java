package ReadWriteFile;

public class Location {
    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    //GSON doesn't need this bcuz it will look inside the object using Java-reflection
    @Override
    public String toString() {
        return "ReadWriteFile.Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

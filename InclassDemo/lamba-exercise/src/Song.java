/**
 * Store info on a single song
 */
public class Song {
    // Yes, these are public! THE HORROR!
    // (makes writing the streams a little easier, so we'll go with it).
    public String title;
    public double length;

    public Song(String title, double length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public double getLength() {
        return length;
    }
}
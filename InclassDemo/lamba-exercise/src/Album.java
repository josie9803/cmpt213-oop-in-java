import java.util.ArrayList;
import java.util.List;

/**
 * Store information about a single musical album.
 */
public class Album implements Comparable<Album> {
    // Yes, these are public! THE HORROR!
    // (makes writing the streams a little easier, so we'll go with it).
    public String artistName;
    public String albumTitle;
    public List<Song> songs = new ArrayList<>();

    public Album(String artistName, String albumTitle, List<Song> songs) {
        this.artistName = artistName;
        this.albumTitle = albumTitle;
        this.songs = songs;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public List<Song> getSongs() {
        return songs;
    }

    @Override
    public int compareTo(Album o) {
        return this.albumTitle.compareTo(o.albumTitle);
    }
}
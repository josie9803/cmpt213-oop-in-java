import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Complete the code in main to do the steps indicated.
 * Suggested resource / tutorial:
 *          https://stackify.com/streams-guide-java-8/
 */
public class StreamExercise2 {
    public static void printHeader(String msg) {
        System.out.println();
        System.out.println(msg);
    }

    public static void main(String[] args) {
        // Create a list of albums (hard-coded)
        List<Album> albums = ModelBuilder.makeModel();

        // * Display the name of each album...
        //    - in sorted order.
        //   Hint: try using a method reference if just printing:
        //        .forEach(System.out::println)
        printHeader("#1: Album names (sorted)");
        albums.stream()
                .map(Album::getAlbumTitle)
                .sorted()
                .forEach(System.out::println);

        printHeader("#1: Album names (sorted)");
        albums.stream()
                .sorted()
                .forEach(a -> System.out.println(a.getAlbumTitle()));

//        printHeader("#1: Album names (sorted)");
//        Collections.sort(albums); //use this line will actually sort albums
//        albums.forEach(a -> System.out.println(a.getAlbumTitle()));



        // * Display the artist name for each album..
        //    - in sorted order (sorted by artist name)..
        //    - with duplicates removed. (hint, look up distinct())
        printHeader("#2: Unique artist names, sorted order");
        //FALSE APPROACH:
//        albums.stream()
//                .distinct()
//                .sorted()
//                .forEach(a -> System.out.println(a.getArtistName()));
        albums.stream()
                .map(a -> a.getArtistName())
                .distinct().sorted()
                .forEach(System.out::println);


        // * Display the album title of albums which have more than 5 songs.
        printHeader("#3: Albums with >5 songs");
        albums.stream()
                .filter(a -> a.getSongs().size() > 5)
                .map(Album::getAlbumTitle)
                .forEach(System.out::println);


        // * Calculate and then display the average number of songs per album.
        //    - Hint: mapToInt() the number of songs on each album. This will make it an IntStream.
        //    - Hint: An IntStream can do math! https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
        printHeader("#4: Average number of songs");
        double avg = albums.stream()
                .mapToInt(s -> s.getSongs().size())
                .average().orElse(0);
        System.out.println(avg);


        // * Display the total number of songs
        //    - Hint: mapToInt() each album for the number of songs on the album. This will make it an IntStream.
        //    - Hint: An IntStream can do math! https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
        printHeader("#5: Total number songs");
        double total = albums.stream()
                .mapToInt(s -> s.getSongs().size())
                .sum();
        System.out.println(total);


        // * Print the names and length of all songs on the album with the most songs.
        //   Sort output by length of the song (shortest songs first).
        printHeader("#6: Songs on album with most songs");
        //albums.stream().mapToDouble(s -> s.getSongs().size()).max().orElse(0);
        Album mostSongsAlbum = albums.stream().max(new Comparator<Album>() {
            @Override
            public int compare(Album o1, Album o2) {
                return Integer.compare(o1.getSongs().size(), o2.getSongs().size());
//                if (o1.getSongs().size() > o2.getSongs().size())
//                    return 1;
//                else if (o1.getSongs().size() < o2.getSongs().size())
//                    return -1;
//                else
//                    return 0;
            }
        }).orElse(null);

        assert mostSongsAlbum != null;
//        mostSongsAlbum.getSongs().stream().sorted(new Comparator<Song>() {
//            @Override
//            public int compare(Song o1, Song o2) {
//                return Double.compare(o1.getLength(), o2.getLength());
//            }
//        }).forEach(s -> System.out.println(s.getTitle() + " (" + s.getLength() + ")"));

        mostSongsAlbum.getSongs().stream()
                .sorted(Comparator.comparingDouble(s -> s.getLength()))
                .forEach(s -> System.out.println(s.getTitle() + " (" + s.getLength() + ")"));

        // * Create a list of the name of all songs which are 4.0 minutes in length or longer
        //    (Print the list to the screen after you have created it).
        //    Hint: Calling flatMap() on a stream allows you to stream over a collection of inner objects.
        //
        //   Example: Print the name of all songs (uncomment-this)
        //    printHeader("#7.DEMO: All song names");
        //    albums.stream().flatMap(album -> album.songs.stream()).forEach(song -> System.out.println(song.title));
        printHeader("#7: Long songs");
        albums.stream().flatMap(album -> album.getSongs().stream())
                .filter(song -> song.getLength() >= 4.0)
                .forEach(song -> System.out.println(song.title));

        // * Print out the total time for all songs
        printHeader("#8: Total time");
        double totalTime = albums.stream().flatMap(album -> album.getSongs().stream())
                .mapToDouble(Song::getLength)
                .sum();
        System.out.println(totalTime);


        // * For each album, display "{Album title} by {Artist Name} has {Number Songs on Album} song(s)."
        printHeader("#9: Album summaries");
        albums.forEach(album -> System.out.println(album.getAlbumTitle()
                + " by " + album.getArtistName()
                + " has " + album.getSongs().size() + " songs."));


        // * Create a comma-separated string of the names of all artists, sorted the number of songs on the album (smallest first).
        //   Hint: Consider join
        printHeader("#10: Artist name for each album, sorted by # tracks on album; fewest first; comma separated.");
        String name = albums.stream().sorted(Comparator.comparingInt(a -> a.getSongs().size()))
                .map(Album::getArtistName)
                        .collect(Collectors.joining(", "));
        System.out.println(name);

        // * Display the name of the album with the most tracks.
        //   Hint: Try using .findFirst()
        printHeader("#11: Album with most tracks");
        Optional<Album> album = albums.stream().sorted(new Comparator<Album>() {
            @Override
            public int compare(Album o1, Album o2) {
                if (o1.getSongs().size() > o2.getSongs().size())
                    return -1;
                else if (o1.getSongs().size() < o2.getSongs().size())
                    return 1;
                else return 0;
            }
        }).findFirst();
        album.ifPresent(a -> System.out.println(a.getAlbumTitle()));



        // * Display the name and length of the shortest song (shortest length)
        //   OK to choose any behaviour if there's no shortest song (our data will always have one).
        //   Hint: try findFirst()
        //   Format: "Shortest: `{song title}` ({song duration})"
        printHeader("#12: Shortest song");
        Optional<Song> song = albums.stream()
                .flatMap(s -> s.getSongs().stream())
                .sorted(Comparator.comparingDouble(l -> l.getLength()))
                .findFirst();
        song.ifPresent(s -> System.out.println(s.getTitle() + "(" + s.getLength() + ")"));



        // * Display the name of all artists who sang at least one song which has a name shorter than 5 characters.
        printHeader("#13: Artists who have song(s) with short names");
        albums.stream()
                .flatMap(s -> s.getSongs().stream()
                .filter(n -> n.getTitle().length() < 5)
                        .map(a -> s.getArtistName())).forEach(System.out::println);

    }

}
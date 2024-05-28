import java.util.*;
import java.util.stream.Collectors;

/**
 * Complete the code in main to do the steps indicated.
 * Suggested resource / tutorial:
 *          https://stackify.com/streams-guide-java-8/
 */
public class StreamExercise {
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
                .map(a -> a.getAlbumTitle()) // Or .map(Album::getAlbumTitle)
                .sorted()
                .forEach(System.out::println);


        // * Display the artist name for each album..
        //    - in sorted order (sorted by artist name)..
        //    - with duplicates removed. (hint, look up distinct())
        printHeader("#2: Unique artist names, sorted order");
        albums.stream()
                .map(Album::getArtistName)
                .distinct()
                .sorted()
                .forEach(System.out::println);


        // * Display the album title of albums which have more than 5 songs.
        printHeader("#3: Albums with >5 songs");
        albums.stream()
                .filter(s -> s.getSongs().size() > 5)
                .forEach(a -> System.out.println(a.getAlbumTitle()));


        // * Calculate and then display the average number of songs per album.
        //    - Hint: mapToInt() the number of songs on each album. This will make it an IntStream.
        //    - Hint: An IntStream can do math! https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
        printHeader("#4: Average number of songs");
       OptionalDouble averageSongsPerAlbum = albums.stream()
                .mapToInt(s -> s.getSongs().size())
                        .average();
        if (averageSongsPerAlbum.isPresent()) {
            System.out.println("Avg: " + averageSongsPerAlbum.getAsDouble());
        }

        // * Display the total number of songs
        //    - Hint: mapToInt() each album for the number of songs on the album. This will make it an IntStream.
        //    - Hint: An IntStream can do math! https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
        printHeader("#5: Total number songs");
        double total = albums.stream()
                .mapToInt(s -> s.getSongs().size())
                        .sum();
        System.out.println("Sum: " + total);


        // * Print the names and length of all songs on the album with the most songs.
        //   Sort output by length of the song (shortest songs first).
        printHeader("#6: Songs on album with most songs");
        Album mostSongsAlbum = albums.stream()
//              .mapToInt(s -> s.getSongs().size())
                .max(Comparator.comparingInt(album -> album.getSongs().size()))
                .orElse(null);

        if (mostSongsAlbum != null) {
            mostSongsAlbum.getSongs().stream()
                    .sorted(Comparator.comparingDouble(s -> s.getLength()))
                    .forEach(s -> System.out.println(s.getTitle() + " (" + s.getLength() + ")"));
        }


        // * Create a list of the name of all songs which are 4.0 minutes in length or longer
        //    (Print the list to the screen after you have created it).
        //    Hint: Calling flatMap() on a stream allows you to stream over a collection of inner objects.
        //
        //   Example: Print the name of all songs (uncomment-this)
        //    printHeader("#7.DEMO: All song names");
        //    albums.stream().flatMap(album -> album.songs.stream()).forEach(song -> System.out.println(song.title));
        printHeader("#7: Long songs");
        List<Song> list = albums.stream()
                .flatMap(album -> album.getSongs().stream())
                .filter(s -> s.getLength() >= 4.0)
                .collect(Collectors.toList());

        for (Song s : list) {
            System.out.println(s.getTitle());
        }

        // * Print out the total time for all songs
        printHeader("#8: Total time");
        double totalLength = albums.stream()
                .flatMap(album -> album.getSongs().stream())
                .mapToDouble(s -> s.getLength())
                .sum();

        System.out.println(totalLength);

        // * For each album, display "{Album title} by {Artist Name} has {Number Songs on Album} song(s)."
        printHeader("#9: Album summaries");
        albums.stream().forEach(album -> {
            System.out.println(album.albumTitle + " by " + album.getArtistName() + " has " + album.getSongs().size() + " song(s).");
        });


        // * Create a comma-separated string of the names of all artists, sorted the number of songs on the album (smallest first).
        //   Hint: Consider join
        printHeader("#10: Artist name for each album, sorted by # tracks on album; fewest first; comma separated.");
        String names = albums.stream()
                .sorted(Comparator.comparingInt(a -> a.getSongs().size()))
                        .map(album -> album.getArtistName())
                        .collect(Collectors.joining(", "));
        System.out.println(names);

        // * Display the name of the album with the most tracks.
        //   Hint: Try using .findFirst()
        printHeader("#11: Album with most tracks");
        Optional<Album> album = albums.stream()
                .sorted(Comparator.comparingInt((Album a) -> a.getSongs().size()).reversed())
                .findFirst();
        album.ifPresent(a -> System.out.println(a.getAlbumTitle()));


        // * Display the name and length of the shortest song (shortest length)
        //   OK to choose any behaviour if there's no shortest song (our data will always have one).
        //   Hint: try findFirst()
        //   Format: "Shortest: `{song title}` ({song duration})"
        printHeader("#12: Shortest song");
        Optional<Song> song = albums.stream()
                .flatMap(a -> a.getSongs().stream())
                .sorted(Comparator.comparingDouble(s -> s.getLength()))
                .findFirst();

        song.ifPresent(s -> System.out.println("Shortest: " + s.getTitle() + ", " + s.getLength()));


        // * Display the name of all artists who sang at least one song which has a name shorter than 5 characters.
        printHeader("#13: Artists who have song(s) with short names");
        List<String> artists = albums.stream()
                .flatMap(a -> a.getSongs().stream()
                        .filter(s -> s.getTitle().length() < 5)
                        .map(s -> a.getArtistName())
                )
                .collect(Collectors.toList());

        artists.forEach(System.out::println);

        /**
         *  List<String> artists = albums.stream()
         *                 .filter(album -> album.getSongs().stream().anyMatch(song -> song.getTitle().length() < 5))
         *                 .map(Album::getArtistName)
         *                 .distinct()
         *                 .collect(Collectors.toList());
         *
         *         artists.forEach(System.out::println);
         */
    }

}
import java.util.ArrayList;
import java.util.List;

/**
 * Create a model using hard-coded data.
 * ChatGPT 3.5 used to generate the strings.
 */
public class ModelBuilder {
    public static List<Album> makeModel() {
        return new ArrayList<>() {{
            add(new Album(
                    "Fatima Code Surgeon Supreme",
                    "Pixel Paragon",
                    new ArrayList<>() {{
                        add(new Song("Hackathon Harmony"          , 3.2));
                        add(new Song("Bootstrap Ballroom"         , 4.8));
                        add(new Song("Electron Ecstasy"           , 2.5));
                    }}
            ));

            add(new Album(
                    "Aiden the Quantum Flowmaster",
                    "Quantum Resonance",
                    new ArrayList<>() {{
                        add(new Song("Binary Serenade"            , 3.5));
                        add(new Song("Syntax Symphony"            , 3.1));
                        add(new Song("Loop Dreams"                , 2.3));
                        add(new Song("Code Cascade"               , 2.6));
                        add(new Song("Algorithmic Echoes"         , 3.0));
                    }}
            ));

            add(new Album(
                    "Aiden the Quantum Flowmaster",
                    "Second Iteration",
                    new ArrayList<>() {{
                        add(new Song("Up++"                       , 1.5));
                    }}
            ));

            add(new Album(
                    "Bianca the Algorithmic Alchemist",
                    "Silicon Symphony",
                    new ArrayList<>() {{
                        add(new Song("Binary Love Ballad"         , 3.1));
                        add(new Song("Code Symphony in C#"        , 3.5));
                        add(new Song("Algorithmic Serenade"       , 5.9));
                        add(new Song("Debugging Blues"            , 4.1));
                        add(new Song("Java Dreamscape"            , 6.3));
                        add(new Song("HTML Heartbeat"             , 7.3));
                        add(new Song("CSS Waltz"                  , 4.1));
                        add(new Song("char"                       , 0.1));
                    }}
            ));

            add(new Album(
                    "Cyber-Chen Cipher X",
                    "Cyberspace Overture",
                    new ArrayList<>() {{
                        add(new Song("Git Commit Confessions"     , 2.4));
                        add(new Song("Ruby Red Romance"           , 2.1));
                        add(new Song("API Lullaby"                , 1.9));
                        add(new Song("Data Harmony Sonata"        , 5.3));
                        add(new Song("JavaScript Jive"            , 2.1));
                    }}
            ));

            add(new Album(
                    "Dimitri the Syntax Sultan",
                    "Magnetic Core Odyssey",
                    new ArrayList<>() {{
                        add(new Song("Object-Oriented Overture"   , 3.0));
                        add(new Song("Code Comments Carol"        , 1.0));
                        add(new Song("PHP Rhapsody"               , 2.0));
                        add(new Song("MySQL Melody"               , 4.0));
                        add(new Song("Virtual Reality Requiem"    , 5.0));
                        add(new Song("Kernel Crush"               , 6.0));
                    }}
            ));

            add(new Album(
                    "Esme Bitwise Bard",
                    "Circuit Chronicles",
                    new ArrayList<>() {{
                        add(new Song("GUI Groove"                 , 4.9));
                        add(new Song("Firewall Flamenco"          , 3.8));
                        add(new Song("Recursive Reverie"          , 2.6));
                        add(new Song("JavaFX Jamboree"            , 3.1));
                        add(new Song("Bytebeat Ballroom"          , 2.5));
                        add(new Song("Docker Duet"                , 2.3));
                        add(new Song("API Anthem"                 , 1.9));
                    }}
            ));


            add(new Album(
                    "Gopal Crypto Crusader",
                    "Transistor Tango",
                    new ArrayList<>() {{
                        add(new Song("Codebase Cantata"           , 3.5));
                        add(new Song("Neural Network Nocturne"    , 3.6));
                        add(new Song("Cloud Computing Concerto"   , 3.9));
                        add(new Song("Flutter Fantasy"            , 3.6));
                        add(new Song("AJAX Aria"                  , 3.8));
                        add(new Song("JSON Jig"                   , 3.3));
                        add(new Song("CSS Cascade Concert"        , 3.0));
                        add(new Song("Debugging Waltz"            , 3.1));
                        add(new Song("Machine Learning Minuet"    , 3.8));
                        add(new Song("Software Synthesis Serenade", 3.9));
                        add(new Song("Git Harmony"                , 3.4));
                        add(new Song("CodeCrafters Chorus"        , 3.5));
                    }}
            ));
            add(new Album(
                    "Hiroshi the Pixel Poet",
                    "Binary Eclipse",
                    new ArrayList<>() {{
                        add(new Song("Kotlin Capriccio"           , 11.1));
                    }}
            ));
            add(new Album(
                    "Jamal the Neural Network Nomad",
                    "Motherboard Melodies",
                    new ArrayList<>() {{
                        add(new Song("Regex Romance"              , 2.6));
                        add(new Song("Code Chameleon Cha-Cha"     , 2.4));
                    }}
            ));
            add(new Album(
                    "Isabella Binary Maestro",
                    "Echoes of RAM",
                    new ArrayList<>() {{
                        add(new Song("Encryption Elegy"           , 4.1));
                        add(new Song("Blockchain Ballet"          , 2.0));
                        add(new Song("Responsive Design Rhapsody" , 3.2));
                        add(new Song("HTML5 Hymn"                 , 5.6));
                        add(new Song("API Allegro"                , 2.4));
                        add(new Song("Serverless Serendipity"     , 2.8));
                    }}
            ));




        }};
    }
}
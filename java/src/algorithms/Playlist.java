package algorithms;

import java.util.HashSet;

/**
 * From Square Enix Montréal coding test:
 * <p>
 * A playlist is considered a repeating playlist if any of the songs contain a
 * reference to a previous song in the playlist. Otherwise, the playlist will
 * end with the last song which points to null.
 * <p>
 * Implement a function IsRepeatingPlaylist that returns true if a playlist is
 * repeating or false if it is not. For example, the following code prints
 * "true" as both songs point to each other.
 *
 * <pre>
 * Song first = new Song("Hello");
 * Song second = new Song("Eye of the tiger");
 * first.NextSong = second;
 * second.NextSong = first;
 * Console.WriteLine(first.IsRepeatingPlaylist());
 * </pre>
 */
public class Playlist implements Algorithm {

    @Override
    public void execute() {
        System.out.println("Executing Playlist algorithm");
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(String.format("Is the playlist repeating: %s", first.isRepeatingPlaylist()));
    }
}

class Song {
    private final String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Song getNextSong() {
        return nextSong;
    }

    public void setNextSong(Song song) {
        this.nextSong = song;
    }

    public boolean isRepeatingPlaylist() {
        // Use HashSet for O(1) search
        HashSet<String> songTracker = new HashSet<>();
        Song current = this;

        // While there are songs in the playlist...
        while (current.getNextSong() != null) {
            String currentName = current.getName();
            // If the song has already been saved
            if (songTracker.contains(currentName)) {
                return true;
            }

            songTracker.add(currentName);
            current = current.getNextSong();
        }

        return false;
    }
}

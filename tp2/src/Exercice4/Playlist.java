package Exercice4;

import java.util.ArrayList;
import java.util.Collections;

public class Playlist {
    private User user;
    private final ArrayList<Song> songs;

    public Playlist(User u) {
        user = u;
        songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public void removeSong(Song song) {
        this.songs.remove(song);
    }

    public void shuffle() {
        Collections.shuffle(this.songs);
    }

    public int getLength() { return songs.size(); }

    public String toString() {
        return songs.toString();
    }

}

package Exercice4;

import java.util.ArrayList;

public class Album {
    private ArrayList<Song> songs;
    private String name;


    public Album(String n) {
        name = n;
        songs = new ArrayList<>();
    }
    public String getName() {
        return this.name;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public void removeSong(Song song) {
        this.songs.remove(song);
    }

    public void listSongs() {
        for(Song song : this.songs) {
            System.out.println(song.getName());
        }
    }
}

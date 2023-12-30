package Exercice4;


import java.util.ArrayList;

public class Artist {

    private final ArrayList<Album> albums;

    private final String name;
    public Artist(String n) {
        name = n;
        albums = new ArrayList<>();
    }

    Artist(String n, ArrayList<Album> a) {
        name = n;
        albums = a;
    }

    public void addAlbum(Album album) {
        this.albums.add(album);
    }

    public void removeAlbum(Album album) {
        this.albums.remove(album);
    }

    public String getName() {return name; }

    public void listAlbums() {
        for(Album album : this.albums) {
            System.out.println(album.getName());
        }
    }
}

package Exercice4;

public class FreeUser implements User {
    private static final int LIMIT = 2;

    @Override
    public void listen(Song song) {

        if((int)(Math.random()*2)==1) {
            song.playSong();
        } else {
            System.out.println("Advertisement.......");
        }
    }

    @Override
    public void addToPlaylist(Song song, Playlist playlist) {
        if(playlist.getLength() == LIMIT) {
            System.out.printf("Cannot add more than %d songs to the playlist as free user.\n", LIMIT);
        } else {
            playlist.addSong(song);
        }
    }
}

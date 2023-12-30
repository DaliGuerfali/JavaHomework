package Exercice4;



public class PremiumUser implements User {
    @Override
    public void listen(Song song) {
        song.playSong();
    }

    @Override
    public void addToPlaylist(Song song, Playlist playlist) {
        playlist.addSong(song);
    }
}

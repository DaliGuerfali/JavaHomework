package Exercice4;

public class Song {
    private final int length;
    private final String name;

    public Song(String n, int l) {
        name = n;
        length = l;
    }

    public void playSong() {
        System.out.printf("Playing %s.\n", this.name);
    }
    public int getLength() {
        return this.length;
    }
    public String getName() {
        return this.name;
    }

    public String toString() { return String.format("%s: %d mins", getName(), getLength()); }

}

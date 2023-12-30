import Exercice3.*;
import Exercice4.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        /*

        CUSTOM_STACK IMPLEMENTATION

        Exercice1.CustomStack<Integer> stack = new Exercice1.CustomStack<>(5);
        System.out.println(stack.LastInStack());
        System.out.println(stack.StackIsEmpty());
        stack.addElement(1);
        stack.addElement(2);
        System.out.println(stack);
        stack.addElement(3);
        stack.addElement(4);
        System.out.println(stack.LastInStack());
        stack.addElement(5);
        System.out.println(stack);
        System.out.println(stack.StackIsFull());
        stack.addElement(6);
        System.out.println(stack);
        stack.removeElement();
        stack.removeElement();
        System.out.println(stack.LastInStack());
        System.out.println(stack);
        */


        /*

        head first design patterns strategy pattern

        Exercice2.MallardDuck mallardDuck = new Exercice2.MallardDuck();
        Exercice2.RedheadDuck redheadDuck = new Exercice2.RedheadDuck();
        Exercice2.RubberDuck rubberDuck = new Exercice2.RubberDuck();
        Exercice2.DecoyDuck decoyDuck = new Exercice2.DecoyDuck();

        mallardDuck.swim();
        mallardDuck.display();
        mallardDuck.fly();
        mallardDuck.quack();

        redheadDuck.swim();
        redheadDuck.display();
        redheadDuck.fly();
        redheadDuck.quack();

        rubberDuck.swim();
        rubberDuck.display();
        rubberDuck.quack();

        decoyDuck.swim();
        decoyDuck.display();
        */
        /*
        Library lib = new Library(new ArrayList<>(Arrays.asList(
                new Novel("novelTest","novelAuth","test","2023"),
                new Textbook("textbookTest","textbookAuth","test","2023")
        )));

        lib.listBooks();
        Book toAddAndRemove = new Novel("adding test","novelAuth","test","2023");
        lib.addBook(toAddAndRemove);
        lib.listBooks();
        lib.removeBook(toAddAndRemove);
        lib.listBooks();
        lib.addBook(toAddAndRemove);

        Book textbook = new Textbook("textbookTest2","textbookAuth2","test2","2023");
        Book novel = new Novel("novelTest","novelAuth","test","2023");
        lib.addBook(textbook);
        lib.addBook(novel);
        Student student = new Student("student");
        Teacher teacher = new Teacher("teacher");
        student.borrowBook(toAddAndRemove, lib);
        student.borrowBook(textbook, lib);

        teacher.borrowBook(textbook,lib);
        teacher.borrowBook(novel, lib);
        lib.listBooks();
        teacher.returnBook(novel,lib);
        teacher.returnBook(textbook,lib);
        student.returnBook(toAddAndRemove, lib);
        lib.listBooks();

        System.out.println(student.getLibraryCard().getCard());
        System.out.println(teacher.getLibraryCard().getCard());
        */

        Song song1 = new Song("song1", 1);
        Song song2 = new Song("song2", 2);
        Song song3 = new Song("song3", 3);
        Song song4 = new Song("song4", 4);

        Album album1 = new Album("album1");
        Album album2 = new Album("album2");

        album1.addSong(song1);
        album1.addSong(song2);
        album2.addSong(song3);
        album2.addSong(song4);

        album1.listSongs();
        album2.listSongs();

        Artist artist1 = new Artist("artist1");

        artist1.addAlbum(album1);
        artist1.addAlbum(album2);

        artist1.listAlbums();



        FreeUser free = new FreeUser();
        Playlist freePlaylist = new Playlist(free);

        PremiumUser premium = new PremiumUser();
        Playlist premiumPlaylist = new Playlist(premium);

        free.addToPlaylist(song1, freePlaylist);
        free.addToPlaylist(song2, freePlaylist);
        free.addToPlaylist(song3, freePlaylist);

        premium.addToPlaylist(song1, premiumPlaylist);
        premium.addToPlaylist(song2, premiumPlaylist);
        premium.addToPlaylist(song3, premiumPlaylist);
        premium.addToPlaylist(song4, premiumPlaylist);

        System.out.println(freePlaylist);
        System.out.println(premiumPlaylist);

        premiumPlaylist.shuffle();
        System.out.println(premiumPlaylist);

        free.listen(song1);
        free.listen(song2);
        free.listen(song3);
        free.listen(song4);

        premium.listen(song1);
        premium.listen(song2);
        premium.listen(song3);
        premium.listen(song4);

    }
}
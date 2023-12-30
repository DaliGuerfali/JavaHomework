package Exercice3;


import java.util.ArrayList;

public class Teacher implements LibraryUser {

    private final ArrayList<Book> borrowedBooks;
    private LibraryCard card;

    private final static int LIMIT = 5;

    public Teacher(String name) {
        this.borrowedBooks = new ArrayList<>();
        card = new LibraryCard(name);
    }
    public Teacher(ArrayList<Book> borrowed, Library lib, String name) {
        this.borrowedBooks = new ArrayList<>();
        borrowed.forEach(book -> this.borrowBook(book, lib));
        card = new LibraryCard(name);
    }

    @Override
    public void borrowBook(Book book, Library lib) {
        if(borrowedBooks.size() == LIMIT) {
            System.out.printf("Students cannot borrow more than %d books\n", LIMIT);
            return;
        }
        if(!lib.haveBook(book) || this.borrowedBooks.contains(book)) return;
        lib.removeBook(book);
        this.borrowedBooks.add(book);
    }

    @Override
    public void returnBook(Book book, Library lib) {
        if(lib.haveBook(book) || !this.borrowedBooks.contains(book)) return;
        lib.addBook(book);
        this.borrowedBooks.remove(book);
    }

    @Override
    public LibraryCard getLibraryCard() {
        return card;
    }
}


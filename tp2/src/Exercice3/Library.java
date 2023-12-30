package Exercice3;


import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }
    public Library(ArrayList<Book> books) {
        this.books = books;
    }
    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public void listBooks() {
        this.books.forEach(Book::displayInformation);
    }

    public boolean haveBook(Book book) {
        return this.books.contains(book);
    }

}

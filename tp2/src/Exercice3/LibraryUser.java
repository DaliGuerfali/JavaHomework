package Exercice3;


public interface LibraryUser {
    void borrowBook(Book book, Library lib);
    void returnBook(Book book, Library lib);

    LibraryCard getLibraryCard();

}

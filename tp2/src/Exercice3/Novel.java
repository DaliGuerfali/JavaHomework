package Exercice3;

import Exercice3.Book;

public class Novel extends Book {
    private final String genre;


    public Novel(String title, String author, String genre, String year) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearOfPublication = year;
    }

    public String getGenre() { return this.genre; }

    @Override
    public void displayInformation() {
        System.out.printf(
"------------------\nNovel's Title: %s\nNovel's Author: %s\nENovel's Genre: %s\nNovel's Year Of Publication: %s\n------------------\n",
                this.title,this.author,this.genre,this.yearOfPublication
        );
    }

}

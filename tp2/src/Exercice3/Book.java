package Exercice3;

public abstract class Book {
    protected String title;
    protected String author;
    protected String yearOfPublication;

    public String getTitle() { return this.title; }
    public String getAuthor() { return this.author; }
    public String getYearOfPublication() { return this.yearOfPublication; }


    public abstract void displayInformation();

}

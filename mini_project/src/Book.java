
public class Book {
    private String title;
    private String author;
    private String dueDate;
    private String year;

    private boolean isBorrowed;

    public Book(String title, String author, String year, String dueDate) {
        this.title = title;
        this.author = author;
        this.dueDate = dueDate;
        this.year = year;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getDueDate() {
        return this.dueDate;
    }



    public String toString() {
        return this.title + " by " + this.author + " is due on " + this.dueDate;
    }

    public boolean isBorrowed() {
        return this.isBorrowed;
    }

}

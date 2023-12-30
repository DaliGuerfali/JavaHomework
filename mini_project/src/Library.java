import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private ArrayList<Event> events;

    public Library() {
        this.books = new ArrayList<Book>();
        this.users = new ArrayList<User>();
        this.events = new ArrayList<Event>();
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public ArrayList<Event> getEvents() {
        return this.events;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }

    public void removeEvent(Event event) {
        this.events.remove(event);
    }

    public ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> availableBooks = new ArrayList<Book>();
        for (Book book : this.books) {
            if (!book.isBorrowed()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public ArrayList<Book> getBorrowedBooks() {
        ArrayList<Book> borrowedBooks = new ArrayList<Book>();
        for (Book book : this.books) {
            if (book.isBorrowed()) {
                borrowedBooks.add(book);
            }
        }
        return borrowedBooks;
    }





    public ArrayList<Event> getAvailableEvents() {
        ArrayList<Event> availableEvents = new ArrayList<Event>();
        for (Event event : this.events) {
            if (!event.isFull()) {
                availableEvents.add(event);
            }
        }
        return availableEvents;
    }

    public ArrayList<Event> getFull() {
        ArrayList<Event> fullEvents = new ArrayList<Event>();
        for (Event event : this.events) {
            if (event.isFull()) {
                fullEvents.add(event);
            }
        }
        return fullEvents;
    }
}

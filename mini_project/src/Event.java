
import java.util.ArrayList;

public class Event {
    private String name;
    private String date;
    private String time;
    private int maxAttendees;

    private ArrayList<User> attendees;

    public Event(String name, String date, String time, int maxAttendees) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.maxAttendees = maxAttendees;
        this.attendees = new ArrayList<User>();
    }

    public String getName() {
        return this.name;
    }

    public String getDate() {
        return this.date;
    }

    public String getTime() {
        return this.time;
    }

    public int getMaxAttendees() {
        return this.maxAttendees;
    }

    public ArrayList<User> getAttendees() {
        return this.attendees;
    }

    public int getAttendeesCount() {
        return this.attendees.size();
    }

    public void addAttendee(User user) {
        this.attendees.add(user);
    }

    public void removeAttendee(User user) {
        this.attendees.remove(user);
    }

    public int getAvailableSeats() {
        return this.maxAttendees - this.attendees.size();
    }

    public boolean hasAttendee(User user) {
        return this.attendees.contains(user);
    }

    public boolean isFull() {
        return this.attendees.size() >= this.maxAttendees;
    }

    public String toString() {
        return "Event: " + this.name + "\nDate: " + this.date + "\nTime: " + this.time + "\nMax Attendees: " + this.maxAttendees;
    }
}

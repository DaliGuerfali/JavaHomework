public class Booking {
    private User user;
    private Event event;
    private String startDate;
    private String endDate;

    public Booking(User user, Event event, String startDate, String endDate) {
        this.user = user;
        this.event = event;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String toString() {
        return this.user.getName() + " is booked for " + this.event.getName();
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public Event getEvent() {
        return this.event;
    }

    public User getUser() {
        return this.user;
    }

}

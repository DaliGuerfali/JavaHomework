public class Instructor {
    private final int instructorId;
    private final String firstName;
    private final String lastName;


    Instructor(int instructorId, String firstName, String lastName) {
        this.instructorId = instructorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getInstructorId() { return this.instructorId; }

    public String getFirstName() { return this.firstName; }

    public String getLastName() { return this.lastName; }

    public void showInfo()  {
        System.out.print("---------------------------\n");
        System.out.printf("Instructor: %s %s\n",this.getFirstName(), this.getLastName());
        System.out.printf("Instructor ID: %d\n", this.getInstructorId());
        System.out.print("---------------------------\n");
    }

}

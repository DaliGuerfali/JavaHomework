import java.util.ArrayList;

public class Student {
    private final int studentId;
    private final String firstName;
    private final String lastName;
    private final ArrayList<Course> courses;


    Student(int studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = new ArrayList<>();
    }
    public int getStudentId() {
        return this.studentId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public void enroll(Course course) {
        this.courses.add(course);
    }

    public String coursesToPrint() {
        StringBuilder res = new StringBuilder("[");
        for(int i = 0; i < this.getCourses().size() - 1; i++) {
            res.append(this.getCourses().get(i).getCourseName()).append(", ");
        }
        res.append(this.getCourses().get(this.getCourses().size() - 1).getCourseName()).append("]");
        return res.toString();
    }

    public void showInfo()  {
        System.out.print("---------------------------\n");
        System.out.printf("Student: %s %s\n",this.getFirstName(), this.getLastName());
        System.out.printf("Student ID: %d\n", this.getStudentId());
        System.out.printf("Courses enrolled: %s\n", this.coursesToPrint());
        System.out.print("---------------------------\n");
    }

}
public class Course {
    private final int courseId;
    private final String courseName;
    private final Instructor instructor;

    Course(int courseId, String courseName, Instructor instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public int getCourseId() { return this.courseId; }

    public String getCourseName() { return this.courseName; }

    public Instructor getInstructor() { return this.instructor; }

    public void showInfo() {
        System.out.print("---------------------------\n");
        System.out.printf("Course: %s\n",this.getCourseName());
        System.out.printf("Course ID: %d\n", this.getCourseId());
        System.out.printf("Course Instructor: %s %s\n", this.getInstructor().getFirstName(), this.getInstructor().getLastName());
        System.out.print("---------------------------\n");
    }

}

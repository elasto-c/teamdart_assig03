import java.util.ArrayList;
import java.util.List;

class Staff {
  public Staff(int staffId, String name) {
    this.staffId = staffId;
    this.name = name;
  }

  public int getStaffId() {
    return staffId;
  }

  public String getName() {
    return name;
  }

  private final int staffId;
  private final String name;
}

class Course {
  public Course(int courseId, String name, int staffId) {
    this.courseId = courseId;
    this.name = name;
    this.staffId = staffId;
  }

  public int getCourseId() {
    return courseId;
  }

  public String getName() {
    return name;
  }

  public int getStaffId() {
    return staffId;
  }

  private final int courseId;
  private final String name;
  private final int staffId;
}

public class Main {
  public static void main(String[] args) {
    // Sample data
    Staff[] staffs = {new Staff(1, "Alice"), new Staff(2, "Bob")};
    Course[] courses = {
      new Course(101, "Programming 101", 1),
      new Course(102, "Data Analysis", 2)
    };

    // Example usage
    int staffId = 1;
    Course[] staffCourses = getStaffCourses(staffId, courses);

    // Print staff information and courses taught
    System.out.println("Staff: " + staffs[staffId - 1].getName() + " (" + staffs[staffId - 1].getStaffId() + ")");
    if (staffCourses.length > 0) {
      System.out.println("Courses Taught:");
      for (Course course : staffCourses) {
        System.out.println("- " + course.getName() + " (" + course.getCourseId() + ")");
      }
    } else {
      System.out.println("This staff member does not teach any courses.");
    }
  }


  // Function to find courses taught by a particular staff member
  public static Course[] getStaffCourses(int staffId, Course[] courses) {
    List<Course> staffCourses = new ArrayList<>();
    for (Course course : courses) {
      if (course.getStaffId() == staffId) {
        staffCourses.add(course);
      }
    }
    return staffCourses.toArray(new Course[0]);
  }

}

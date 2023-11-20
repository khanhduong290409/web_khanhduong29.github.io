package lab9;
import java.util.Arrays;
import java.util.List;


public class test {
	public static void main(String[] args) {
        // Tạo sinh viên
        Student student1 = new Student(1, "John Doe", 2022);
        Student student2 = new Student(2, "Jane Doe", 2023);
        Student student3 = new Student(3, "Bob Smith", 2022);

        // Tạo học phần
        Course course1 = new Course(101, "Introduction to Programming", "thực hành", Arrays.asList(student1, student2), "Dr. A");
        Course course2 = new Course(102, "Data Structures", "lý thuyết", Arrays.asList(student2, student3), "Dr. B");
        Course course3 = new Course(103, "Database Management", "thực hành", Arrays.asList(student1, student3), "Dr. C");

        // Tạo khoa CNTT
        Faculty faculty = new Faculty("Computer Science", "123 Main Street", Arrays.asList(course1, course2, course3));

        // Test getMaxPracticalCourse()
        Course maxPracticalCourse = faculty.getMaxPracticalCourse();
        System.out.println("Course with the most students in practical sessions: " + maxPracticalCourse.getTitle());
        
       
        // Test groupStudentsByYear()
        System.out.println("Students grouped by year:");
        faculty.groupStudentsByYear().forEach((year, studentList) ->
                System.out.println("Year " + year + ": " + studentList));

        // Test filterCourses()
        String filterType = "thực hành";
        System.out.println("Filtered courses of type '" + filterType + "' sorted by student count:");
        faculty.filterCourses(filterType).forEach(course ->
                System.out.println(course.getTitle() + " - Student Count: " + course.getStudentCount()));
    }
}



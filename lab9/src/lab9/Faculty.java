package lab9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
	private String name, address;
	private List<Course> courses;
	public Faculty(String name, String address, List<Course> courses) {
        this.name = name;
        this.address = address;
        this.courses = courses;
    
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public Course getMaxPracticalCourse() {
	    Course maxPracticalCourse = null;
	    int maxStudentCount = 0;

	    for (Course course : courses) {
	        if ("thực hành".equals(course.getType()) && course.getStudentCount() > maxStudentCount) {
	            maxPracticalCourse = course;
	            maxStudentCount = course.getStudentCount();
	        }
	    }

	    return maxPracticalCourse;
	}

	    public Map<Integer, List<Student>> groupStudentsByYear() {
	        Map<Integer, List<Student>> studentMap = new HashMap<>();

	        for (Course course : courses) {
	            for (Student student : course.getStudents()) {
	                int year = student.getYear();
	                studentMap.computeIfAbsent(year, k -> new ArrayList<>()).add(student);
	            }
	        }

	        return studentMap;
	    }
	    public Set<Course> filterCourses(String type) {
	        Set<Course> filteredCourses = new TreeSet<>(Comparator.comparingInt(Course::getStudentCount).reversed());

	        for (Course course : courses) {
	            if (course.getType().equals(type)) {  // Sử dụng equals() để so sánh chuỗi
	                filteredCourses.add(course);
	            }
	        }

	        return filteredCourses;
	    }
	}



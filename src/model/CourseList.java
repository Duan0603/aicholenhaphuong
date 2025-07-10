package model;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CourseList {
    private final ArrayList<Course> allCourses = new ArrayList<>();

    public CourseList() {
        loadCoursesFromFile("course.txt");
    }

    private void loadCoursesFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    allCourses.add(new Course(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Course> getAllCourses() {
        return allCourses;
    }

    public Course getCourseById(String id) {
        return allCourses.stream()
                .filter(c -> c.getCourseId().equals(id.trim()))
                .findFirst().orElse(null);
    }
}

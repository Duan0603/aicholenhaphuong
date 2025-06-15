package model;

import java.util.ArrayList;

public class CourseList {
    private final ArrayList<Course> allCourses = new ArrayList<>();

    public CourseList() {
        allCourses.add(new Course("CS101", "Nhập môn Lập trình Java", CourseTopics.PROGRAMMING, DifficultyLevels.BEGINNER));
        allCourses.add(new Course("CS201", "Lập trình hướng đối tượng", CourseTopics.PROGRAMMING, DifficultyLevels.INTERMEDIATE));
        allCourses.add(new Course("DB101", "Cơ sở dữ liệu SQL", CourseTopics.DATABASE, DifficultyLevels.BEGINNER));
        allCourses.add(new Course("WD101", "Thiết kế Web với HTML & CSS", CourseTopics.WEB_DEVELOPMENT, DifficultyLevels.BEGINNER));
        allCourses.add(new Course("AI101", "Giới thiệu về Trí tuệ Nhân tạo", CourseTopics.ARTIFICIAL_INTELLIGENCE, DifficultyLevels.BEGINNER));
        allCourses.add(new Course("AI201", "Học máy cơ bản", CourseTopics.ARTIFICIAL_INTELLIGENCE, DifficultyLevels.INTERMEDIATE));
        allCourses.add(new Course("DS201", "Phân tích Dữ liệu với Python", CourseTopics.DATA_SCIENCE, DifficultyLevels.INTERMEDIATE));
        allCourses.add(new Course("PM101", "Quản lý dự án Agile", CourseTopics.PROJECT_MANAGEMENT, DifficultyLevels.INTERMEDIATE));
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

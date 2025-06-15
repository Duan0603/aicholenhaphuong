package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Recommendation {
    private final CourseList courseDB;
    private final GeminiClient apiClient;

    public Recommendation(CourseList courseDB, GeminiClient apiClient) {
        this.courseDB = courseDB;
        this.apiClient = apiClient;
    }

    public ArrayList<Course> generateLearningPathFor(String userGoal, int numberOfSteps) throws IOException, InterruptedException {
        ArrayList<Course> allCourses = courseDB.getAllCourses();
        ArrayList<String> pathIds = apiClient.fetchLearningPath(userGoal, allCourses);

        if(pathIds.isEmpty()) {
            return new ArrayList<>();
        }

        // Trả về danh sách Course theo đúng thứ tự mà API đã đề xuất
        return (ArrayList<Course>) pathIds.stream()
                .map(courseDB::getCourseById)
                .filter(course -> course != null)
                .limit(numberOfSteps)
                .collect(Collectors.toList());
    }
}

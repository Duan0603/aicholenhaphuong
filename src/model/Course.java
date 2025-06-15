package model;

public class Course {
    private final String courseId;
    private final String courseName;
    private final String topic;
    private final String difficulty;

    public Course(String courseId, String courseName, String topic, String difficulty) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.topic = topic;
        this.difficulty = difficulty;
    }

    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getTopic() { return topic; }
    public String getDifficulty() { return difficulty; }

    @Override
    public String toString() {
        return String.format("'%s' (ID: %s, Chủ đề: %s, Cấp độ: %s)",
                courseName, courseId, topic, difficulty);
    }
}

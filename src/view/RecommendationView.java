package view;

import model.Course;

import java.util.ArrayList;

public class RecommendationView {
    public void displayWelcomeMessage() {
        System.out.println("--- AGENT TƯ VẤN LỘ TRÌNH HỌC TẬP (MVC Version) ---");
    }

    public String promptForUserGoal() {
        System.out.println("\nChào bạn, tôi là Agent tư vấn. Bạn muốn học về lĩnh vực gì?");
        System.out.println("(Ví dụ: 'lập trình AI', 'phát triển web cho người mới bắt đầu', 'học về cơ sở dữ liệu')");
        return Validation.getString("> ");

    }

    public void displayAnalysisMessage(String userGoal) {
        System.out.printf("\nĐã nhận yêu cầu: \"%s\".\n", userGoal);
        System.out.println("Agent đang phân tích và tạo lộ trình... Vui lòng chờ.");
    }

    public void displayLearningPath(String userGoal, ArrayList<Course> path) {
        System.out.println("\n=======================================================");
        System.out.printf("--- LỘ TRÌNH ĐỀ XUẤT CHO '%s' ---\n", userGoal.toUpperCase());
        if (path.isEmpty()) {
            System.out.println("Rất tiếc, không thể tạo lộ trình phù hợp hoặc có lỗi xảy ra.");
        } else {
            int step = 1;
            for (Course course : path) {
                System.out.printf("Bước %d: %s\n", step++, course);
            }
        }
        System.out.println("=======================================================\n");
    }

    public void displayError(String errorMessage) {
        System.err.println("\n--- ĐÃ CÓ LỖI XẢY RA ---");
        System.err.println(errorMessage);
        System.err.println("========================\n");
    }
}

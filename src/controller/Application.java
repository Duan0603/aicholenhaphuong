package controller;

import model.CourseList;
import model.GeminiClient;
import model.Recommendation;
import view.RecommendationView;

public class Application {
    public static void main(String[] args) {
        // 1. Khởi tạo Model
        CourseList db = new CourseList();
        GeminiClient client = new GeminiClient();
        Recommendation service = new Recommendation(db, client);

        // 2. Khởi tạo View
        RecommendationView view = new RecommendationView();

        // 3. Khởi tạo Controller và inject Model, View vào
        RecommendationController controller = new RecommendationController(service, view);

        // 4. Bắt đầu luồng ứng dụng
        controller.start();
    }
}

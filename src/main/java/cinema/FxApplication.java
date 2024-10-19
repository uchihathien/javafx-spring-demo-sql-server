package cinema;

import cinema.jfx.controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FxApplication extends Application {

    private ConfigurableApplicationContext springContext;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        // Khởi động Spring context
        springContext = new SpringApplicationBuilder(FxApplication.class).run();
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            // Tải file FXML sử dụng Spring context
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/cinema/view/login.fxml"));
            loader.setControllerFactory(springContext::getBean); // Liên kết controller với Spring context

            Parent root = loader.load();

            // Thiết lập scene và stage
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Login");
            primaryStage.show();

            // Lấy LoginController từ Spring context và truyền Stage vào
            LoginController loginController = loader.getController();
            loginController.setStage(primaryStage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        // Đóng Spring context khi ứng dụng dừng
        springContext.close();
    }
}

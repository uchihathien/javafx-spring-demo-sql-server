package cinema.jfx.controller;

import cinema.backend.service.impl.UserServiceImpl;
import cinema.backend.util.CurrentUser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ConfigurableApplicationContext springContext;

    @FXML
    private Button login_Close1;

    @FXML
    private Button login_buton1;

    @FXML
    private AnchorPane login_form;

    @FXML
    private Button login_minimize1;

    @FXML
    private PasswordField login_password1;

    @FXML
    private TextField login_username1;

    // Phương thức này sẽ được gọi từ FxApplication để thiết lập Stage
    @Setter
    private Stage stage;

    @FXML
    public void initialize() {
        // Đăng ký sự kiện key cho cả username và password field
        login_username1.setOnKeyPressed(this::handleKeyPressed);
        login_password1.setOnKeyPressed(this::handleKeyPressed);

        // Sự kiện cho các nút khác
        login_buton1.setOnAction(event -> handleLogin());
        login_Close1.setOnAction(event -> handleClose());
        login_minimize1.setOnAction(event -> handleMinimize());
    }

    // Xử lý sự kiện nhấn phím Tab và Enter
    @FXML
    private void handleKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            if (login_username1.isFocused()) {
                System.out.println("Tab pressed: chuyển đến ô password");
                login_password1.requestFocus(); // Chuyển focus đến ô password khi nhấn Tab
                event.consume(); // Ngăn chặn hành vi Tab mặc định
            }
        } else if (event.getCode() == KeyCode.ENTER) {
            if (login_password1.isFocused()) {
                System.out.println("Enter pressed: Đăng nhập");
                handleLogin(); // Thực hiện đăng nhập khi nhấn Enter trong ô password
            }
        }
    }

    @FXML
    private void handleLogin() {
        String username = login_username1.getText();
        String password = login_password1.getText();

        // Sử dụng UserService để xác minh thông tin đăng nhập
        if (userService.verifyLogin(username, password)) {
            System.out.println("Đăng nhập thành công!");
            CurrentUser.getInstance().setUsername(username);
            String fullname = userService.getCurrentUserFullname();
            CurrentUser.getInstance().setFullName(fullname);
            // Chuyển đến màn hình Dashboard
            try {
                // Tải file FXML của dashboard
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/cinema/view/dashboard.fxml"));
                loader.setControllerFactory(springContext::getBean); // Đảm bảo Spring quản lý controller của dashboard

                Parent dashboardRoot = loader.load();

                // Lấy controller của dashboard
                DashboardController dashboardController = loader.getController();

                // Hiển thị dashboard trong một Stage mới
                Stage dashboardStage = new Stage();
                dashboardStage.setScene(new Scene(dashboardRoot));
                dashboardStage.setTitle("Dashboard");
                dashboardStage.show();

                // Đóng cửa sổ đăng nhập
                stage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Tên đăng nhập hoặc mật khẩu không chính xác.");
            // Hiển thị thông báo lỗi cho người dùng
        }
    }

    private void handleClose() {
        if (stage != null) {
            stage.close();
        }
    }

    private void handleMinimize() {
        if (stage != null) {
            stage.setIconified(true);
        }
    }
}

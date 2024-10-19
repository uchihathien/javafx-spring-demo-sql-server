package cinema.jfx.controller;

import cinema.backend.service.UserService;
import cinema.backend.util.CurrentUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author github: uchihathien
 * Created on 9/25/2024
 */

@Controller
public class DashboardController implements Initializable {

    @FXML
    private Button btnAddMovies;

    @FXML
    private Button btnBooking;

    @FXML
    private Button btnDashboard;

    @FXML
    private Label adminlable;

    @Autowired
    private UserService userService;

    @FXML
    private AnchorPane dashboard;

    @Autowired
    private ConfigurableApplicationContext springContext;

    @Autowired
    private AddMoviesController addMoviesController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void handleAddMovies(ActionEvent event) {
            addMoviesController.handleBooking(event);
    }

    @FXML
    void handleBooking(ActionEvent event) {
        System.out.println(1);
    }

    @FXML
    void handleDashboard(ActionEvent event) {
        dashboard.setVisible(true);
    }

    @FXML
    void handleEditScreening(ActionEvent event) {
        System.out.println(1);
    }

    @FXML
    void handleEmployee(ActionEvent event) {
        System.out.println(1);
    }

    @FXML
    void handleReport(ActionEvent event) {
        System.out.println(1);
    }

    /**
     * Điều hướng tới một trang FXML mới
     * @param fxmlFile tên file FXML muốn chuyển tới
     */
    private void navigateTo(String fxmlFile) {
        try {
            Stage stage = (Stage) adminlable.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/cinema/view/" + fxmlFile));
            loader.setControllerFactory(springContext::getBean);
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

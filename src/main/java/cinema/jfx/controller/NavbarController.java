package cinema.jfx.controller;

import cinema.FxApplication;

import cinema.backend.util.CurrentUser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author github: uchihathien
 * Created on 9/26/2024
 */
@Controller
public class NavbarController implements Initializable {

    @FXML
    private VBox navbar;

    @FXML
    private Label adminlabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String fullname = CurrentUser.getInstance().getFullName();
        if (fullname != null && !fullname.isEmpty()) {
            adminlabel.setText(fullname);
        } else {
            adminlabel.setText("No name");
        }
    }



    @FXML
    private void handleDashboard() {
        System.out.println(1);
    }

    @FXML
    private void handleAddMovies() {
        System.out.println(2);
    }

    @FXML
    private void handleBooking() {
        System.out.println(3);
    }

    @FXML
    private void handleEditScreening() {
        System.out.println(4);
    }

    @FXML
    private void handleEmployee() {
        System.out.println(5);
    }

    @FXML
    private void handleReport() {
        System.out.println(6);
    }

    @FXML
    private void handleSignOut() {
        System.out.println(7);
    }
    private ConfigurableApplicationContext springContext;

    private void navigateTo(String fxmlFile) {
        try {
            Stage stage = (Stage) navbar.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/cinema/view/" + fxmlFile));
            loader.setControllerFactory(springContext::getBean);
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

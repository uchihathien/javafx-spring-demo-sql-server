package cinema.jfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class DashboardController implements Initializable {

    @FXML
    private AnchorPane bookingPane;

    @FXML
    private AnchorPane dashboardPane;

    @FXML
    private AnchorPane editScreeningPane;

    @FXML
    private AnchorPane employeePane;

    @FXML
    private AnchorPane moviePane;

    @FXML
    private AnchorPane reportPane;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        dashboardPane.setVisible(true);

    }

    @FXML
    private void showDashboard() {
        hideAllPane();

        dashboardPane.setVisible(true);
    }

    @FXML
    private void showMovie() {
        hideAllPane();

        moviePane.setVisible(true);

    }



    @FXML
    private void showBooking() {
        hideAllPane();
        bookingPane.setVisible(true);
    }

    @FXML
    private void showEditScreening() {
        hideAllPane();
        editScreeningPane.setVisible(true);
    }

    @FXML
    private void showEmployee() {
        hideAllPane();
        employeePane.setVisible(true);
    }

    @FXML
    private void showReport() {
        hideAllPane();
        reportPane.setVisible(true);
    }



    private void hideAllPane() {
        dashboardPane.setVisible(false);
        editScreeningPane.setVisible(false);
        bookingPane.setVisible(false);
        reportPane.setVisible(false);
        moviePane.setVisible(false);
        employeePane.setVisible(false);
    }







}

package cinema.jfx.controller;

import cinema.backend.entity.Movie;
import cinema.backend.service.MovieService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Controller
public class AddMoviesController {

    @Autowired
    private MovieService movieService;

    @FXML
    private TextField inputDate;
    @FXML
    private TextField inputDirector;
    @FXML
    private TextField inputDuration;
    @FXML
    private TextField inputGenre;
    @FXML
    private TextField inputMovieTitle;
    @FXML
    private Label notificationLabel;
    @FXML
    private ImageView imageView;
    private byte[] imageBytes;
    @FXML
    private TableView<Movie> tableView;
    @FXML
    private TableColumn<Movie, String> movieTitleTable;
    @FXML
    private TableColumn<Movie, String> genreTable;
    @FXML
    private TableColumn<Movie, Integer> durationTable;
    @FXML
    private TableColumn<Movie, String> directionTable;

    @FXML
    public void initialize() {
        movieTitleTable.setCellValueFactory(new PropertyValueFactory<>("title"));
        genreTable.setCellValueFactory(new PropertyValueFactory<>("genre"));
        durationTable.setCellValueFactory(new PropertyValueFactory<>("duration"));
        directionTable.setCellValueFactory(new PropertyValueFactory<>("director"));

        loadDataToTable();
    }

    private void loadDataToTable() {
        List<Movie> movies = movieService.getAllMovies();
        ObservableList<Movie> movieList = FXCollections.observableArrayList(movies);
        tableView.setItems(movieList);
    }

    @FXML
    public void handleImport(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            try {
                imageBytes = Files.readAllBytes(selectedFile.toPath());
                Image image = new Image(selectedFile.toURI().toString());
                imageView.setImage(image);
                notificationLabel.setText("Image loaded successfully.");
            } catch (IOException e) {
                notificationLabel.setText("Failed to load image.");
            }
        } else {
            notificationLabel.setText("File selection cancelled.");
        }
    }

    @FXML
    public void handleInsert(ActionEvent event) {
        String movieTitle = inputMovieTitle.getText();
        String genre = inputGenre.getText();
        String durationText = inputDuration.getText();
        String releaseDateText = inputDate.getText();
        String director = inputDirector.getText();

        if (movieTitle.isEmpty() || genre.isEmpty() || durationText.isEmpty() || releaseDateText.isEmpty() || imageBytes == null) {
            notificationLabel.setText("Please fill out all required fields and select an image.");
            return;
        }

        try {
            int duration = Integer.parseInt(durationText);
            LocalDate releaseDate = LocalDate.parse(releaseDateText, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Movie newMovie = new Movie(movieTitle, genre, duration, releaseDate, director, imageBytes);
            movieService.saveMovie(newMovie); // Lưu qua movieService
            notificationLabel.setText("Movie added successfully!");
            clearForm();
            loadDataToTable();
        } catch (NumberFormatException e) {
            notificationLabel.setText("Duration must be a valid integer.");
        } catch (DateTimeParseException e) {
            notificationLabel.setText("Invalid date format. Use yyyy-MM-dd.");
        } catch (Exception e) {
            notificationLabel.setText("Error while saving movie.");
        }
    }

    @FXML
    public void handleClear(ActionEvent event) {
        clearForm();
    }

    @FXML
    public void handleUpdate(ActionEvent event) {

    }
    @FXML
    public void handleDelete(ActionEvent event) {

    }

    private void clearForm() {
        inputMovieTitle.clear();
        inputGenre.clear();
        inputDuration.clear();
        inputDate.clear();
        inputDirector.clear();
        notificationLabel.setText("");
        imageView.setImage(null);
        imageBytes = null;
    }
}

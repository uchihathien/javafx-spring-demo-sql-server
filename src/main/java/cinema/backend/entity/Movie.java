package cinema.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MovieID", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "Title", nullable = false)
    private String title;

    @Nationalized
    @Column(name = "Genre", nullable = false, length = 50)
    private String genre;

    @Column(name = "Duration", nullable = false)
    private Integer duration;

    @Nationalized
    @Column(name = "Director", length = 100)
    private String director;

    @Column(name = "ReleaseDate")
    private LocalDate releaseDate;

    @Lob
    @Column(name = "Image", nullable = false)
    private byte[] image;

    public Movie(String title, String genre, Integer duration, LocalDate releaseDate, String director, byte[] image) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.director = director;
        this.image = image;
    }

    // Constructor không tham số (bắt buộc cho JPA)
    public Movie() {
    }
}
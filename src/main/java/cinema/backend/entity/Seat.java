package cinema.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "Seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SeatID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RoomID", nullable = false)
    private Room roomID;

    @Nationalized
    @Column(name = "SeatNumber", nullable = false, length = 10)
    private String seatNumber;

    @Column(name = "IsAvailable", nullable = false)
    private Boolean isAvailable = false;

}
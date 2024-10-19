package cinema.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "Rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoomID", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "RoomName", nullable = false, length = 100)
    private String roomName;

    @Column(name = "Capacity", nullable = false)
    private Integer capacity;

    @Nationalized
    @Column(name = "Type", length = 50)
    private String type;

}
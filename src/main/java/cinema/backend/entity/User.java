package cinema.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "FullName", nullable = false, length = 100)
    private String fullName;

    @Nationalized
    @Column(name = "UserName", nullable = false, length = 50)
    private String userName;

    @Nationalized
    @Column(name = "PasswordHash", nullable = false)
    private String passwordHash;

    @Nationalized
    @Column(name = "PhoneNumber", nullable = false, length = 15)
    private String phoneNumber;

    @Nationalized
    @Column(name = "Email", length = 100)
    private String email;

    @Column(name = "HireDate")
    private LocalDate hireDate;

    @Column(name = "Available", nullable = false)
    private Boolean available = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RoleID", nullable = false)
    private Role roleID;

    @Lob
    @Column(name = "Image", nullable = false)
    private byte[] image;

}
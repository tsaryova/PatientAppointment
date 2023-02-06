package patientAppointment.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "patient")
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID uuid;

    @Column(name = "fullname")
    @Size(max = 200)
    @NotNull
    private String fullName;

    @Column(name = "birthday")
    private LocalDate birthday;


    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) { createdAt = Instant.now(); }
        if (uuid == null) {uuid = UUID.randomUUID(); }
    }


}

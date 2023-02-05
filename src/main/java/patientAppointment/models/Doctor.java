package patientAppointment.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@Table(name = "doctor")
public class Doctor {

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

    @Size(max = 100)
    @NotNull
    private String specialization;

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

}

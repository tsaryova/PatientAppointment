package patient.appointment.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

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

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) { createdAt = Instant.now(); }
        if (uuid == null) {uuid = UUID.randomUUID(); }
    }

}

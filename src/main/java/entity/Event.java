package entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Table(name = "event")
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event", nullable = false)
    private Long id;

    @CreationTimestamp
    @Column(name = "date_event")
    private Timestamp dateEvent;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_file_ref", referencedColumnName = "id_file")
    private FileInfo fileInfo;

    public Event(FileInfo fileInfo) {
        this.fileInfo = fileInfo;
    }
}
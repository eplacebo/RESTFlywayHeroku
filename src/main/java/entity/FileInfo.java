package entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "file")
@Entity
public class FileInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_file", nullable = false)
    private Long id;

    @NonNull
    @Basic
    @Column(name = "name_file")
    private String nameFile;

    @NonNull
    @Basic
    @Column(name = "path_file")
    private String pathFile;

}
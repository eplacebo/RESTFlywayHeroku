package entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "\"user\"")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Long id;

    @NonNull
    @Basic
    @Column(name = "username")
    private String username;

    @NonNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user_ref")
    List<Event> eventList = new ArrayList<>();

    public User(@NonNull String username, @NonNull List<Event> eventList) {
        this.username = username;
        this.eventList = eventList;
    }

    @Override
    public String toString() {
        return ("ID:" + id + '\n' + "USERNAME: " + username + '\n' + "EVENTS:" + '\n' +
                eventList + '\n').replace("]", "").replace("[", "").replace(",", "");
    }
}
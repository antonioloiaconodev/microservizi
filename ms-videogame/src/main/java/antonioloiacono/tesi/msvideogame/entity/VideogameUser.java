package antonioloiacono.tesi.msvideogame.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "videogame_user")
public class VideogameUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "videogame_id", insertable = false, updatable = false)
    private Videogame videogame;

    @Column(name = "videogame_id", nullable = false)
    private Long videogameId;

    @Column(name = "user_id")
    private Long userId;
}
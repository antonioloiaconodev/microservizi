package antonioloiacono.tesi.msvideogame.repository;

import antonioloiacono.tesi.msvideogame.entity.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VideogameRepository extends JpaRepository<Videogame, Long> {
    Optional<Videogame> findByName(String name);
}

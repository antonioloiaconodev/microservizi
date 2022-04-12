package antonioloiacono.tesi.msvideogame.repository;

import antonioloiacono.tesi.msvideogame.entity.VideogameUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VideogameUserRepository extends JpaRepository<VideogameUser, Long> {
    Optional<VideogameUser> findByVideogameIdAndUserId(Long videogameId, Long userId);
}

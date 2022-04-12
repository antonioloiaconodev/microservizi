package antonioloiacono.tesi.mscomment.repository;

import antonioloiacono.tesi.mscomment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    void deleteAllByVideogameId(Long videogameId);
}
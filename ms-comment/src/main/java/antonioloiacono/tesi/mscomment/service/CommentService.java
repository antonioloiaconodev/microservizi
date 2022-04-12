package antonioloiacono.tesi.mscomment.service;

import antonioloiacono.tesi.mscomment.dto.CommentCreateDto;
import antonioloiacono.tesi.mscomment.dto.CommentDto;
import antonioloiacono.tesi.mscomment.dto.CommentUpdateDto;

import java.util.Set;

public interface CommentService {

    Set<CommentDto> findAllComments();

    CommentDto findCommentById(Long id);

    CommentDto createComment(CommentCreateDto commentCreateDto);

    CommentDto updateComment(Long id, CommentUpdateDto commentUpdateDto);

    void deleteComment(Long id);

    void deleteAllCommentsByVideogameId(Long videogameId);
}

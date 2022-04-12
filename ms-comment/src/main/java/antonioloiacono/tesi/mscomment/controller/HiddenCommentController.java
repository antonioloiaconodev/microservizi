package antonioloiacono.tesi.mscomment.controller;

import antonioloiacono.tesi.mscomment.dto.CommentCreateDto;
import antonioloiacono.tesi.mscomment.dto.CommentDto;
import antonioloiacono.tesi.mscomment.service.CommentService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/hidden/comments")
public class HiddenCommentController {

    private final CommentService commentService;

    public HiddenCommentController(CommentService commentService) {
        super();
        this.commentService = commentService;
    }

    @Hidden
    @PostMapping
    public ResponseEntity<CommentDto> createComment(@Valid @RequestBody CommentCreateDto commentCreateDto) {
        return new ResponseEntity<>(commentService.createComment(commentCreateDto), HttpStatus.CREATED);
    }

    @Hidden
    @DeleteMapping("/videogames/{videogameId}")
    public ResponseEntity<HttpStatus> deleteAllCommentsByVideogameId(@PathVariable Long videogameId) {
        commentService.deleteAllCommentsByVideogameId(videogameId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

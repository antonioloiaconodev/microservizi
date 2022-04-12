package antonioloiacono.tesi.msaggregator.controller;

import antonioloiacono.tesi.msaggregator.client.CommentClient;
import antonioloiacono.tesi.msaggregator.client.UserClient;
import antonioloiacono.tesi.msaggregator.client.VideogameClient;
import antonioloiacono.tesi.msaggregator.model.Comment;
import antonioloiacono.tesi.msaggregator.model.User;
import antonioloiacono.tesi.msaggregator.model.Videogame;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/comments")
public class AggregatorCommentController {

    private final UserClient userClient;
    private final VideogameClient videogameClient;
    private final CommentClient commentClient;

    public AggregatorCommentController(
            UserClient userClient,
            VideogameClient videogameClient,
            CommentClient commentClient
    ) {
        super();
        this.userClient = userClient;
        this.videogameClient = videogameClient;
        this.commentClient = commentClient;
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        User user = userClient.getById(comment.getUserId());
        Videogame videogame = videogameClient.getById(comment.getVideogameId());
        return new ResponseEntity<>(commentClient.createComment(comment), HttpStatus.OK);
    }
}


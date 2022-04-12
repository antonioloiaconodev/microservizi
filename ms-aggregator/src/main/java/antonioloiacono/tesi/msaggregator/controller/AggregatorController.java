package antonioloiacono.tesi.msaggregator.controller;

import antonioloiacono.tesi.msaggregator.client.CommentClient;
import antonioloiacono.tesi.msaggregator.model.Comment;
import antonioloiacono.tesi.msaggregator.model.User;
import antonioloiacono.tesi.msaggregator.model.Videogame;
import antonioloiacono.tesi.msaggregator.client.UserClient;
import antonioloiacono.tesi.msaggregator.client.VideogameClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/aggregator")
public class AggregatorController {

    private final UserClient userClient;
    private final VideogameClient videogameClient;
    private final CommentClient commentClient;

    public AggregatorController(
            UserClient userClient,
            VideogameClient videogameClient,
            CommentClient commentClient
    ) {
        super();
        this.userClient = userClient;
        this.videogameClient = videogameClient;
        this.commentClient = commentClient;
    }

    @PutMapping("/videogames/{videogameId}/users/{userId}")
    public ResponseEntity<Videogame> assignUserToVideogame(@PathVariable Long videogameId, @PathVariable Long userId) {
        User user = userClient.getById(userId);
        return new ResponseEntity<>(videogameClient.addUserToVideogame(videogameId, user.getId()), HttpStatus.OK);
    }

    @DeleteMapping("/videogames/{videogameId}/users/{userId}")
    public ResponseEntity<Videogame> removeUserToVideogame(@PathVariable Long videogameId, @PathVariable Long userId) {
        User user = userClient.getById(userId);
        return new ResponseEntity<>(videogameClient.removeUserToVideogame(videogameId, user.getId()), HttpStatus.OK);
    }

    @DeleteMapping("/videogames/{id}")
    public ResponseEntity<HttpStatus> deleteVideogame(@PathVariable Long id) {
        videogameClient.deleteVideogame(id);
        commentClient.deleteAllCommentsByVideogameId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/comments")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        User user = userClient.getById(comment.getUserId());
        Videogame videogame = videogameClient.getById(comment.getVideogameId());
        return new ResponseEntity<>(commentClient.createComment(comment), HttpStatus.OK);
    }
}


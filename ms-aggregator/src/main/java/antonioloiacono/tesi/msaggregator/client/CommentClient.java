package antonioloiacono.tesi.msaggregator.client;

import antonioloiacono.tesi.msaggregator.model.Comment;

public interface CommentClient {
    Comment createComment(Comment comment);

    void deleteAllCommentsByVideogameId(Long videogameId);
}

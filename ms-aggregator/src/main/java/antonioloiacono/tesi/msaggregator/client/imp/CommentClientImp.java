package antonioloiacono.tesi.msaggregator.client.imp;

import antonioloiacono.tesi.msaggregator.client.CommentClient;
import antonioloiacono.tesi.msaggregator.model.Comment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CommentClientImp implements CommentClient {

    @Value("${comment.client.url}")
    private String COMMENT_CLIENT_URL;

    private final RestTemplate restTemplate;

    public CommentClientImp(
            RestTemplate restTemplate
    ) {
        super();
        this.restTemplate = restTemplate;
    }

    public Comment createComment(Comment comment) {
        return restTemplate.postForEntity(
                COMMENT_CLIENT_URL + "/hidden/comments/",
                comment,
                Comment.class
        ).getBody();
    }

    public void deleteAllCommentsByVideogameId(Long videogameId) {
        restTemplate.delete(COMMENT_CLIENT_URL + "/hidden/comments/videogames/" + videogameId);
    }
}

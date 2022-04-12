package antonioloiacono.tesi.msaggregator.model;

import lombok.Data;

@Data
public class Comment {
    private Long id;

    private Long userId;

    private Long videogameId;

    private String comment;
}
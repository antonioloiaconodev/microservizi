package antonioloiacono.tesi.mscomment.dto;

import lombok.Data;

@Data
public class CommentDto {
    private Long id;

    private Long userId;

    private Long videogameId;

    private String comment;
}
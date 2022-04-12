package antonioloiacono.tesi.mscomment.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CommentUpdateDto {
    @NotNull(message = "The comment is required.")
    private String comment;
}
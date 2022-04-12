package antonioloiacono.tesi.msvideogame.dto;

import lombok.Data;
import java.util.Date;
import java.util.Set;

@Data
public class VideogameDto {
    private long id;

    private String name;

    private String platform;

    private String genre;

    private String publisher;

    private Date releaseDate;

    private Set<VideogameUserDto> users;
}
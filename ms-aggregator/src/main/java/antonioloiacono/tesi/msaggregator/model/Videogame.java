package antonioloiacono.tesi.msaggregator.model;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class Videogame {
    private Long id;

    private String name;

    private String platform;

    private String genre;

    private String publisher;

    private Date releaseDate;

    private Set<VideogameUser> users;
}
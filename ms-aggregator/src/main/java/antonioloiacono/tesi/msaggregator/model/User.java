package antonioloiacono.tesi.msaggregator.model;

import lombok.Data;

@Data
public class User {
    private long id;

    private String email;

    private String firstName;

    private String lastName;
}
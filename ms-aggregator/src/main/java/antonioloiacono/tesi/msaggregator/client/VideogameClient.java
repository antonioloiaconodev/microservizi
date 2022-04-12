package antonioloiacono.tesi.msaggregator.client;

import antonioloiacono.tesi.msaggregator.model.Videogame;

public interface VideogameClient {

    Videogame getById(Long id);
        
    Videogame addUserToVideogame(Long videogameId, Long userId);

    Videogame removeUserToVideogame(Long videogameId, Long userId);

    void deleteVideogame(Long id);
}

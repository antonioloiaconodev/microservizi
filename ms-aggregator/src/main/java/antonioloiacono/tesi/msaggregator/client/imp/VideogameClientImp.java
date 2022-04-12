package antonioloiacono.tesi.msaggregator.client.imp;

import antonioloiacono.tesi.msaggregator.client.VideogameClient;
import antonioloiacono.tesi.msaggregator.model.Videogame;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class VideogameClientImp implements VideogameClient {

    @Value("${videogame.client.url}")
    private String VIDEOGAME_CLIENT_URL;

    private final RestTemplate restTemplate;

    public VideogameClientImp(
            RestTemplate restTemplate
    ) {
        super();
        this.restTemplate = restTemplate;
    }

    public Videogame getById(Long id) {
        Videogame videogame = restTemplate.getForObject(VIDEOGAME_CLIENT_URL + "/videogames/" +id, Videogame.class);
        return videogame;
    }

    public Videogame addUserToVideogame(Long videogameId, Long userId) {
        return restTemplate.exchange(
                VIDEOGAME_CLIENT_URL + "/hidden/videogames/" + videogameId + "/users/" + userId,
                HttpMethod.PUT,
                null,
                Videogame.class
        ).getBody();
    }

    public Videogame removeUserToVideogame(Long videogameId, Long userId) {
        return restTemplate.exchange(
                VIDEOGAME_CLIENT_URL + "/hidden/videogames/" + videogameId + "/users/" + userId,
                HttpMethod.DELETE,
                null,
                Videogame.class
        ).getBody();
    }

    public void deleteVideogame(Long id){
        restTemplate.delete(VIDEOGAME_CLIENT_URL + "/hidden/videogames/" + id);
    }

}

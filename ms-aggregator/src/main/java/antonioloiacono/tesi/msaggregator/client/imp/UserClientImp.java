package antonioloiacono.tesi.msaggregator.client.imp;

import antonioloiacono.tesi.msaggregator.model.User;
import antonioloiacono.tesi.msaggregator.client.UserClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class UserClientImp implements UserClient {

    @Value("${user.client.url}")
    private String USER_CLIENT_URL;

    private final RestTemplate restTemplate;

    public UserClientImp(
            RestTemplate restTemplate
    ) {
        super();
        this.restTemplate = restTemplate;
    }

    public User getById(Long id) {
        User user = restTemplate.getForObject(USER_CLIENT_URL + "/users/" +id, User.class);
        return user;
    }

}

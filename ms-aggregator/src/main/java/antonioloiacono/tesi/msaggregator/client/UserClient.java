package antonioloiacono.tesi.msaggregator.client;

import antonioloiacono.tesi.msaggregator.model.User;

public interface UserClient {
    User getById(Long id);
}

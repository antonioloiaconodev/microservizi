package antonioloiacono.tesi.msvideogame.service;

import antonioloiacono.tesi.msvideogame.dto.VideogameCreateDto;
import antonioloiacono.tesi.msvideogame.dto.VideogameDto;
import antonioloiacono.tesi.msvideogame.dto.VideogameUpdateDto;
import java.util.Set;

public interface VideogameService {
    Set<VideogameDto> findAllVideogames();

    VideogameDto findVideogameById(Long id);

    VideogameDto createVideogame(VideogameCreateDto videogameCreateDto);

    VideogameDto updateVideogame(Long id, VideogameUpdateDto videogameUpdateDto);

    void deleteVideogame(Long id);

    VideogameDto addUserToVideogame(Long videogameId, Long userId);

    VideogameDto removeUserFromVideogame(Long videogameId, Long userId);
}

package antonioloiacono.tesi.msvideogame.controller;

import antonioloiacono.tesi.msvideogame.dto.VideogameDto;
import antonioloiacono.tesi.msvideogame.service.VideogameService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hidden/videogames")
public class HiddenVideogameController {

    private final VideogameService videogameService;

    public HiddenVideogameController(VideogameService videogameService) {
        super();
        this.videogameService = videogameService;
    }

    @Hidden
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteVideogames(@PathVariable Long id) {
        videogameService.deleteVideogame(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Hidden
    @PutMapping("/{videogameId}/users/{userId}")
    public ResponseEntity<VideogameDto> addUserToVideogame(@PathVariable Long videogameId, @PathVariable Long userId) {
        return new ResponseEntity<>(videogameService.addUserToVideogame(videogameId, userId), HttpStatus.OK);
    }

    @Hidden
    @DeleteMapping("/{videogameId}/users/{userId}")
    public ResponseEntity<VideogameDto> removeUserFromVideogame(@PathVariable Long videogameId, @PathVariable Long userId) {
        return new ResponseEntity<>(videogameService.removeUserFromVideogame(videogameId, userId), HttpStatus.OK);
    }
}

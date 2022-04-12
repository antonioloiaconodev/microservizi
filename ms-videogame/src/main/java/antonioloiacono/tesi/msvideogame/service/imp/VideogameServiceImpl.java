package antonioloiacono.tesi.msvideogame.service.imp;

import antonioloiacono.tesi.msvideogame.dto.VideogameCreateDto;
import antonioloiacono.tesi.msvideogame.dto.VideogameDto;
import antonioloiacono.tesi.msvideogame.dto.VideogameUpdateDto;
import antonioloiacono.tesi.msvideogame.entity.VideogameUser;
import antonioloiacono.tesi.msvideogame.entity.Videogame;
import antonioloiacono.tesi.msvideogame.exception.RecordAlreadyExistsException;
import antonioloiacono.tesi.msvideogame.exception.RecordNotFoundException;
import antonioloiacono.tesi.msvideogame.repository.VideogameUserRepository;
import antonioloiacono.tesi.msvideogame.repository.VideogameRepository;
import antonioloiacono.tesi.msvideogame.service.VideogameService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class VideogameServiceImpl implements VideogameService {

    private final VideogameRepository videogameRepository;
    private final VideogameUserRepository videogameUserRepository;
    private final ModelMapper modelMapper;

    public VideogameServiceImpl(
            VideogameRepository videogameRepository,
            VideogameUserRepository videogameUserRepository,
            ModelMapper modelMapper
    ) {
        super();
        this.videogameRepository = videogameRepository;
        this.videogameUserRepository = videogameUserRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Set<VideogameDto> findAllVideogames() {
        return videogameRepository.findAll().stream().map(videogame -> modelMapper.map(videogame, VideogameDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public VideogameDto findVideogameById(Long id) {
        Videogame videogame = videogameRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No videogame found with the id: " + id));
        return modelMapper.map(videogame, VideogameDto.class);
    }

    @Override
    public VideogameDto createVideogame(VideogameCreateDto videogameCreateDto) {
        String name = videogameCreateDto.getName();
        Optional<Videogame> videogame = videogameRepository.findByName(name);
        if(videogame.isPresent()){
            throw new RecordAlreadyExistsException("Videogame already exist with email: " + name);
        }
        Videogame videogameCreate = videogameRepository.save(modelMapper.map(videogameCreateDto, Videogame.class));
        return modelMapper.map(videogameCreate, VideogameDto.class);
    }

    @Override
    public VideogameDto updateVideogame(Long id, VideogameUpdateDto videogameUpdateDto) {
        Videogame videogame = videogameRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No videogame found with the id: " + id));
        if (videogameUpdateDto.getName() != null){
            videogame.setName(videogameUpdateDto.getName());
        }
        if (videogameUpdateDto.getPlatform() != null){
            videogame.setPlatform(videogameUpdateDto.getPlatform());
        }
        if (videogameUpdateDto.getGenre() != null){
            videogame.setGenre(videogameUpdateDto.getGenre());
        }
        if (videogameUpdateDto.getPublisher() != null){
            videogame.setPublisher(videogameUpdateDto.getPublisher());
        }
        if (videogameUpdateDto.getReleaseDate() != null){
            videogame.setReleaseDate(videogameUpdateDto.getReleaseDate());
        }
        Videogame videogameUpdate = videogameRepository.save(videogame);
        return modelMapper.map(videogameUpdate, VideogameDto.class);
    }

    @Override
    public void deleteVideogame(Long id) {
        Videogame videogame = videogameRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No videogame found with the id: " + id));
        videogameRepository.delete(videogame);
    }

    @Override
    public VideogameDto addUserToVideogame(Long videogameId, Long userId) {
        Videogame videogame = videogameRepository.findById(videogameId)
                .orElseThrow(() -> new RecordNotFoundException("No videogame found with the id: " + videogameId));
        VideogameUser videogameUser = new VideogameUser();
        videogameUser.setVideogameId(videogameId);
        videogameUser.setUserId(userId);
        videogameUserRepository.save(videogameUser);
        return modelMapper.map(videogame, VideogameDto.class);
    }

    @Override
    public VideogameDto removeUserFromVideogame(Long videogameId, Long userId) {
        Videogame videogame = videogameRepository.findById(videogameId)
                .orElseThrow(() -> new RecordNotFoundException("No videogame found with the id: " + videogameId));
        Optional <VideogameUser> videogameUser = videogameUserRepository.findByVideogameIdAndUserId(videogameId, userId);
        if(videogameUser.isPresent())   {
            videogameUserRepository.delete(videogameUser.get());
        }
        return modelMapper.map(videogame, VideogameDto.class);
    }
}
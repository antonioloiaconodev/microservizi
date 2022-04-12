package antonioloiacono.tesi.msuser.service.imp;

import antonioloiacono.tesi.msuser.dto.UserCreateDto;
import antonioloiacono.tesi.msuser.dto.UserDto;
import antonioloiacono.tesi.msuser.dto.UserUpdateDto;
import antonioloiacono.tesi.msuser.entity.User;
import antonioloiacono.tesi.msuser.exception.RecordAlreadyExistsException;
import antonioloiacono.tesi.msuser.exception.RecordNotFoundException;
import antonioloiacono.tesi.msuser.repository.UserRepository;
import antonioloiacono.tesi.msuser.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(
            UserRepository userRepository,
            ModelMapper modelMapper
    ) {
        super();
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Set<UserDto> findAllUsers() {
        return userRepository.findAll().stream().map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public UserDto findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No user found with the id: " + id));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto createUser(UserCreateDto userCreateDto) {
        String email = userCreateDto.getEmail();
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            throw new RecordAlreadyExistsException("User already exist with email: " + email);
        }
        User userCreate = userRepository.save(modelMapper.map(userCreateDto, User.class));
        return modelMapper.map(userCreate, UserDto.class);
    }

    @Override
    public UserDto updateUser(Long id, UserUpdateDto userUpdateDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No user found with the id: " + id));
        if (userUpdateDto.getEmail() != null){
            user.setEmail(userUpdateDto.getEmail());
        }
        if (userUpdateDto.getFirstName() != null){
            user.setFirstName(userUpdateDto.getFirstName());
        }
        if (userUpdateDto.getLastName() != null){
            user.setLastName(userUpdateDto.getLastName());
        }
        User userUpdate = userRepository.save(user);
        return modelMapper.map(userUpdate, UserDto.class);
    }
}

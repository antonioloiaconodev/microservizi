package antonioloiacono.tesi.msuser.service;

import antonioloiacono.tesi.msuser.dto.UserCreateDto;
import antonioloiacono.tesi.msuser.dto.UserDto;
import antonioloiacono.tesi.msuser.dto.UserUpdateDto;
import java.util.Set;

public interface UserService {
    Set<UserDto> findAllUsers();

    UserDto findUserById(Long id);

    UserDto createUser(UserCreateDto userCreateDto);

    UserDto updateUser(Long id, UserUpdateDto userUpdateDto);
}

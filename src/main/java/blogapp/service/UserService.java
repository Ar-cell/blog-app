package blogapp.service;

import blogapp.config.Response;
import blogapp.dto.UserDto;

import java.util.List;

public interface UserService {
    Response createUser(UserDto userDto);
    Response getUserById(Integer userId);
    Response updateUser(UserDto userDto);
    List<UserDto> getAllUsers();

    Response deleteUser(Integer userId);
}

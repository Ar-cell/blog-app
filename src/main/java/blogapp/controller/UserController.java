package blogapp.controller;

import blogapp.config.Response;
import blogapp.dto.UserDto;
import blogapp.entity.User;
import blogapp.service.UserService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequiredArgsConstructor
@RequestMapping("/api/user")
@CrossOrigin("*")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public Response createUser(@RequestBody @Valid UserDto userDto){
        log.info("request initiated to create user");
        return userService.createUser(userDto);
    }

    @GetMapping("/user/{userId}")
    public Response getUserById(@PathVariable Integer userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/update")
    public Response updateUser(@RequestBody @Valid UserDto userDto){
        return userService.updateUser(userDto);
    }

    @DeleteMapping("/delete/{userId}")
    public Response deleteUser(@PathVariable Integer userId){
        return userService.deleteUser(userId);
    }
}

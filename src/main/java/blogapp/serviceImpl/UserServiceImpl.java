package blogapp.serviceImpl;

import blogapp.config.RestConstants;
import blogapp.config.Response;
import blogapp.dto.UserDto;
import blogapp.entity.User;
import blogapp.repository.UserRepository;
import blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, RestConstants {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Response createUser(UserDto userDto) {
        Optional<User> userOptional = userRepository.findByEmail(userDto.getEmail());
        if(userOptional.isPresent()){
            return new Response(ALREADY_EXIST,HttpStatus.BAD_REQUEST);
        }
        User user = User.builder().name(userDto.getName()).email(userDto.getEmail())
                .about(userDto.getAbout()).password(userDto.getPassword()).build();
        userRepository.save(user);
        return Response.builder().message(SUCCESS).responseObject(user)
                .code(HttpStatus.OK.value()).status(HttpStatus.OK).build();
    }

    @Override
    public Response getUserById(Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            UserDto userDto = UserDto.builder().id(user.getId()).name(user.getName())
                    .email(user.getName()).password(user.getPassword()).about(user.getAbout()).build();
            return new Response(SUCCESS,userDto,HttpStatus.OK);
        }
        return new Response(NOT_FOUND,HttpStatus.BAD_REQUEST);
    }

    @Override
    public Response updateUser(UserDto userDto) {
        Optional<User> userOptional = userRepository.findById(userDto.getId());
        if (userOptional.isPresent()){
            User user = userOptional.get();
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setAbout(userDto.getAbout());
            user.setPassword(userDto.getPassword());
            userRepository.save(user);
            return new Response(SUCCESS,user,HttpStatus.OK);
        }
        return new Response(NOT_FOUND,HttpStatus.BAD_REQUEST);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtos =  new ArrayList<>();
        List<User> users = userRepository.findAll();
        for(User user: users){
            UserDto userDto = UserDto.builder().id(user.getId()).name(user.getName()).email(user.getEmail()).password(user.getPassword()).about(user.getAbout()).build();
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public Response deleteUser(Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            userRepository.deleteById(userId);
            return new Response(SUCCESS,"Deleted Successfully", HttpStatus.OK);
        }
        return new Response(NOT_FOUND,HttpStatus.BAD_REQUEST);
    }
}

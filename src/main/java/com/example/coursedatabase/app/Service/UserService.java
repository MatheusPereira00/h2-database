package com.example.coursedatabase.app.Service;

import com.example.coursedatabase.app.dto.UserDto;
import com.example.coursedatabase.app.mapper.MapperTime;
import com.example.coursedatabase.domain.model.User;
import com.example.coursedatabase.infra.Repository.TimeRepository;
import com.example.coursedatabase.infra.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TimeRepository timeRepository;


    private ModelMapper mapper = new ModelMapper();


    public UserDto findIndex(){
        User users = this.userRepository.findAll().get(Math.toIntExact(1L));
        return mapper.map(users, UserDto.class);
    }


    public List<UserDto> findAll() {
        List<User> users = this.userRepository.findAll();
        return users
                .stream()
                .map(user -> mapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    public List<User> findAllResponse(){
       return Optional.of(userRepository.findAll())
               .filter(list -> !list.isEmpty())
               .orElseThrow(() -> new RuntimeException("No users found"));
    }


    public UserDto findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        return mapper
                .map(obj, UserDto.class);
    }


    public User create(User user){
        User newUser = userRepository.save(user);
        return newUser;
    }
}

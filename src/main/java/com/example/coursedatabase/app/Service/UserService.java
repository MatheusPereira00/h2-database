package com.example.coursedatabase.app.Service;

import com.example.coursedatabase.app.dto.UserDto;
import com.example.coursedatabase.app.mapper.UserMapper;
import com.example.coursedatabase.domain.model.User;
import com.example.coursedatabase.infra.Repository.UserRepository;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;

//    public UserDto findAll(){
//        User users = this.userRepository.findAll().get(Math.toIntExact(1L));
//        return mapper.getModel().map(users, UserDto.class);
//    }

//    public List<UserDto> findAll() {
//        List<User> users = this.userRepository.findAll();
//        return Collections.singletonList(mapper.getModel().map(users, UserDto.class));
//    }

    public List<UserDto> findAll() {
        List<User> users = this.userRepository.findAll();
        return mapper.getModel().map(users, new TypeToken<List<UserDto>>(){}.getType());
    }

/*
    public ResponseEntity<List<User>> findAllResponse(){
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok().body(users);
    }
*/

    public List<User> findAllResponse(){
       return Optional.of(userRepository.findAll())
               .filter(list -> !list.isEmpty())
               .orElseThrow(() -> new RuntimeException("No users found"));
    }



    public UserDto findById(Long id){
        Optional<User> obj = userRepository.findById(id);
//        return obj.get();
        return mapper.getModel().map(obj, UserDto.class);
    }
}

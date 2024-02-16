package com.example.coursedatabase.app.Service;

import com.example.coursedatabase.app.dto.UserDto;
import com.example.coursedatabase.app.mapper.UserMapper;
import com.example.coursedatabase.domain.model.User;
import com.example.coursedatabase.infra.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;

    public UserDto findAll(){
        User users = this.userRepository.findAll().get(Math.toIntExact(1L));
        return mapper.getModel().map(users, UserDto.class);
    }

    public UserDto findById(Long id){
        Optional<User> obj = userRepository.findById(id);
//        return obj.get();
        return mapper.getModel().map(obj, UserDto.class);
    }
}

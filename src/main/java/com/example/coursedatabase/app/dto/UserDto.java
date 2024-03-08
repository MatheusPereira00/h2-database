package com.example.coursedatabase.app.dto;


import com.example.coursedatabase.domain.model.Time;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class UserDto {
    String name;
    String email;
    String phone;

    TimeDto time;
}
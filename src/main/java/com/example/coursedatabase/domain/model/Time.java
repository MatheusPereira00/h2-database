package com.example.coursedatabase.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "tb_time")
public class Time implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
}

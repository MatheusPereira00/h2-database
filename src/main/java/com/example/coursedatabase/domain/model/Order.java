package com.example.coursedatabase.domain.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.Instant;

@Data
@Entity(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;

    // ASSOCIAÇÃO MUITOS PARA UM
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User Client;

    public Order() {
    }

    public Order(Long id, Instant moment, User client) {
        super();
        this.id = id;
        this.moment = moment;
        this.Client = client;
    }
}

package com.example.coursedatabase.infra.Repository;

import com.example.coursedatabase.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

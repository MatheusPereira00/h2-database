package com.example.coursedatabase.infra.Repository;

import com.example.coursedatabase.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

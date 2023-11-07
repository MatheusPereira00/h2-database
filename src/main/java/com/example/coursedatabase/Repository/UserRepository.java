package com.example.coursedatabase.Repository;

import com.example.coursedatabase.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

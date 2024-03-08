package com.example.coursedatabase.infra.Repository;

import com.example.coursedatabase.domain.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
}

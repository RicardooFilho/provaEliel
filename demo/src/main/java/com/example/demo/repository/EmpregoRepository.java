package com.example.demo.repository;

import com.example.demo.domain.Emprego;
import com.example.demo.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpregoRepository extends JpaRepository<Emprego, Long> {
}

package com.projetoa3.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projetoa3.microservices.model.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{
    
}

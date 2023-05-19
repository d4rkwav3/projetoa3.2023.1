package com.projetoa3.microservices.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data // gera os getters, setters e demais métodos automaticamente
@Entity // indica que essa classe é uma representação de uma tabela
@Table(name = "users") // especifica o nome da tabela do db caso o nome seja diferente do da classe
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 128, nullable = false)
    private String email;

    @Column(length = 64, nullable = false)
    private String password;

}

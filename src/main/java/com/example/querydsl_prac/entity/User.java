package com.example.querydsl_prac.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    @Id @GeneratedValue
    private Long id;

    private String name;

    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}

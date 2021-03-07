package com.example.querydsl_prac.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Item {

    @Id @GeneratedValue
    private Long id;

    private String itemName;
    private Integer price;

    public Item(String itemName, Integer price) {
        this.itemName = itemName;
        this.price = price;
    }
}

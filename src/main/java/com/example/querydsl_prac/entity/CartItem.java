package com.example.querydsl_prac.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CartItem {

    @Id @GeneratedValue
    private Long id;

    private Integer amount;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public CartItem(Integer amount, Item item, User user) {
        this.amount = amount;
        this.item = item;
        this.user = user;
    }
}

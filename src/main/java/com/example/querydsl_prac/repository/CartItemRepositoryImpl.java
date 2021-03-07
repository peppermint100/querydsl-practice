package com.example.querydsl_prac.repository;

import com.example.querydsl_prac.entity.CartItem;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.example.querydsl_prac.entity.QCartItem.cartItem;

public class CartItemRepositoryImpl implements CartItemRepositoryCustom{
    @Autowired
    private JPAQueryFactory query;

    @Override
    public List<CartItem> q_findByAgeOver(Integer ageOver) {
        //SELECT * FROM cartitem WHERE cartitem.user_id IN (SELECT user.id FROM user WHERE user.age > 10)
        return query.selectFrom(cartItem).where(cartItem.user.age.gt(ageOver)).fetch();
    }
}

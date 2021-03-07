package com.example.querydsl_prac.repository;

import com.example.querydsl_prac.entity.CartItem;

import java.util.List;

public interface CartItemRepositoryCustom {
    List<CartItem> q_findByAgeOver(Integer ageOver);
}

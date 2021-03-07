package com.example.querydsl_prac.repository;

import com.example.querydsl_prac.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>, CartItemRepositoryCustom {

    List<CartItem> findByUserName(String userName);

    @Query(value = "SELECT * FROM cartitem WHERE cartitem.user_id IN (SELECT user.id FROM user WHERE user.age > 10)", nativeQuery = true)
    List<CartItem> findByAgeOver(@Param("ageOver") Integer ageOver);

    @Override
    List<CartItem> q_findByAgeOver(@Param("ageOver") Integer ageOver);
}

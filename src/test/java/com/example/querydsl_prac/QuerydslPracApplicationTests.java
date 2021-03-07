package com.example.querydsl_prac;

import com.example.querydsl_prac.entity.CartItem;
import com.example.querydsl_prac.entity.Item;
import com.example.querydsl_prac.entity.User;
import com.example.querydsl_prac.repository.CartItemRepository;
import com.example.querydsl_prac.repository.ItemRepository;
import com.example.querydsl_prac.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class QuerydslPracApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @BeforeAll
    public void setUp() {
        User user1 = new User("pepper", 27);
        User user2 = new User("hansol", 25);
        User user3 = new User("tan", 1);


        Item item1 = new Item("shoes", 100);
        Item item2 = new Item("jacket", 150);
        Item item3 = new Item("pants", 80);

        CartItem cartItem1 = new CartItem(3, item1, user1);
        CartItem cartItem2 = new CartItem(1, item2, user1);
        CartItem cartItem3 = new CartItem(5, item3, user1);

        userRepository.saveAll(List.of(user1, user2, user3));
        itemRepository.saveAll(List.of(item1, item2, item3));
        cartItemRepository.saveAll(List.of(cartItem1, cartItem2, cartItem3));
    }

    @Test
    @DisplayName("check there are 3 users")
    public void check_there_are_3_users() {
        List<User> users = userRepository.findAll();

        Assertions.assertEquals(3, users.size());
    }

    @Test
    @DisplayName("check there are 3 items")
    public void check_there_are_3_items() {
        List<Item> items = itemRepository.findAll();

        Assertions.assertEquals(3, items.size());
    }

    @Test
    @DisplayName("get cartitems by username")
    public void get_cartitems_by_username() {
        String username = "pepper";

        List<CartItem> cartItems = cartItemRepository.findByUserName(username);

        Assertions.assertEquals(3, cartItems.size());
    }

    @Test
    @DisplayName("cartitems that user's age is over 10 is 3")
    public void cart_items_that_user_s_age_is_over_10_is_3() {
        Integer ageOver = 10;

        List<CartItem> cartItems = cartItemRepository.findByAgeOver(ageOver);

        Assertions.assertEquals(3, cartItems.size());
    }

    @Test
    @DisplayName("querydsl cartitems that user's age is over 10 is 3")
    public void querydsl_cart_items_that_user_s_age_is_over_10_is_3() {
        Integer ageOver = 10;

        List<CartItem> cartItems = cartItemRepository.q_findByAgeOver(ageOver);

        Assertions.assertEquals(3, cartItems.size());
    }
}

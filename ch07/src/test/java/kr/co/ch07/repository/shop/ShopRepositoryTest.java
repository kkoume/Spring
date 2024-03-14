package kr.co.ch07.repository.shop;

import jakarta.transaction.Transactional;
import kr.co.ch07.entity.shop.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ShopRepositoryTest {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private OrderRepository orderRepository;
    @Autowired private OrderItemRepository orderItemRepository;
    @Autowired private ProductRepository productRepository;


    @Test
    @Transactional
    public void selectOrder(){
        Order order = orderRepository.findById(3).get();
        log.info(order.toString());
    }

    @Test
    @Transactional
    public void selectOrders(){
        List<Order> orders = orderRepository.findAll();
        for(Order order : orders){
            log.info(order.toString());
        }
    }

}
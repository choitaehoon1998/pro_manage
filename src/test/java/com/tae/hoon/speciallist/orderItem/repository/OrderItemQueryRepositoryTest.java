package com.tae.hoon.speciallist.orderItem.repository;

import com.tae.hoon.speciallist.Enum.orderStatus.OrderStatus;
import com.tae.hoon.speciallist.item.domain.Item;
import com.tae.hoon.speciallist.item.repository.ItemRepository;
import com.tae.hoon.speciallist.order.domain.Order;
import com.tae.hoon.speciallist.order.repository.OrderRepository;
import com.tae.hoon.speciallist.orderItem.domain.OrderItem;
import com.tae.hoon.speciallist.orderItem.dto.OrderItemDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OrderItemQueryRepositoryTest {
    Logger log = (Logger) LoggerFactory.getLogger(OrderItemQueryRepositoryTest.class);

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ItemRepository itemRepository;


    @BeforeEach
    void setUp() {
        Item item = Item.builder().itemId(1L).name("상품1").price(1).stockQuantity(1).build();
        itemRepository.save(item);

        Order order = Order.builder().orderId(1L).orderDate(LocalDate.now()).orderStatus(OrderStatus.START).build();
        orderRepository.save(order);


        OrderItem orderItem =
                OrderItem.builder()
                        .orderItemId(1L)
                        .order(orderRepository
                                .findById(1L)
                                .get())
                        .item(itemRepository
                                .findById(1L)
                                .get())
                        .count(1)
                        .orderPrice(1)
                        .build();

        orderItemRepository.save(orderItem);

        log.info("Finishing Setting Up");
        log.info("Finishing Setting Up");
        log.info("Finishing Setting Up");
        log.info("Finishing Setting Up");
        log.info("Finishing Setting Up");

    }

    @AfterEach
    void tearDown() {
//        orderItemRepository.deleteById(1l);
//        orderRepository.deleteById(1L);
//        itemRepository.deleteById(1L);
    }

//    @Test
//    @DisplayName("OrderItem 이 정상적으로 저장되는지 테스트")
    void saveTest() {

        OrderItem orderItem =
                OrderItem.builder()
                        .orderItemId(1L)
                        .order(orderRepository
                                .findById(1L)
                                .get())
                        .item(itemRepository
                                .findById(1L)
                                .get())
                        .count(1)
                        .orderPrice(1)
                        .build();

        orderItemRepository.save(orderItem);

        OrderItem orderItem1 = orderItemRepository.getById(1L);
        assertEquals(orderItem.getOrderItemId(), orderItemRepository.findById(1L).get().getOrderItemId());
    }

//    @Test
//    @DisplayName("OrderItem 을 QUERYDSL을 통하여 조회가 제대로 이루워지는지 테스트")
    void QueryDslSelectTest() {
        log.info("Start Testing");
        log.info("Start Testing");
        log.info("Start Testing");

        Optional<OrderItem> orderItem = orderItemRepository.findByIdTest(1L);

        log.info("Finish Testing");
        log.info("Finish Testing");
        log.info("Finish Testing");

        assertEquals(orderItem.orElseThrow(NoSuchElementException::new).getOrderItemId(), 1l);
    }

    @Test
    @DisplayName("OrderItem를 QUERYDSL을 통하여 조회하고, 결과를 DTO로 반환")
    void QueryDslReturnDtoTest(){
        log.info("Start Testing");
        log.info("Start Testing");
        log.info("Start Testing");

        Optional<OrderItemDto> orderItemDto = orderItemRepository.findByIdTest2(1L);

        log.info("Finish Testing");
        log.info("Finish Testing");
        log.info("Finish Testing");

        assertEquals(orderItemDto.orElseThrow(NoSuchElementException::new).getOrderItemId(), 1l);

    }
}
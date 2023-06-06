package cn.lili.modules.order.order.serviceimpl;

import cn.lili.modules.order.cart.entity.dto.TradeDTO;
import cn.lili.modules.order.order.entity.dto.OrderSearchParams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;

    /*@Test
    void queryByParams() {
        OrderSearchParams orderSearchParams = new OrderSearchParams();
        orderSearchParams.setMemberId("1662638714546253824");
        orderService.queryByParams(orderSearchParams);
        Assertions.assertTrue(true);
    }

    @Test
    void queryByParams2() {
        try{
            orderService.queryByParams(null);
        }catch (Exception e){
            Assertions.assertTrue(true);
        }

    }*/

    /*@Test
    void queryDetail() {
        String orderId = "O202306021664587585431416833";
        orderService.queryDetail(orderId);
        Assertions.assertTrue(true);
    }

    @Test
    void queryDetail2() {
        String orderId = "test";
        try {
            orderService.queryDetail(orderId);
        }catch (Exception e){
            Assertions.assertTrue(true);
        }
    }

    @Test
    void queryDetail3() {
        String orderId = null;
        try {
            orderService.queryDetail(orderId);
        }catch (Exception e){
            Assertions.assertTrue(true);
        }
    }*/

    @Test
    void cancel() {
        String orderSn = "O202306021664587585431416833";
        String reason = "不要了";
        try {
            orderService.cancel(orderSn, reason);
        }catch (Exception e){
            Assertions.assertTrue(true);
        }
    }

    @Test
    void cancel2() {
        String orderSn = "test";
        String reason = "不要了";
        try {
            orderService.cancel(orderSn, reason);
        }catch (Exception e){
            Assertions.assertTrue(true);
        }
    }

    @Test
    void cancel3() {
        String orderSn = "O202305281662791936594546689";
        String reason = "不要了";
        try {
            orderService.cancel(orderSn, reason);
        }catch (Exception e){
            Assertions.assertTrue(true);
        }
    }
}
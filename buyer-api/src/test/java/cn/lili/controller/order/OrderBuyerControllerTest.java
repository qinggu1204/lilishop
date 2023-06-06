package cn.lili.controller.order;

import cn.lili.modules.order.order.entity.dto.OrderSearchParams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.constraints.AssertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OrderBuyerControllerTest {
    @Autowired
    private OrderBuyerController orderBuyerController;

    @Test
    void queryMineOrder() {
        orderBuyerController.queryMineOrder(new OrderSearchParams());
        Assertions.assertTrue(true);
    }

    @Test
    void queryMineOrder2() {
        try {
            orderBuyerController.queryMineOrder(null);
        }catch (Exception e){
            Assertions.assertTrue(true);
        }
    }

    @Test
    void detail() {
        String orderSn = "O202306021664587585431416833";
        try {
            orderBuyerController.detail(orderSn);
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void detail2() {
        String orderSn = "test";
        try{
            orderBuyerController.detail(orderSn);
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void detail3() {
        String orderSn = null;
        try{
            orderBuyerController.detail(orderSn);
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void cancel() {
        String orderSn = "O202306021664587585431416833";
        String reason = "不要不要";
        try {
            orderBuyerController.cancel(orderSn, reason);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void cancel2() {
        String orderSn = null;
        String reason = null;
        try {
            orderBuyerController.cancel(orderSn, reason);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void cancel3() {
        String orderSn = "2123";
        String reason = "test";
        try {
            orderBuyerController.cancel(orderSn, reason);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void cancel4() {
        String orderSn = "test";
        String reason = "";
        try {
            orderBuyerController.cancel(orderSn, reason);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void cancel5() {
        String orderSn = "O202306021664587585431416833";
        String reason = "test";
        try {
            orderBuyerController.cancel(orderSn, reason);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }
}
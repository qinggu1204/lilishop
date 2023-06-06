package lili.controller.order;

import cn.lili.controller.order.OrderBuyerController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OrderBuyerControllerTest {
    @Autowired
    private OrderBuyerController orderBuyerController;

    /*@Test
    void queryMineOrder() {
        orderBuyerController.queryMineOrder(new OrderSearchParams());
        Assertions.assertTrue(true);
    }

    @Test
    void queryMineOrder2() {
        orderBuyerController.queryMineOrder(null);
        Assertions.assertTrue(true);
    }*/

    @Test
    void detail() {
        String orderSn = "test";
        orderBuyerController.detail(orderSn);
        Assertions.assertTrue(true);
    }

    @Test
    void detail2() {
        String orderSn = "";
        orderBuyerController.detail(orderSn);
        Assertions.assertTrue(true);
    }

    @Test
    void detail3() {
        orderBuyerController.detail(null);
        Assertions.assertTrue(true);
    }

    /*@Test
    void receiving() {
        String orderSn = "test";
        orderBuyerController.receiving(orderSn);
        Assertions.assertTrue(true);
    }*/

    @Test
    void cancel() {
        String orderSn = "test";
        String reason = "test";
        orderBuyerController.cancel(orderSn, reason);
        Assertions.assertTrue(true);
    }

    @Test
    void cancel2() {
        String orderSn = "test";
        String reason = null;
        orderBuyerController.cancel(orderSn, reason);
        Assertions.assertTrue(true);
    }

    @Test
    void cancel3() {
        String orderSn = null;
        String reason = "test";
        orderBuyerController.cancel(orderSn, reason);
        Assertions.assertTrue(true);
    }

    @Test
    void cancel4() {
        String orderSn = "test";
        String reason = "";
        orderBuyerController.cancel(orderSn, reason);
        Assertions.assertTrue(true);
    }

    @Test
    void cancel5() {
        String orderSn = "";
        String reason = "test";
        orderBuyerController.cancel(orderSn, reason);
        Assertions.assertTrue(true);
    }

    /*@Test
    void deleteOrder() {
        String orderSn = "test";
        orderBuyerController.deleteOrder(orderSn);
        Assertions.assertTrue(true);
    }

    @Test
    void getTraces() {
        String orderSn = "test";
        orderBuyerController.getTraces(orderSn);
        Assertions.assertTrue(true);
    }

    @Test
    void getMapTraces() {
        String orderSn = "test";
        orderBuyerController.getMapTraces(orderSn);
        Assertions.assertTrue(true);
    }

    @Test
    void invoice() {
        String orderSn = "test";
        orderBuyerController.invoice(orderSn);
        Assertions.assertTrue(true);
    }*/
}
package cn.lili.modules.order.order.service;

import cn.lili.common.enums.ResultCode;
import cn.lili.common.exception.ServiceException;
import cn.lili.modules.order.order.entity.dos.Order;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author tageshi
 * @date 2023/5/27 21:54
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderPriceServiceTest {
    @Autowired
    private OrderPriceService orderPriceService;
    @Autowired
    private OrderService orderService;
    @Test
    public void testUpdateOrderPriceSuccess() {
        String orderSn = "O202305181659077493493325825";
        Double orderPrice = 100.0;
        Order order = orderPriceService.updatePrice(orderSn, orderPrice);
        assertEquals(orderPrice,order.getFlowPrice());
    }

    @Test
    public void testUpdateOrderPricePaid() {
        String orderSn = "O202305181659077493493325825";
        Double orderPrice = 100.0;
        Order order = orderPriceService.updatePrice(orderSn, orderPrice);
        assertEquals(orderPrice,order.getFlowPrice());
    }

    @Test
    public void testUpdateOrderPriceErrorSn() {
        String orderSn = "123";
        Order order =  orderService.getBySn(orderSn);
        assertNull(order);
    }
}

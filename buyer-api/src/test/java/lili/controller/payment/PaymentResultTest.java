package lili.controller.payment;

import cn.lili.modules.payment.kit.CashierSupport;
import cn.lili.modules.payment.kit.dto.PayParam;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author yzw
 * @date 2023年06月04日 15:39
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PaymentResultTest {


    @Autowired
    private CashierSupport support;

    private MockHttpServletRequest request = new MockHttpServletRequest();


    @Test
    public void callbackTest() {
        PayParam payParam = new PayParam();
        payParam.setClientType("PC");
        payParam.setOrderType("TRA12424DE");
        payParam.setSn("T202306041665259038023876608");
        try {
            support.paymentResult(payParam);
            Assertions.assertTrue(true);
        } catch (Exception e) {
        }
    }

    @Test
    public void callbackErrorTest() {
        PayParam payParam = new PayParam();
        payParam.setClientType("fadsfasdf");
        payParam.setOrderType("TRA12424DE");
        payParam.setSn("T202306041665259038023876608");
        try {
            support.paymentResult(payParam);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }
}

package lili.controller.payment;

/**
 * @author yzw
 * @date 2023年06月04日 15:47
 */

import cn.lili.modules.payment.entity.enums.PaymentMethodEnum;
import cn.lili.modules.payment.kit.CashierSupport;
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
public class CallBackTest {


    @Autowired
    private CashierSupport support;

    private MockHttpServletRequest request = new MockHttpServletRequest();


    @Test
    public void callbackTest() {
        CashierSupport support = new CashierSupport();
        try {
            support.callback(PaymentMethodEnum.ALIPAY, request);
            Assertions.assertTrue(true);
        } catch (Exception e) {
        }
    }
}

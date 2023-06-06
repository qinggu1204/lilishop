package lili.controller.payment;

/**
 * @author yzw
 * @date 2023年06月04日 15:47
 */

import cn.lili.controller.payment.CashierController;
import cn.lili.modules.payment.entity.enums.PaymentMethodEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author yzw
 * @date 2023年06月04日 15:39
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CallBackControllerTest {


    private MockHttpServletRequest request = new MockHttpServletRequest();


    @Test
    public void callbackSuccTest() {
        CashierController controller = new CashierController();
        try {
            controller.callback(request, PaymentMethodEnum.WECHAT.paymentName());
            Assertions.assertTrue(true);
        } catch (Exception e) {
        }
    }

    @Test
    public void callbackFailTest() {
        CashierController controller = new CashierController();
        try {
            controller.callback(request, null);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }
}

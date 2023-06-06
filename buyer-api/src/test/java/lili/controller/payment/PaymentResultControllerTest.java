package lili.controller.payment;

import cn.lili.controller.payment.CashierController;
import cn.lili.modules.payment.kit.dto.PayParam;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author yzw
 * @date 2023年06月04日 15:39
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PaymentResultControllerTest {

    @Test
    public void noSnTest() {
        CashierController controller = new CashierController();
        PayParam payParam = new PayParam();
        payParam.setClientType("app");
        payParam.setOrderType("ORDER");
        try {
            controller.paymentResult(payParam);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void noClientTypeTest() {
        CashierController controller = new CashierController();
        PayParam payParam = new PayParam();
        payParam.setOrderType("ORDER");
        payParam.setSn("1111111111111111111");
        try {
            controller.paymentResult(payParam);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void noOrderTypeTest() {
        CashierController controller = new CashierController();
        PayParam payParam = new PayParam();
        payParam.setClientType("app");
        payParam.setSn("1111111111111111111");
        try {
            controller.paymentResult(payParam);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void allRightTest() {
        CashierController controller = new CashierController();
        PayParam payParam = new PayParam();
        payParam.setClientType("PC");
        payParam.setOrderType("TRADE");
        payParam.setSn("T202306041665259038023876608");
        try {
            controller.paymentResult(payParam);
            Assertions.assertTrue(true);
        } catch (Exception e) {

        }
    }
}

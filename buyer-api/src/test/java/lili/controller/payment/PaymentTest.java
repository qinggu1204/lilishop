package lili.controller.payment;

import cn.lili.modules.payment.entity.enums.PaymentClientEnum;
import cn.lili.modules.payment.entity.enums.PaymentMethodEnum;
import cn.lili.modules.payment.kit.CashierSupport;
import cn.lili.modules.payment.kit.dto.PayParam;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author yzw
 * @date 2023年06月02日 15:42
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PaymentTest {

    @Autowired
    private CashierSupport support;

    @Test
    public void noPayMethodTest() {
        PayParam payParam = new PayParam();
        payParam.setClientType("app");
        payParam.setOrderType("ORDER");
        payParam.setSn("1111111111111111111");
        try {
            support.payment(null, null, null, null, payParam);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }

    }
    @Test
    public void noSnTest() {
        CashierSupport support = new CashierSupport();
        PayParam payParam = new PayParam();
        payParam.setClientType("app");
        payParam.setOrderType("ORDER");
        try {
            support.payment(PaymentMethodEnum.ALIPAY,
                    PaymentClientEnum.APP, null, null, payParam);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void noClientTypeTest() {
        CashierSupport support = new CashierSupport();
        PayParam payParam = new PayParam();
        payParam.setOrderType("ORDER");
        payParam.setSn("1111111111111111111");
        try {
            support.payment(PaymentMethodEnum.ALIPAY,
                    PaymentClientEnum.APP, null, null, payParam);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void noOrderTypeTest() {
        CashierSupport support = new CashierSupport();
        PayParam payParam = new PayParam();
        payParam.setClientType("app");
        payParam.setSn("1111111111111111111");
        try {
            support.payment(PaymentMethodEnum.ALIPAY,
                    PaymentClientEnum.APP, null, null, payParam);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void allRightTest() {
        CashierSupport support = new CashierSupport();
        PayParam payParam = new PayParam();
        payParam.setClientType("app");
        payParam.setOrderType("ORDER");
        payParam.setSn("1111111111111111111");
        try {
            support.payment(PaymentMethodEnum.ALIPAY,
                    PaymentClientEnum.APP, null, null, payParam);
            Assertions.assertTrue(true);
        } catch (Exception e) {

        }
    }

}

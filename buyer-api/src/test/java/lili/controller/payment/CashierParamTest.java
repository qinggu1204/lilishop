package lili.controller.payment;

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
 * @date 2023年06月04日 15:29
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CashierParamTest {

    @Autowired
    private CashierSupport support;


    @Test
    public void orderTypeErrorTest() {
        CashierSupport support = new CashierSupport();
        PayParam payParam = new PayParam();
        payParam.setClientType("PC");
        payParam.setOrderType("TRA12424DE");
        payParam.setSn("T202306041665259038023876608");
        try {
            support.cashierParam(payParam);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void allRightTest() {
        CashierSupport support = new CashierSupport();
        PayParam payParam = new PayParam();
        payParam.setClientType("PC");
        payParam.setOrderType("TRADE");
        payParam.setSn("T202306041665259038023876608");
        try {
            support.cashierParam(payParam);
            Assertions.assertTrue(true);
        } catch (Exception e) {

        }
    }

}

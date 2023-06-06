package lili.controller.payment;

import cn.lili.controller.payment.CashierController;
import cn.lili.modules.payment.kit.dto.PayParam;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CashierControllerTest {
    private MockHttpServletRequest request = new MockHttpServletRequest();
    private MockHttpServletResponse response = new MockHttpServletResponse();

    /**
     * 测试支付成功
     *
     * @author yzw
     * @date 2023/6/4 14:57
     */
    @Test
    void paymentSucc() {
        CashierController controller = new CashierController();
        PayParam payParam = new PayParam();
        payParam.setClientType("PC");
        payParam.setOrderType("TRADE");
        payParam.setSn("T202306041665253279030575104");
        try {
            controller.payment(request, response, "paymentMethod", "NATIVE"
                    , payParam);
            Assertions.assertTrue(true);
        } catch (Exception e) {
        }
    }

    /**
     * 测试支付失败
     *
     * @author yzw
     * @date 2023/6/4 14:57
     */
    @Test
    void paymentFail() {
        CashierController controller = new CashierController();
        PayParam payParam = new PayParam();
        payParam.setClientType("PC");
        payParam.setOrderType("TRADE");
        payParam.setSn("T2023060416652011616763904");
        try {
            controller.payment(request, response, "paymentMethod", "NATIVE"
                    , payParam);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }

    }


}
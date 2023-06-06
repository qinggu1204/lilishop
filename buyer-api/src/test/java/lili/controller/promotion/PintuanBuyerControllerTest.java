package lili.controller.promotion;

import cn.lili.controller.promotion.PintuanBuyerController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PintuanBuyerControllerTest {
    @Autowired
    private PintuanBuyerController pintuanBuyerController;

    /*@Test
    void getPintuanCategory() {
        String goodsName = "test";
        String categoryPath = "test";
        PageVO pageVo = new PageVO();
        pintuanBuyerController.getPintuanCategory(goodsName, categoryPath, pageVo);
        Assertions.assertTrue(true);
    }

    @Test
    void getPintuanCategory2() {
        pintuanBuyerController.getPintuanCategory(null, null, null);
        Assertions.assertTrue(true);
    }
*/
    /*@Test
    void getPintuanMember() {
        String pintuanId = "test";
        pintuanBuyerController.getPintuanMember(pintuanId);
        Assertions.assertTrue(true);
    }

    @Test
    void getPintuanMember2() {
        pintuanBuyerController.getPintuanMember(null);
        Assertions.assertTrue(true);
    }*/


    @Test
    void share() {
        String parentOrderSn = "test";
        String skuId = "test";
        pintuanBuyerController.share(parentOrderSn, skuId);
        Assertions.assertTrue(true);
    }

    @Test
    void share2() {
        pintuanBuyerController.share(null, null);
        Assertions.assertTrue(true);
    }
}
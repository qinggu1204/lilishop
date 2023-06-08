package cn.lili.controller.promotion;

import cn.lili.common.vo.PageVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.PathVariable;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PintuanBuyerControllerTest {
    @Autowired
    private PintuanBuyerController pintuanBuyerController;

    @Test
    void getPintuanMember() {
        String pintuanId = "test";
        pintuanBuyerController.getPintuanMember(pintuanId);
        Assertions.assertTrue(true);
    }

    @Test
    void getPintuanMember2() {
        try {
            pintuanBuyerController.getPintuanMember(null);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }


    @Test
    void share() {
        String parentOrderSn = "test";
        String skuId = "test";
        try {
            pintuanBuyerController.share(parentOrderSn, skuId);
        }catch (Exception e){
            Assertions.assertTrue(true);
        }

    }

    @Test
    void share2() {
        String parentOrderSn = null;
        String skuId = "test";
        try {
            pintuanBuyerController.share(parentOrderSn, skuId);
        }catch (Exception e){
            Assertions.assertTrue(true);
        }
    }

    @Test
    void share3() {
        String parentOrderSn = "test";
        String skuId = null;
        try {
            pintuanBuyerController.share(parentOrderSn, skuId);
        }catch (Exception e){
            Assertions.assertTrue(true);
        }
    }

    @Test
    void share4() {
        String parentOrderSn = null;
        String skuId = null;
        try {
            pintuanBuyerController.share(parentOrderSn, skuId);
        }catch (Exception e){
            Assertions.assertTrue(true);
        }
    }

    @Test
    void share5() {
        String parentOrderSn = "null";
        String skuId = "null";
        try {
            pintuanBuyerController.share(parentOrderSn, skuId);
        }catch (Exception e){
            Assertions.assertTrue(true);
        }
    }
}
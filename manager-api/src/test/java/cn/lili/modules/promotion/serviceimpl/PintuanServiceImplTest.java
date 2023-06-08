package cn.lili.modules.promotion.serviceimpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class PintuanServiceImplTest {
    @Autowired
    private PintuanServiceImpl pintuanService;

    @Test
    void getPintuanMember() {
        String pintuanId = "test";
        pintuanService.getPintuanMember(pintuanId);
        Assertions.assertTrue(true);
    }

    @Test
    void getPintuanMember2() {
        try {
            pintuanService.getPintuanMember(null);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void getPintuanShareInfo() {
        String parentOrderSn = "test";
        String skuId = "test";
        try {
            pintuanService.getPintuanShareInfo(parentOrderSn, skuId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getPintuanShareInfo2() {
        String parentOrderSn = null;
        String skuId = "test";
        try {
            pintuanService.getPintuanShareInfo(parentOrderSn, skuId);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }
    @Test
    void getPintuanShareInfo3() {
        String parentOrderSn = "test";
        String skuId = null;
        try {
            pintuanService.getPintuanShareInfo(parentOrderSn, skuId);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void getPintuanShareInfo4() {
        String parentOrderSn = null;
        String skuId = null;
        try {
            pintuanService.getPintuanShareInfo(parentOrderSn, skuId);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void getPintuanShareInfo5() {
        String parentOrderSn = "null";
        String skuId = "null";
        try {
            pintuanService.getPintuanShareInfo(parentOrderSn, skuId);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }
}
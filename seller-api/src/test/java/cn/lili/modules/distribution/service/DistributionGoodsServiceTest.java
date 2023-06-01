package cn.lili.modules.distribution.service;

import cn.lili.common.exception.ServiceException;
import cn.lili.modules.distribution.entity.dos.DistributionGoods;
import cn.lili.modules.distribution.entity.dto.DistributionGoodsSearchParams;
import cn.lili.modules.distribution.entity.vos.DistributionGoodsVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class DistributionGoodsServiceTest {

    @Autowired
    private DistributionGoodsService distributionGoodsService;

    @Test
    public void testGetDistributionGoodsList() {
        DistributionGoodsSearchParams params = new DistributionGoodsSearchParams();

        List<DistributionGoods> result = distributionGoodsService.getDistributionGoodsList(params);

        System.out.println(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testGetDistributionGoodsListWithInvalidParams() {
        DistributionGoodsSearchParams params = new DistributionGoodsSearchParams();
        params.setGoodsId("invalidId");
        
        List<DistributionGoods> result = distributionGoodsService.getDistributionGoodsList(params);

        assertFalse(result.isEmpty());
    }
    
    
}

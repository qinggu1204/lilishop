package cn.lili.modules.goods.service;

import cn.lili.modules.goods.entity.dos.Goods;
import cn.lili.modules.goods.entity.dto.GoodsSearchParams;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GoodsServiceTest {
    @Autowired
    private GoodsService goodsService;

    @Test
    //查询的商品在数据库中存在
    public void testQueryByParamsExist() throws Exception {
        GoodsSearchParams goodsSearchParams = new GoodsSearchParams();
        goodsSearchParams.setGoodsName("华为");

        IPage<Goods> result = goodsService.queryByParams(goodsSearchParams);

        assertEquals(13, result.getTotal());
    }

    @Test
    //查询的商品在数据库中不存在
    public void testQueryByParamsNotExist() throws Exception {
        GoodsSearchParams goodsSearchParams = new GoodsSearchParams();
        goodsSearchParams.setGoodsName("啦啦啦");

        IPage<Goods> result = goodsService.queryByParams(goodsSearchParams);

        assertEquals(0, result.getTotal());
    }
}

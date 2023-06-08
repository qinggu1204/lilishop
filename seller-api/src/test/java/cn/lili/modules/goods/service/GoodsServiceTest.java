package cn.lili.modules.goods.service;

import cn.lili.modules.goods.entity.dos.Goods;
import cn.lili.modules.goods.entity.dto.GoodsOperationDTO;
import cn.lili.modules.goods.entity.dto.GoodsParamsDTO;
import cn.lili.modules.goods.entity.dto.GoodsSearchParams;
import cn.lili.modules.goods.serviceimpl.GoodsServiceImpl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GoodsServiceTest {
//    @Mock
//    private GoodsSkuService goodsSkuService;
//
//    @Mock
//    private GoodsGalleryService goodsGalleryService;

    @Autowired
    private GoodsService goodsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    //查询的商品在数据库中存在
    public void testQueryByParamsExist() throws Exception {
        GoodsSearchParams goodsSearchParams = new GoodsSearchParams();
        goodsSearchParams.setGoodsName("华为");

        IPage<Goods> result = goodsService.queryByParams(goodsSearchParams);

        assertEquals(21, result.getTotal());
    }

    @Test
    //查询的商品在数据库中不存在
    public void testQueryByParamsNotExist() throws Exception {
        GoodsSearchParams goodsSearchParams = new GoodsSearchParams();
        goodsSearchParams.setGoodsName("啦啦啦");

        IPage<Goods> result = goodsService.queryByParams(goodsSearchParams);

        assertEquals(0, result.getTotal());
    }

    @Test
    //添加的商品信息包含goodsGalleryList
    public void testAddGoodsWithGalleryList() {
        // 创建测试数据
        Map<String, Object> map1 = new HashMap<>();
        map1.put("sn", "111");
        map1.put("price", 5600.0);
        map1.put("cost",4000.0);
        map1.put("weight", 10.0);
        map1.put("quantity", 200);
        map1.put("颜色", "红色");

        Map<String, Object> map2 = new HashMap<>();
        map2.put("sn", "222");
        map2.put("price", 5600.0);
        map2.put("cost",4000.0);
        map2.put("weight", 10.0);
        map2.put("quantity", 200);
        map2.put("颜色", "蓝色");

        List<Map<String, Object>> skuList = new ArrayList<>();
        skuList.add(map1);
        skuList.add(map2);

        GoodsOperationDTO goodsOperationDTO = new GoodsOperationDTO();
        goodsOperationDTO.setPrice(5000.0);
        goodsOperationDTO.setCategoryPath("1348576427264204941,1348576427264204942,1348576427264204943");
        goodsOperationDTO.setStoreCategoryPath("1420665580290355201");
        goodsOperationDTO.setBrandId("1349563815406886988");
        goodsOperationDTO.setGoodsName("华为P40pro");
        goodsOperationDTO.setIntro("Test intro");
        goodsOperationDTO.setMobileIntro("Test mobile intro");
        goodsOperationDTO.setQuantity(100);
        goodsOperationDTO.setRelease(true);
        goodsOperationDTO.setRecommend(true);
        goodsOperationDTO.setGoodsParamsDTOList(new ArrayList<>());
        goodsOperationDTO.setGoodsGalleryList(Arrays.asList("https://qinggu1204.obs.cn-east-3.myhuaweicloud.com/8b3e99df97cf4cab8c6210d874b48672.jpg", "https://qinggu1204.obs.cn-east-3.myhuaweicloud.com/8b3e99df97cf4cab8c6210d874b48672.jpg"));
        goodsOperationDTO.setTemplateId("0");
        goodsOperationDTO.setSellingPoint("好用！");
        goodsOperationDTO.setSalesModel("RETAIL");
        goodsOperationDTO.setHaveSpec("false");
        goodsOperationDTO.setGoodsUnit("件");
        goodsOperationDTO.setInfo("Test info");
        goodsOperationDTO.setRegeneratorSkuFlag(true);
        goodsOperationDTO.setGoodsType("VIRTUAL_GOODS");
        goodsOperationDTO.setGoodsVideo("Test video");
        goodsOperationDTO.setSkuList(skuList);
        goodsOperationDTO.setGoodsTemplateFlag(false);
        goodsOperationDTO.setNeedingAttention("Test attention");
        goodsOperationDTO.setAnnualFeeExclusive(false);
        goodsOperationDTO.setBrowsePermissions("Test permissions");

        // 方法调用
        goodsService.addGoods(goodsOperationDTO);

        // 验证方法调用
//        verify(goodsSkuService, times(1)).add(any(Goods.class), any(GoodsOperationDTO.class));
//        verify(goodsGalleryService, times(1)).add(anyList(), anyString());
    }

    @Test
    //添加的商品信息不包含goodsGalleryList
    public void testAddGoodsWithNoGalleryList() {
        // 创建测试数据
        Map<String, Object> map1 = new HashMap<>();
        map1.put("sn", "111");
        map1.put("price", 5600.0);
        map1.put("cost",4000.0);
        map1.put("weight", 10.0);
        map1.put("quantity", 200);
        map1.put("颜色", "红色");

        Map<String, Object> map2 = new HashMap<>();
        map2.put("sn", "222");
        map2.put("price", 5600.0);
        map2.put("cost",4000.0);
        map2.put("weight", 10.0);
        map2.put("quantity", 200);
        map2.put("颜色", "蓝色");

        List<Map<String, Object>> skuList = new ArrayList<>();
        skuList.add(map1);
        skuList.add(map2);

        GoodsOperationDTO goodsOperationDTO = new GoodsOperationDTO();
        goodsOperationDTO.setPrice(5000.0);
        goodsOperationDTO.setCategoryPath("1348576427264204941,1348576427264204942,1348576427264204943");
        goodsOperationDTO.setStoreCategoryPath("1420665580290355201");
        goodsOperationDTO.setBrandId("1349563815406886988");
        goodsOperationDTO.setGoodsName("华为P40pro");
        goodsOperationDTO.setIntro("Test intro");
        goodsOperationDTO.setMobileIntro("Test mobile intro");
        goodsOperationDTO.setQuantity(100);
        goodsOperationDTO.setRelease(true);
        goodsOperationDTO.setRecommend(true);
        goodsOperationDTO.setGoodsParamsDTOList(new ArrayList<>());
        goodsOperationDTO.setGoodsGalleryList(new ArrayList<>());
        goodsOperationDTO.setTemplateId("0");
        goodsOperationDTO.setSellingPoint("好用！");
        goodsOperationDTO.setSalesModel("RETAIL");
        goodsOperationDTO.setHaveSpec("false");
        goodsOperationDTO.setGoodsUnit("件");
        goodsOperationDTO.setInfo("Test info");
        goodsOperationDTO.setRegeneratorSkuFlag(true);
        goodsOperationDTO.setGoodsType("VIRTUAL_GOODS");
        goodsOperationDTO.setGoodsVideo("Test video");
        goodsOperationDTO.setSkuList(skuList);
        goodsOperationDTO.setGoodsTemplateFlag(false);
        goodsOperationDTO.setNeedingAttention("Test attention");
        goodsOperationDTO.setAnnualFeeExclusive(false);
        goodsOperationDTO.setBrowsePermissions("Test permissions");

        // 方法调用
        goodsService.addGoods(goodsOperationDTO);

        // 验证方法调用
//        verify(goodsSkuService, times(1)).add(any(Goods.class), any(GoodsOperationDTO.class));
//        verify(goodsGalleryService, times(1)).add(anyList(), anyString());
    }

    @Test
    //修改的商品信息包含goodsGalleryList
    public void testEditGoodsWithGalleryList() {
        // 创建测试数据
        Map<String, Object> map1 = new HashMap<>();
        map1.put("sn", "111");
        map1.put("price", 5600.0);
        map1.put("cost",4000.0);
        map1.put("weight", 10.0);
        map1.put("quantity", 200);
        map1.put("颜色", "红色");

        Map<String, Object> map2 = new HashMap<>();
        map2.put("sn", "222");
        map2.put("price", 5600.0);
        map2.put("cost",4000.0);
        map2.put("weight", 10.0);
        map2.put("quantity", 200);
        map2.put("颜色", "蓝色");

        List<Map<String, Object>> skuList = new ArrayList<>();
        skuList.add(map1);
        skuList.add(map2);

        GoodsOperationDTO goodsOperationDTO = new GoodsOperationDTO();
        goodsOperationDTO.setPrice(5000.0);
        goodsOperationDTO.setCategoryPath("1348576427264204941,1348576427264204942,1348576427264204943");
        goodsOperationDTO.setStoreCategoryPath("1420665580290355201");
        goodsOperationDTO.setBrandId("1349563815406886988");
        goodsOperationDTO.setGoodsName("小米ppppp");
        goodsOperationDTO.setIntro("Test intro");
        goodsOperationDTO.setMobileIntro("Test mobile intro");
        goodsOperationDTO.setQuantity(100);
        goodsOperationDTO.setRelease(true);
        goodsOperationDTO.setRecommend(true);
        goodsOperationDTO.setGoodsParamsDTOList(new ArrayList<>());
        goodsOperationDTO.setGoodsGalleryList(Arrays.asList("https://qinggu1204.obs.cn-east-3.myhuaweicloud.com/8b3e99df97cf4cab8c6210d874b48672.jpg", "https://qinggu1204.obs.cn-east-3.myhuaweicloud.com/8b3e99df97cf4cab8c6210d874b48672.jpg"));
        goodsOperationDTO.setTemplateId("0");
        goodsOperationDTO.setSellingPoint("好用！");
        goodsOperationDTO.setSalesModel("RETAIL");
        goodsOperationDTO.setHaveSpec("false");
        goodsOperationDTO.setGoodsUnit("件");
        goodsOperationDTO.setInfo("Test info");
        goodsOperationDTO.setRegeneratorSkuFlag(true);
        goodsOperationDTO.setGoodsType("VIRTUAL_GOODS");
        goodsOperationDTO.setGoodsVideo("Test video");
        goodsOperationDTO.setSkuList(skuList);
        goodsOperationDTO.setGoodsTemplateFlag(false);
        goodsOperationDTO.setNeedingAttention("Test attention");
        goodsOperationDTO.setAnnualFeeExclusive(false);
        goodsOperationDTO.setBrowsePermissions("Test permissions");

        // 方法调用
        goodsService.editGoods(goodsOperationDTO,"1663213627877900290");

        // 验证方法调用
//        verify(goodsSkuService, times(1)).add(any(Goods.class), any(GoodsOperationDTO.class));
//        verify(goodsGalleryService, times(1)).add(anyList(), anyString());
    }

    @Test
    //修改的商品信息不包含goodsGalleryList
    public void testEditGoodsWithNoGalleryList() {
        // 创建测试数据
        Map<String, Object> map1 = new HashMap<>();
        map1.put("sn", "111");
        map1.put("price", 5600.0);
        map1.put("cost",4000.0);
        map1.put("weight", 10.0);
        map1.put("quantity", 200);
        map1.put("颜色", "红色");

        Map<String, Object> map2 = new HashMap<>();
        map2.put("sn", "222");
        map2.put("price", 5600.0);
        map2.put("cost",4000.0);
        map2.put("weight", 10.0);
        map2.put("quantity", 200);
        map2.put("颜色", "蓝色");

        List<Map<String, Object>> skuList = new ArrayList<>();
        skuList.add(map1);
        skuList.add(map2);

        GoodsOperationDTO goodsOperationDTO = new GoodsOperationDTO();
        goodsOperationDTO.setPrice(5000.0);
        goodsOperationDTO.setCategoryPath("1348576427264204941,1348576427264204942,1348576427264204943");
        goodsOperationDTO.setStoreCategoryPath("1420665580290355201");
        goodsOperationDTO.setBrandId("1349563815406886988");
        goodsOperationDTO.setGoodsName("华为P30");
        goodsOperationDTO.setIntro("Test intro");
        goodsOperationDTO.setMobileIntro("Test mobile intro");
        goodsOperationDTO.setQuantity(100);
        goodsOperationDTO.setRelease(true);
        goodsOperationDTO.setRecommend(true);
        goodsOperationDTO.setGoodsParamsDTOList(new ArrayList<>());
        goodsOperationDTO.setGoodsGalleryList(new ArrayList<>());
        goodsOperationDTO.setTemplateId("0");
        goodsOperationDTO.setSellingPoint("好用！");
        goodsOperationDTO.setSalesModel("RETAIL");
        goodsOperationDTO.setHaveSpec("false");
        goodsOperationDTO.setGoodsUnit("件");
        goodsOperationDTO.setInfo("Test info");
        goodsOperationDTO.setRegeneratorSkuFlag(true);
        goodsOperationDTO.setGoodsType("VIRTUAL_GOODS");
        goodsOperationDTO.setGoodsVideo("Test video");
        goodsOperationDTO.setSkuList(skuList);
        goodsOperationDTO.setGoodsTemplateFlag(false);
        goodsOperationDTO.setNeedingAttention("Test attention");
        goodsOperationDTO.setAnnualFeeExclusive(false);
        goodsOperationDTO.setBrowsePermissions("Test permissions");

        // 方法调用
        goodsService.editGoods(goodsOperationDTO,"1663211943655149569");

        // 验证方法调用
//        verify(goodsSkuService, times(1)).add(any(Goods.class), any(GoodsOperationDTO.class));
//        verify(goodsGalleryService, times(1)).add(anyList(), anyString());
    }

    @Test
    //删除的商品在数据库中存在
    public void testDeleteGoodsExist(){
        assertTrue(goodsService.deleteGoods(Arrays.asList("1663170202101125122","1663170171075858433")));
    }

    @Test
    //删除的商品在数据库中不存在
    public void testDeleteGoodsNotExist(){
        assertFalse(goodsService.deleteGoods(Collections.singletonList("1101125122")));
    }
}

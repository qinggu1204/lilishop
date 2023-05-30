package cn.lili.controller.goods;

import cn.lili.modules.goods.entity.dto.GoodsOperationDTO;

import cn.lili.modules.goods.entity.dto.GoodsSearchParams;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class GoodsStoreControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    //查询的商品在数据库中存在
    public void testGetByPageExist() throws Exception {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1Mzc2NTMzfQ.EVRAGslYp_XogD_UQRadqj5aLE4gcrBlbXkS60Stnjs"; //这里输入你的accessToken
        GoodsSearchParams goodsSearchParams = new GoodsSearchParams();

        this.mockMvc.perform(MockMvcRequestBuilders.get("/store/goods/goods/list")
                        .header("accessToken", accessToken)
                        .param("param", goodsSearchParams.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

    @Test
    //查询的商品在数据库中不存在
    public void testGetByPageNotExist() throws Exception {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1Mzc2NTMzfQ.EVRAGslYp_XogD_UQRadqj5aLE4gcrBlbXkS60Stnjs"; //这里输入你的accessToken
        GoodsSearchParams goodsSearchParams = new GoodsSearchParams();
        goodsSearchParams.setGoodsName("啦啦啦");

        this.mockMvc.perform(MockMvcRequestBuilders.get("/store/goods/goods/list")
                        .header("accessToken", accessToken)
                        .param("param", goodsSearchParams.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

    @Test
    //添加的商品信息合法
    public void testSave() throws Exception {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1Mzc2NTMzfQ.EVRAGslYp_XogD_UQRadqj5aLE4gcrBlbXkS60Stnjs"; //这里输入你的accessToken
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

        this.mockMvc.perform(MockMvcRequestBuilders.post("/store/goods/goods/create")
                        .header("accessToken", accessToken)
                        .content(JSON.toJSONString(goodsOperationDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

    @Test
    //添加的商品信息为空
    public void testSaveWithNull() throws Exception {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1Mzc2NTMzfQ.EVRAGslYp_XogD_UQRadqj5aLE4gcrBlbXkS60Stnjs"; //这里输入你的accessToken
        // 创建测试数据
        GoodsOperationDTO goodsOperationDTO = new GoodsOperationDTO();
        goodsOperationDTO.setGoodsName("hello");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/store/goods/goods/create")
                        .header("accessToken", accessToken)
                        .content(JSON.toJSONString(goodsOperationDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andReturn();

    }

    @Test
    //修改的商品信息合法
    public void testUpdate() throws Exception {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1Mzc2NTMzfQ.EVRAGslYp_XogD_UQRadqj5aLE4gcrBlbXkS60Stnjs"; //这里输入你的accessToken
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
        goodsOperationDTO.setSellingPoint("非常非常非常非常好用！");
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

        this.mockMvc.perform(MockMvcRequestBuilders.put("/store/goods/goods/update?goodsId = 1663211943655149569")
                        .header("accessToken", accessToken)
                        .content(JSON.toJSONString(goodsOperationDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

    @Test
    //修改的商品信息为空
    public void testUpdateWithNull() throws Exception {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1Mzc2NTMzfQ.EVRAGslYp_XogD_UQRadqj5aLE4gcrBlbXkS60Stnjs"; //这里输入你的accessToken
        // 创建测试数据
        GoodsOperationDTO goodsOperationDTO = new GoodsOperationDTO();

        this.mockMvc.perform(MockMvcRequestBuilders.put("/store/goods/goods/update/?goodsId = 1663211943655149569")
                        .header("accessToken", accessToken)
                        .content(JSON.toJSONString(goodsOperationDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andReturn();

    }

    @Test
    //修改的商品不存在
    public void testUpdateNotExist() throws Exception {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1Mzc2NTMzfQ.EVRAGslYp_XogD_UQRadqj5aLE4gcrBlbXkS60Stnjs"; //这里输入你的accessToken
        // 创建测试数据
        GoodsOperationDTO goodsOperationDTO = new GoodsOperationDTO();

        this.mockMvc.perform(MockMvcRequestBuilders.put("/store/goods/goods/update/?goodsId = 16632119436559")
                        .header("accessToken", accessToken)
                        .content(JSON.toJSONString(goodsOperationDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andReturn();

    }

    @Test
    //删除的商品存在
    public void testDeleteExist() throws Exception {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1Mzc2NTMzfQ.EVRAGslYp_XogD_UQRadqj5aLE4gcrBlbXkS60Stnjs"; //这里输入你的accessToken
        // 创建测试数据
        List<String> goodsId = Collections.singletonList("12101125122");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/store/goods/goods/delete")
                        .header("accessToken", accessToken)
                        .param("param", goodsId.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

    @Test
    //删除的商品不存在
    public void testDeleteNotExist() throws Exception {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1Mzc2NTMzfQ.EVRAGslYp_XogD_UQRadqj5aLE4gcrBlbXkS60Stnjs"; //这里输入你的accessToken
        // 创建测试数据
        List<String> goodsId = Arrays.asList("1663170202101125122","1663170171075858433");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/store/goods/goods/delete")
                        .header("accessToken", accessToken)
                        .param("param", goodsId.toString()))
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andReturn();

    }
}

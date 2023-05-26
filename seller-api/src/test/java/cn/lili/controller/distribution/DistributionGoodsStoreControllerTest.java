package cn.lili.controller.distribution;

import cn.lili.common.enums.ResultCode;
import cn.lili.common.security.enums.SecurityEnum;
import cn.lili.modules.distribution.entity.dos.DistributionGoods;
import cn.lili.modules.distribution.entity.dto.DistributionGoodsSearchParams;
import cn.lili.common.vo.ResultMessage;
import cn.lili.modules.distribution.entity.vos.DistributionGoodsVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class DistributionGoodsStoreControllerTest {
    
    @Autowired
    private MockMvc mvc;

    @Test
    public void testDistributionGoods() throws Exception {
        // Given
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1MDIxOTUzfQ.VYZAkvba_UglVOiai1suwqD4bqJtGy4v6vtiH_nWtdU"; // Here is your access token
        // When
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/distribution/goods")
                        .header(SecurityEnum.HEADER_TOKEN.getValue(), accessToken))  // Set the header here
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // Then
        // Assert the return result
       /* DistributionGoodsSearchParams distributionGoodsSearchParams = new DistributionGoodsSearchParams();
        
        ResultMessage<IPage<DistributionGoodsVO>> result = distributionGoodsStoreController.distributionGoods(distributionGoodsSearchParams);

        assertEquals(ResultCode.SUCCESS.code(), result.getCode());*/
    }

    /*@Test
    public void testDistributionCheckGoods() {
        String skuId = "validSkuId"; // 请注意，这里的skuId必须是有效的
        Double commission = 10.0; // 这是一个示例值，你可以根据你的业务逻辑进行相应的调整

        ResultMessage<DistributionGoods> result = distributionGoodsStoreController.distributionCheckGoods(skuId, commission);

        assertEquals(ResultCode.SUCCESS.code(), result.getCode());
    }

    @Test
    public void testCancel() {
        String id = "validId"; // 请注意，这里的id必须是有效的

        ResultMessage<Object> result = distributionGoodsStoreController.cancel(id);

        assertEquals(ResultCode.SUCCESS.code(), result.getCode());
    }*/

}

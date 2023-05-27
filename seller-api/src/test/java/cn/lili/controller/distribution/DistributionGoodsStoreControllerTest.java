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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class DistributionGoodsStoreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testDistributionGoods() throws Exception {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1MDczOTY4fQ.WEX5BEEBvVmLxRpjG-YfboMLSoibLR4XO-36IL9zDbQ"; //这里输入你的accessToken
        DistributionGoodsSearchParams distributionGoodsSearchParams = new DistributionGoodsSearchParams();

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/store/distribution/goods")
                        .header("accessToken", accessToken)
                        .param("param", distributionGoodsSearchParams.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString();
        // 在这里对结果进行断言
        // 创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();

        // 将JSON字符串解析为JsonNode对象
        JsonNode jsonNode = objectMapper.readTree(result);

        System.out.println(jsonNode);

        // 提取result.code字段的值
        int code = jsonNode.get("code").asInt();
        assertEquals(ResultCode.SUCCESS.code(), code);
    }

    @Test
    public void testDistributionGoodsWithDefaultValues() throws Exception {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1MDczOTY4fQ.WEX5BEEBvVmLxRpjG-YfboMLSoibLR4XO-36IL9zDbQ";
        DistributionGoodsSearchParams distributionGoodsSearchParams = new DistributionGoodsSearchParams();

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/store/distribution/goods")
                        .header("accessToken", accessToken)
                        .param("param", distributionGoodsSearchParams.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // 后续进行断言处理...
        String result = mvcResult.getResponse().getContentAsString();
        // 在这里对结果进行断言
        // 创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();

        // 将JSON字符串解析为JsonNode对象
        JsonNode jsonNode = objectMapper.readTree(result);

        System.out.println(jsonNode);

        // 提取result.code字段的值
        int code = jsonNode.get("code").asInt();
        assertEquals(ResultCode.SUCCESS.code(), code);
    }

    @Test
    public void testDistributionGoodsWithGoodsId() throws Exception {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1MDczOTY4fQ.WEX5BEEBvVmLxRpjG-YfboMLSoibLR4XO-36IL9zDbQ";
        DistributionGoodsSearchParams distributionGoodsSearchParams = new DistributionGoodsSearchParams();
        distributionGoodsSearchParams.setGoodsId("testGoodsId"); // 假设这是一个有效的商品ID

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/store/distribution/goods")
                        .header("accessToken", accessToken)
                        .param("param", distributionGoodsSearchParams.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        
        // 后续类似上述方法...
        String result = mvcResult.getResponse().getContentAsString();
        
        // 在这里对结果进行断言
        // 创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();

        // 将JSON字符串解析为JsonNode对象
        JsonNode jsonNode = objectMapper.readTree(result);

        System.out.println(jsonNode);

        // 提取result.code字段的值
        int code = jsonNode.get("code").asInt();
        assertEquals(ResultCode.SUCCESS.code(), code);
    }

    @Test
    public void testDistributionGoodsWithGoodsName() throws Exception {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1MDczOTY4fQ.WEX5BEEBvVmLxRpjG-YfboMLSoibLR4XO-36IL9zDbQ";
        DistributionGoodsSearchParams distributionGoodsSearchParams = new DistributionGoodsSearchParams();
        distributionGoodsSearchParams.setGoodsName("testGoodsName"); // 假设这是一个有效的商品名称

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/store/distribution/goods")
                        .header("accessToken", accessToken)
                        .param("param", distributionGoodsSearchParams.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // 后续类似上述方法...
        String result = mvcResult.getResponse().getContentAsString();

        // 在这里对结果进行断言
        // 创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();

        // 将JSON字符串解析为JsonNode对象
        JsonNode jsonNode = objectMapper.readTree(result);

        System.out.println(jsonNode);

        // 提取result.code字段的值
        int code = jsonNode.get("code").asInt();
        assertEquals(ResultCode.SUCCESS.code(), code);
    }

    @Test
    public void testDistributionGoodsWithIsChecked() throws Exception {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1MDczOTY4fQ.WEX5BEEBvVmLxRpjG-YfboMLSoibLR4XO-36IL9zDbQ";
        DistributionGoodsSearchParams distributionGoodsSearchParams = new DistributionGoodsSearchParams();
//        distributionGoodsSearchParams.setIsChecked(true);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/store/distribution/goods")
                        .header("accessToken", accessToken)
                        .param("param", distributionGoodsSearchParams.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString();

        // 在这里对结果进行断言
        // 创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();

        // 将JSON字符串解析为JsonNode对象
        JsonNode jsonNode = objectMapper.readTree(result);

        System.out.println(jsonNode);

        // 提取result.code字段的值
        int code = jsonNode.get("code").asInt();
        assertEquals(ResultCode.SUCCESS.code(), code);
    }

    @Test
    public void testDistributionGoodsWithAllParameters() throws Exception {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1MDczOTY4fQ.WEX5BEEBvVmLxRpjG-YfboMLSoibLR4XO-36IL9zDbQ";
        DistributionGoodsSearchParams distributionGoodsSearchParams = new DistributionGoodsSearchParams();
        distributionGoodsSearchParams.setGoodsId("testGoodsId");
        distributionGoodsSearchParams.setGoodsName("testGoodsName");

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/store/distribution/goods")
                        .header("accessToken", accessToken)
                        .param("param", distributionGoodsSearchParams.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // 后续类似上述方法...
        String result = mvcResult.getResponse().getContentAsString();

        // 在这里对结果进行断言
        // 创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();

        // 将JSON字符串解析为JsonNode对象
        JsonNode jsonNode = objectMapper.readTree(result);

        System.out.println(jsonNode);

        // 提取result.code字段的值
        int code = jsonNode.get("code").asInt();
        assertEquals(ResultCode.SUCCESS.code(), code);
    }

    @Test
    public void testDistributionGoodsWithInvalidGoodsId() throws Exception {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1MDczOTY4fQ.WEX5BEEBvVmLxRpjG-YfboMLSoibLR4XO-36IL9zDbQ";
        DistributionGoodsSearchParams distributionGoodsSearchParams = new DistributionGoodsSearchParams();
        distributionGoodsSearchParams.setGoodsId("testGoodsId");
        distributionGoodsSearchParams.setGoodsName("testGoodsName");
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/store/distribution/goods")
                        .header("accessToken", accessToken)
                        .param("param", distributionGoodsSearchParams.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString();

        // 在这里对结果进行断言
        // 创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();

        // 将JSON字符串解析为JsonNode对象
        JsonNode jsonNode = objectMapper.readTree(result);

        System.out.println(jsonNode);

        // 提取result.code字段的值
        int code = jsonNode.get("code").asInt();
        assertEquals(ResultCode.SUCCESS.code(), code);
    }

    @Test
    public void testDistributionCheckGoodsCase1() throws Exception {
        String skuId = "1390847255409328128"; // 请注意，这里的skuId必须是有效的
        Double commission = 10.0; // 这是一个示例值，你可以根据你的业务逻辑进行相应的调整
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1MDgzMjUwfQ.CJvlTUqaLn5S5krzVWpccL9WPDkoJGihAwdQWyy2fMw"; //这里输入你的accessToken

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put("/store/distribution/goods/checked/" + skuId)
                        .header("accessToken", accessToken)
                        .param("commission", commission.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString();
        // 在这里对结果进行断言
        // 创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();

        // 将JSON字符串解析为JsonNode对象
        JsonNode jsonNode = objectMapper.readTree(result);

        System.out.println(jsonNode);

        // 提取result.code字段的值
        int code = jsonNode.get("code").asInt();
        assertEquals(ResultCode.SUCCESS.code(), code);
    }

    @Test
    public void testDistributionCheckGoodsCase2() throws Exception {
        String skuId = "1390847255409328128"; // 请注意，这里的skuId必须是有效的
        Double commission = -10.0; // 这是一个示例值，你可以根据你的业务逻辑进行相应的调整
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1MDgzMjUwfQ.CJvlTUqaLn5S5krzVWpccL9WPDkoJGihAwdQWyy2fMw"; //这里输入你的accessToken

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put("/store/distribution/goods/checked/" + skuId)
                        .header("accessToken", accessToken)
                        .param("commission", commission.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString();
        // 在这里对结果进行断言
        // 创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();

        // 将JSON字符串解析为JsonNode对象
        JsonNode jsonNode = objectMapper.readTree(result);

        System.out.println(jsonNode);

        // 提取result.code字段的值
        int code = jsonNode.get("code").asInt();
        assertEquals(ResultCode.SUCCESS.code(), code);
    }
    @Test
    public void testDistributionCheckGoodsCase3() throws Exception {
        String skuId = "-1"; // 请注意，这里的skuId必须是有效的
        Double commission = 10.0; // 这是一个示例值，你可以根据你的业务逻辑进行相应的调整
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1MDgzMjUwfQ.CJvlTUqaLn5S5krzVWpccL9WPDkoJGihAwdQWyy2fMw"; //这里输入你的accessToken

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put("/store/distribution/goods/checked/" + skuId)
                        .header("accessToken", accessToken)
                        .param("commission", commission.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString();
        // 在这里对结果进行断言
        // 创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();

        // 将JSON字符串解析为JsonNode对象
        JsonNode jsonNode = objectMapper.readTree(result);

        System.out.println(jsonNode);

        // 提取result.code字段的值
        int code = jsonNode.get("code").asInt();
        assertEquals(ResultCode.SUCCESS.code(), code);
    }
    @Test
    public void testDistributionCheckGoodsCase4() throws Exception {
        String skuId = "1390847255409328128"; // 请注意，这里的skuId必须是有效的
        Double commission = 10.0; // 这是一个示例值，你可以根据你的业务逻辑进行相应的调整
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1MDgzMjUwfQ.CJvlTUqaLn5S5krzVWpccL9WPDkoJGihAwdQWyy2fMw"; //这里输入你的accessToken

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put("/store/distribution/goods/checked/" + skuId)
                        .header("accessToken", accessToken)
                        .param("commission", commission.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString();
        // 在这里对结果进行断言
        // 创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();

        // 将JSON字符串解析为JsonNode对象
        JsonNode jsonNode = objectMapper.readTree(result);

        System.out.println(jsonNode);

        // 提取result.code字段的值
        int code = jsonNode.get("code").asInt();
        assertEquals(ResultCode.SUCCESS.code(), code);
    }
    @Test
    public void testDistributionCheckGoodsCase5() throws Exception {
        String skuId = "1390847255409328128"; // 请注意，这里的skuId必须是有效的
        Double commission = -10.0; // 这是一个示例值，你可以根据你的业务逻辑进行相应的调整
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1MDgzMjUwfQ.CJvlTUqaLn5S5krzVWpccL9WPDkoJGihAwdQWyy2fMw"; //这里输入你的accessToken

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put("/store/distribution/goods/checked/" + skuId)
                        .header("accessToken", accessToken)
                        .param("commission", commission.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString();
        // 在这里对结果进行断言
        // 创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();

        // 将JSON字符串解析为JsonNode对象
        JsonNode jsonNode = objectMapper.readTree(result);

        System.out.println(jsonNode);

        // 提取result.code字段的值
        int code = jsonNode.get("code").asInt();
        assertEquals(ResultCode.SUCCESS.code(), code);
    }
}


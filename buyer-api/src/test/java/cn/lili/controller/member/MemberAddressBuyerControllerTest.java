package cn.lili.controller.member;

import cn.lili.modules.goods.entity.dto.GoodsOperationDTO;
import cn.lili.modules.member.entity.dos.MemberAddress;
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

@SpringBootTest
@AutoConfigureMockMvc
public class MemberAddressBuyerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    //添加合法的会员收件地址信息
    public void testAddShippingAddress() throws Exception {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1Mzc2NTMzfQ.EVRAGslYp_XogD_UQRadqj5aLE4gcrBlbXkS60Stnjs"; //这里输入你的accessToken
        // 创建测试数据
        MemberAddress memberAddress = new MemberAddress();
        memberAddress.setMemberId("1376417684140326912");
        memberAddress.setName("李佳怡");
        memberAddress.setMobile("17816139690");
        memberAddress.setConsigneeAddressPath("浙江省,杭州市,西湖区,留下街道");
        memberAddress.setConsigneeAddressIdPath("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116");
        memberAddress.setDetail("浙江工业大学(屏峰校区)浙江工业大学屏峰校区家和西苑10号楼");
        memberAddress.setIsDefault(true);
        memberAddress.setAlias("Home");
        memberAddress.setLon("123.456");
        memberAddress.setLat("78.90");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/buyer/member/address")
                        .header("accessToken", accessToken)
                        .content(JSON.toJSONString(memberAddress))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

    @Test
    //添加IsDefault为null的会员收件地址信息
    public void testAddShippingAddressWithNullIsDefault() throws Exception {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1Mzc2NTMzfQ.EVRAGslYp_XogD_UQRadqj5aLE4gcrBlbXkS60Stnjs"; //这里输入你的accessToken
        // 创建测试数据
        MemberAddress memberAddress = new MemberAddress();
        memberAddress.setMemberId("1376417684140326912");
        memberAddress.setName("李佳怡");
        memberAddress.setMobile("17816139690");
        memberAddress.setConsigneeAddressPath("浙江省,杭州市,西湖区,留下街道");
        memberAddress.setConsigneeAddressIdPath("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116");
        memberAddress.setDetail("IsDefault为null的会员收件地址信息");
        memberAddress.setAlias("学校");
        memberAddress.setLon("123.456");
        memberAddress.setLat("78.90");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/buyer/member/address")
                        .header("accessToken", accessToken)
                        .content(JSON.toJSONString(memberAddress))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

    @Test
    //修改存在的会员收件地址信息
    public void testEditShippingAddress() throws Exception {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1Mzc2NTMzfQ.EVRAGslYp_XogD_UQRadqj5aLE4gcrBlbXkS60Stnjs"; //这里输入你的accessToken
        // 创建测试数据
        MemberAddress memberAddress = new MemberAddress();
        memberAddress.setMemberId("1376417684140326912");
        memberAddress.setName("李佳怡");
        memberAddress.setMobile("17816139690");
        memberAddress.setConsigneeAddressPath("浙江省,杭州市,西湖区,留下街道");
        memberAddress.setConsigneeAddressIdPath("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116");
        memberAddress.setDetail("修改存在的会员收件地址信息");
        memberAddress.setIsDefault(true);
        memberAddress.setAlias("Home");
        memberAddress.setLon("123.456");
        memberAddress.setLat("78.90");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/buyer/member/address")
                        .header("accessToken", accessToken)
                        .content(JSON.toJSONString(memberAddress))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

    @Test
    //修改不存在的会员收件地址信息
    public void testEditShippingAddressNotExist() throws Exception {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1Mzc2NTMzfQ.EVRAGslYp_XogD_UQRadqj5aLE4gcrBlbXkS60Stnjs"; //这里输入你的accessToken
        // 创建测试数据
        MemberAddress memberAddress = new MemberAddress();
        memberAddress.setId("123");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/buyer/member/address")
                        .header("accessToken", accessToken)
                        .content(JSON.toJSONString(memberAddress))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }
}

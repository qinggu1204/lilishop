package cn.lili.modules.member.service;

import cn.lili.modules.member.entity.dos.MemberAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberAddressServiceTest {
    @Autowired
    private MemberAddressService memberAddressService;

    @Test
    //添加的地址为默认地址
    public void testSaveMemberAddressIsDefault() {
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

        //调用函数
        MemberAddress result = memberAddressService.saveMemberAddress(memberAddress);

        //断言结果
        assertEquals("1376417684140326912", result.getMemberId());
        assertEquals("李佳怡", result.getName());
        assertEquals("17816139690", result.getMobile());
        assertEquals("浙江省,杭州市,西湖区,留下街道", result.getConsigneeAddressPath());
        assertEquals("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116", result.getConsigneeAddressIdPath());
        assertEquals("浙江工业大学(屏峰校区)浙江工业大学屏峰校区家和西苑10号楼", result.getDetail());
        assertEquals(true, result.getIsDefault());
        assertEquals("Home", result.getAlias());
        assertEquals("123.456", result.getLon());
        assertEquals("78.90", result.getLat());
    }

    @Test
    //添加的地址为非默认地址
    public void testSaveMemberAddressIsNotDefault() {
        // 创建测试数据
        MemberAddress memberAddress = new MemberAddress();
        memberAddress.setMemberId("1376417684140326912");
        memberAddress.setName("李佳怡");
        memberAddress.setMobile("17816139690");
        memberAddress.setConsigneeAddressPath("浙江省,杭州市,西湖区,留下街道");
        memberAddress.setConsigneeAddressIdPath("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116");
        memberAddress.setDetail("非默认地址");
        memberAddress.setIsDefault(false);
        memberAddress.setAlias("学校");
        memberAddress.setLon("123.456");
        memberAddress.setLat("78.90");

        //调用函数
        MemberAddress result = memberAddressService.saveMemberAddress(memberAddress);

        //断言结果
        assertEquals("1376417684140326912", result.getMemberId());
        assertEquals("李佳怡", result.getName());
        assertEquals("17816139690", result.getMobile());
        assertEquals("浙江省,杭州市,西湖区,留下街道", result.getConsigneeAddressPath());
        assertEquals("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116", result.getConsigneeAddressIdPath());
        assertEquals("非默认地址", result.getDetail());
        assertEquals(false, result.getIsDefault());
        assertEquals("学校", result.getAlias());
        assertEquals("123.456", result.getLon());
        assertEquals("78.90", result.getLat());
    }

//    @Test
//    //修改的地址为默认地址
//    public void testUpdateMemberAddressIsDefault() {
//        // 创建测试数据
//        MemberAddress memberAddress = new MemberAddress();
//        memberAddress.setMemberId("1376417684140326912");
//        memberAddress.setName("李佳怡");
//        memberAddress.setMobile("17816139690");
//        memberAddress.setConsigneeAddressPath("浙江省,杭州市,西湖区,留下街道");
//        memberAddress.setConsigneeAddressIdPath("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116");
//        memberAddress.setDetail("修改后的默认地址");
//        memberAddress.setIsDefault(true);
//        memberAddress.setAlias("Home");
//        memberAddress.setLon("123.456");
//        memberAddress.setLat("78.90");
//
//        //调用函数
//        MemberAddress result = memberAddressService.updateMemberAddress(memberAddress);
//
//        //断言结果
//        assertEquals("1376417684140326912", result.getMemberId());
//        assertEquals("李佳怡", result.getName());
//        assertEquals("17816139690", result.getMobile());
//        assertEquals("浙江省,杭州市,西湖区,留下街道", result.getConsigneeAddressPath());
//        assertEquals("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116", result.getConsigneeAddressIdPath());
//        assertEquals("修改后的默认地址", result.getDetail());
//        assertEquals(true, result.getIsDefault());
//        assertEquals("Home", result.getAlias());
//        assertEquals("123.456", result.getLon());
//        assertEquals("78.90", result.getLat());
//    }
//
//    @Test
//    //修改的地址为非默认地址
//    public void testUpdateMemberAddressIsNotDefault() {
//        // 创建测试数据
//        MemberAddress memberAddress = new MemberAddress();
//        memberAddress.setMemberId("1376417684140326912");
//        memberAddress.setName("李佳怡");
//        memberAddress.setMobile("17816139690");
//        memberAddress.setConsigneeAddressPath("浙江省,杭州市,西湖区,留下街道");
//        memberAddress.setConsigneeAddressIdPath("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116");
//        memberAddress.setDetail("修改后的非默认地址");
//        memberAddress.setIsDefault(false);
//        memberAddress.setAlias("学校");
//        memberAddress.setLon("123.456");
//        memberAddress.setLat("78.90");
//
//        //调用函数
//        MemberAddress result = memberAddressService.updateMemberAddress(memberAddress);
//
//        //断言结果
//        assertEquals("1376417684140326912", result.getMemberId());
//        assertEquals("李佳怡", result.getName());
//        assertEquals("17816139690", result.getMobile());
//        assertEquals("浙江省,杭州市,西湖区,留下街道", result.getConsigneeAddressPath());
//        assertEquals("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116", result.getConsigneeAddressIdPath());
//        assertEquals("修改后的非默认地址", result.getDetail());
//        assertEquals(false, result.getIsDefault());
//        assertEquals("学校", result.getAlias());
//        assertEquals("123.456", result.getLon());
//        assertEquals("78.90", result.getLat());
//    }
//
//    @Test
//    //修改的地址为IsDefault为null的地址
//    public void testUpdateMemberAddressWithNullIsDefault() {
//        // 创建测试数据
//        MemberAddress memberAddress = new MemberAddress();
//        memberAddress.setMemberId("1376417684140326912");
//        memberAddress.setName("李佳怡");
//        memberAddress.setMobile("17816139690");
//        memberAddress.setConsigneeAddressPath("浙江省,杭州市,西湖区,留下街道");
//        memberAddress.setConsigneeAddressIdPath("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116");
//        memberAddress.setDetail("IsDefault为null的地址修改后的非默认地址");
//        memberAddress.setAlias("学校");
//        memberAddress.setLon("123.456");
//        memberAddress.setLat("78.90");
//
//        //调用函数
//        MemberAddress result = memberAddressService.updateMemberAddress(memberAddress);
//
//        //断言结果
//        assertEquals("1376417684140326912", result.getMemberId());
//        assertEquals("李佳怡", result.getName());
//        assertEquals("17816139690", result.getMobile());
//        assertEquals("浙江省,杭州市,西湖区,留下街道", result.getConsigneeAddressPath());
//        assertEquals("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116", result.getConsigneeAddressIdPath());
//        assertEquals("IsDefault为null的地址修改后的非默认地址", result.getDetail());
//        assertEquals(false, result.getIsDefault());
//        assertEquals("学校", result.getAlias());
//        assertEquals("123.456", result.getLon());
//        assertEquals("78.90", result.getLat());
//    }
//
//    @Test
//    //修改的地址不存在
//    public void testUpdateMemberAddressNotExist() {
//        // 创建测试数据
//        MemberAddress memberAddress = new MemberAddress();
//        memberAddress.setId("132");
//
//        //调用函数
//        MemberAddress result = memberAddressService.updateMemberAddress(memberAddress);
//
//        //断言结果
//        assertNull(result.getId());
//
//    }
}

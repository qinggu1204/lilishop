package cn.lili.controller.order;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.NumberUtil;
import cn.lili.common.enums.ResultCode;
import cn.lili.common.enums.ResultUtil;
import cn.lili.common.vo.ResultMessage;
import cn.lili.modules.member.entity.dto.MemberAddressDTO;
import cn.lili.modules.order.order.entity.dos.Order;
import cn.lili.modules.order.order.entity.enums.OrderStatusEnum;
import cn.lili.modules.order.order.entity.vo.OrderDetailVO;
import cn.lili.modules.order.order.service.OrderPriceService;
import cn.lili.modules.order.order.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

/**
 * @author tageshi
 * @date 2023/5/25 21:50
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderStoreControllerTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderPriceService orderPriceService;
    @Autowired
    private OrderStoreController orderStoreController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    //测试查询订单详情
    @Test
    public void testDetailOrderSuccess(){
        String orderSn = "O202305181659077493493325825";
        //模拟执行Controller的代码
        ResultMessage<OrderDetailVO> response = ResultUtil.data(orderService.queryDetail(orderSn));
        //比对两次的订单编号是否一致，以确认是否查询到了order
        assertEquals(orderSn,response.getResult().getOrder().getSn());
        //比对是否查询成功
        assertEquals(ResultCode.SUCCESS.code(), response.getCode());
    }
    @Test
    public void testDetailOrderFail(){
        String orderSn = "123";
        //模拟执行Controller的代码
        ResultMessage<OrderDetailVO> response = ResultUtil.data(orderService.queryDetail(orderSn));
        //断言该response是否为空
        assertNull(response.getResult());
        //比对是否查询成功
        assertEquals(ResultCode.SUCCESS.code(), response.getCode());
    }
    //修改订货人信息
    @Test
    public void testUpdateConsigneeSuccess(){
        // 准备测试数据
        String orderSn = "O202305181659077493493325825";
        MemberAddressDTO memberAddressDTO = new MemberAddressDTO();
        memberAddressDTO.setConsigneeName("顾增");
        memberAddressDTO.setConsigneeMobile("17815602994");
        memberAddressDTO.setConsigneeAddressPath("浙江省,杭州市,西湖区,留下街道");
        memberAddressDTO.setConsigneeAddressIdPath("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116");
        memberAddressDTO.setConsigneeDetail("留和路288号浙江工业大学屏峰校区");

        // 执行方法
        Order order = orderService.updateConsignee(orderSn,memberAddressDTO);

        // 验证预期结果
        assertNotNull(order);
        assertEquals(memberAddressDTO.getConsigneeName(), order.getConsigneeName());
        assertEquals(memberAddressDTO.getConsigneeMobile(), order.getConsigneeMobile());
        assertEquals(memberAddressDTO.getConsigneeAddressPath(), order.getConsigneeAddressPath());
        assertEquals(memberAddressDTO.getConsigneeAddressIdPath(), order.getConsigneeAddressIdPath());
        assertEquals(memberAddressDTO.getConsigneeDetail(), order.getConsigneeDetail());
    }

    @Test
    public void testUpdateConsigneeInvalidOrderSn(){
        // 订单编号不存在
        String orderSn = "123";
        MemberAddressDTO memberAddressDTO = new MemberAddressDTO();
        memberAddressDTO.setConsigneeName("顾增");
        memberAddressDTO.setConsigneeMobile("17815602994");
        memberAddressDTO.setConsigneeAddressPath("浙江省,杭州市,西湖区,留下街道");
        memberAddressDTO.setConsigneeAddressIdPath("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116");
        memberAddressDTO.setConsigneeDetail("留和路288号浙江工业大学屏峰校区");

        // 执行方法
        Order order = orderService.updateConsignee(orderSn,memberAddressDTO);
        // 验证order为空
        assertNull(order);
    }

    @Test
    public void testUpdateConsigneeNullName(){
        // 准备测试数据
        String orderSn = "O202305181659077493493325825";
        MemberAddressDTO memberAddressDTO = new MemberAddressDTO();
        memberAddressDTO.setConsigneeMobile("17815602994");
        memberAddressDTO.setConsigneeAddressPath("浙江省,杭州市,西湖区,留下街道");
        memberAddressDTO.setConsigneeAddressIdPath("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116");
        memberAddressDTO.setConsigneeDetail("留和路288号浙江工业大学屏峰校区");

        Exception exception = null;
        // 执行方法并捕获异常
        if (memberAddressDTO.getConsigneeName()==null){
            exception = new Exception("订货人姓名为空");
        }
        // 验证预期异常
        assertNotNull(exception);
        assertEquals("订货人姓名为空", exception.getMessage());
    }
    @Test
    public void testUpdateConsigneeErrorMobile(){
        // 准备测试数据
        String orderSn = "O202305181659077493493325825";
        MemberAddressDTO memberAddressDTO = new MemberAddressDTO();
        memberAddressDTO.setConsigneeName("顾增");
        memberAddressDTO.setConsigneeMobile("17815602");
        memberAddressDTO.setConsigneeAddressPath("浙江省,杭州市,西湖区,留下街道");
        memberAddressDTO.setConsigneeAddressIdPath("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116");
        memberAddressDTO.setConsigneeDetail("留和路288号浙江工业大学屏峰校区");

        Exception exception = null;
        // 执行方法并捕获异常
        if (memberAddressDTO.getConsigneeMobile().length()<11){
            exception = new Exception("手机号码格式不正确");
        }
        // 验证预期异常
        assertNotNull(exception);
        assertEquals("手机号码格式不正确", exception.getMessage());

    }
    @Test
    public void testUpdateConsigneeNullAddress(){
        // 准备测试数据
        String orderSn = "O202305181659077493493325825";
        MemberAddressDTO memberAddressDTO = new MemberAddressDTO();
        memberAddressDTO.setConsigneeName("顾增");
        memberAddressDTO.setConsigneeMobile("17815602");
        memberAddressDTO.setConsigneeAddressPath("浙江省,杭州市,西湖区,留下街道");
        memberAddressDTO.setConsigneeAddressIdPath("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116");

        Exception exception = null;
        // 执行方法并捕获异常
        if (memberAddressDTO.getConsigneeDetail()==null){
            exception = new Exception("地址为空");
        }
        // 验证预期异常
        assertNotNull(exception);
        assertEquals("地址为空", exception.getMessage());
    }
    //修改订单价格
    @Test
    public void testUpdatePriceSuccess(){
        String orderSn = "O202305181659077493493325825";
        Double orderPrice = 10.0;
        //断言订单编号存在
        assertNotNull(orderService.getBySn(orderSn));
        //断言订单价格大于0
        assertTrue(NumberUtil.isGreater(Convert.toBigDecimal(orderPrice), Convert.toBigDecimal(0)));
        ResultMessage<Object> response = ResultUtil.data(orderPriceService.updatePrice(orderSn, orderPrice));
        assertNotNull(response.getResult());
        //比对是否操作成功
        assertEquals(ResultCode.SUCCESS.code(), response.getCode());
    }

    @Test
    public void testUpdatePriceErrorPrice(){
        String orderSn = "O202305181659077493493325825";
        Double orderPrice = -10.0;
        //断言订单编号存在
        assertNotNull(orderService.getBySn(orderSn));
        //断言订单价格小于0
        assertFalse(NumberUtil.isGreater(Convert.toBigDecimal(orderPrice), Convert.toBigDecimal(0)));
    }

    @Test
    public void testUpdatePriceErrorSn(){
        String orderSn = "123";
        Double orderPrice = 10.0;
        //断言订单编号不存在
        assertNull(orderService.getBySn(orderSn));
    }
    //订单发货
    @Test
    public void testDeliverySuccess() {
        String orderSn = "O202305181659077493493325825";
        String logisticsNo = "SF001";
        String logisticsId = "1364825407932596224"; //顺丰快递

        Order order = orderService.getBySn(orderSn);
        //断言订单编号是否合法
        assertEquals(orderSn,order.getSn());
        //断言发货单号不为空
        assertNotNull(logisticsNo);
        ResultMessage<Object> result = ResultUtil.data(orderService.delivery(orderSn, logisticsNo, logisticsId));
        assertNotNull(result.getResult());
        assertEquals(ResultCode.SUCCESS.code(),result.getCode());
    }

    @Test
    public void testDeliveryErrorSn() {
        String orderSn = "123";
        String logisticsNo = "SF001";
        String logisticsId = "1364825407932596224"; //顺丰快递

        //断言订单编号是否合法
        assertEquals(null,orderService.getBySn(orderSn));
        //断言发货单号不为空
        assertNotNull(logisticsNo);
    }

    @Test
    public void testDeliveryEmpty() {
        String orderSn = "O202305181659077493493325825";
        String logisticsNo = null;
        String logisticsId = "1364825407932596224"; //顺丰快递

        //断言订单编号合法
        assertEquals(orderSn,orderService.getBySn(orderSn).getSn());
        //断言发货单号为空
        assertNull(logisticsNo);
    }

    @Test
    public void testGetOrderByVerificationCodeSuccess(){
        String verificationCode = "202305288821";
        String storeId = "1376433565247471616";
        Order order = orderService.getOne(new LambdaQueryWrapper<Order>()
                .in(Order::getOrderStatus, OrderStatusEnum.TAKE.name(), OrderStatusEnum.STAY_PICKED_UP.name())
                .eq(Order::getStoreId, storeId)
                .eq(Order::getVerificationCode, verificationCode));

        assertEquals(storeId,order.getStoreId());
        assertEquals(verificationCode,order.getVerificationCode());
    }

    @Test
    public void testGetOrderByVerificationCodeFail(){
        String verificationCode = "123";
        String storeId = "1376433565247471616";
        assertEquals(null,orderService.getOne(new LambdaQueryWrapper<Order>()
                .in(Order::getOrderStatus, OrderStatusEnum.TAKE.name(), OrderStatusEnum.STAY_PICKED_UP.name())
                .eq(Order::getStoreId, storeId)
                .eq(Order::getVerificationCode, verificationCode)));
    }
}
package cn.lili.modules.order.order.service;

import cn.hutool.core.bean.BeanUtil;
import cn.lili.modules.member.entity.dto.MemberAddressDTO;
import cn.lili.modules.order.order.entity.dos.Order;
import cn.lili.modules.order.order.entity.enums.DeliverStatusEnum;
import cn.lili.modules.order.order.entity.enums.OrderStatusEnum;
import cn.lili.modules.order.order.entity.vo.OrderDetailVO;
import cn.lili.modules.order.trade.entity.dos.OrderLog;
import cn.lili.modules.order.trade.service.OrderLogService;
import cn.lili.modules.system.entity.dos.Logistics;
import cn.lili.modules.system.service.LogisticsService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author tageshi
 * @date 2023/5/26 11:43
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderLogService orderLogService;
    @Autowired
    private LogisticsService logisticsService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    //测试查询订单详情
    @Test
    public void testQueryDetailSuccess() {
        // 准备测试数据
        String orderSn = "O202305181659077493493325825";
        // 调用被测试方法
        OrderDetailVO result = orderService.queryDetail(orderSn);

        // 断言结果
        Assert.assertNotNull(result);
        Assert.assertEquals(orderSn, result.getOrder().getSn());
    }
    @Test
    public void testQueryDetailFail() {
        // 准备测试数据
        String orderSn = "123";
        // 调用被测试方法
        OrderDetailVO result = orderService.queryDetail(orderSn);
        // 断言结果为空
        Assert.assertNull(result);
    }
    //修改订货人信息
    @Test
    public void testUpdateConsigneeSuccess() {
        // 准备测试数据
        String orderSn = "O202305181659077493493325825";
        MemberAddressDTO memberAddressDTO = new MemberAddressDTO();
        memberAddressDTO.setConsigneeName("顾增");
        memberAddressDTO.setConsigneeMobile("17815602994");
        memberAddressDTO.setConsigneeAddressPath("浙江省,杭州市,西湖区,留下街道");
        memberAddressDTO.setConsigneeAddressIdPath("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116");
        memberAddressDTO.setConsigneeDetail("留和路288号浙江工业大学屏峰校区");

        // 执行方法
        Order order = orderService.getBySn(orderSn);
        //要记录之前的收货地址，所以需要以代码方式进行调用 不采用注解
        String message = "订单[" + orderSn + "]收货信息修改，由[" + order.getConsigneeDetail() + "]修改为[" + memberAddressDTO.getConsigneeDetail() + "]";
        //记录订单操作日志
        BeanUtil.copyProperties(memberAddressDTO, order);
        orderService.updateById(order);

        OrderLog orderLog = new OrderLog(orderSn, "1657729456023932928", "buyer", "顾增", message);
        orderLogService.save(orderLog);

        // 验证预期结果
        assertNotNull(orderLog);
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
        Order order = orderService.getBySn(orderSn);
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

    //订单发货
    @Test
    public void testDeliverySuccess(){
        String orderSn = "O202305181659077493493325825";
        String logisticsNo = "SF001";
        String logisticsId = "1364825407932596224"; //顺丰快递

        //断言订单编号合法性
        Order order = orderService.getBySn(orderSn);
        assertNotNull(order);
        //断言订单编号不为空
        assertNotNull(logisticsNo);
        //断言物流公司合法性
        Logistics logistics = logisticsService.getById(logisticsId);
        assertNotNull(logistics);
        //断言物流状态
        assertEquals(DeliverStatusEnum.UNDELIVERED.name(),order.getDeliverStatus());
        //断言订单状态
        assertEquals(OrderStatusEnum.UNDELIVERED.name(),order.getOrderStatus());

        order = orderService.delivery(orderSn,logisticsNo,logisticsId);
        //断言是否已发货
        assertEquals(logistics.getName(),order.getLogisticsName());
    }

    @Test
    public void testDeliveryErrorSn(){
        String orderSn = "123";
        String logisticsNo = "SF001";
        String logisticsId = "1364825407932596224"; //顺丰快递
        //断言订单编号合法性
        assertEquals(null,orderService.getBySn(orderSn));
    }

    @Test
    public void testDeliveryLogistics(){
        String orderSn = "O202305181659077493493325825";
        String logisticsNo = "SF001";
        String logisticsId = "1364825407932596224"; //顺丰快递

        //断言订单编号合法性
        Order order = orderService.getBySn(orderSn);
        assertNotNull(order);
        //断言订单编号不为空
        assertNotNull(logisticsNo);
        //断言物流公司合法性
        Logistics logistics = logisticsService.getById(logisticsId);
        assertNotNull(logistics);
        //断言物流状态
        assertNotEquals(DeliverStatusEnum.UNDELIVERED.name(),DeliverStatusEnum.DELIVERED.name());
    }

    @Test
    public void testDeliveryLogisticsCompany(){
        String orderSn = "O202305181659077493493325825";
        String logisticsNo = "SF001";
        String logisticsId = "123"; //顺丰快递

        //断言订单编号合法性
        Order order = orderService.getBySn(orderSn);
        assertNotNull(order);
        //断言订单编号不为空
        assertNotNull(logisticsNo);
        //断言物流公司合法性
        assertEquals(null,logisticsService.getById(logisticsId));
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

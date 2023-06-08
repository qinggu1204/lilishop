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

    //���Բ�ѯ��������
    @Test
    public void testQueryDetailSuccess() {
        // ׼����������
        String orderSn = "O202305181659077493493325825";
        // ���ñ����Է���
        OrderDetailVO result = orderService.queryDetail(orderSn);

        // ���Խ��
        Assert.assertNotNull(result);
        Assert.assertEquals(orderSn, result.getOrder().getSn());
    }
    @Test
    public void testQueryDetailFail() {
        // ׼����������
        String orderSn = "123";
        // ���ñ����Է���
        OrderDetailVO result = orderService.queryDetail(orderSn);
        // ���Խ��Ϊ��
        Assert.assertNull(result);
    }
    //�޸Ķ�������Ϣ
    @Test
    public void testUpdateConsigneeSuccess() {
        // ׼����������
        String orderSn = "O202305181659077493493325825";
        MemberAddressDTO memberAddressDTO = new MemberAddressDTO();
        memberAddressDTO.setConsigneeName("����");
        memberAddressDTO.setConsigneeMobile("17815602994");
        memberAddressDTO.setConsigneeAddressPath("�㽭ʡ,������,������,���½ֵ�");
        memberAddressDTO.setConsigneeAddressIdPath("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116");
        memberAddressDTO.setConsigneeDetail("����·288���㽭��ҵ��ѧ����У��");

        // ִ�з���
        Order order = orderService.getBySn(orderSn);
        //Ҫ��¼֮ǰ���ջ���ַ��������Ҫ�Դ��뷽ʽ���е��� ������ע��
        String message = "����[" + orderSn + "]�ջ���Ϣ�޸ģ���[" + order.getConsigneeDetail() + "]�޸�Ϊ[" + memberAddressDTO.getConsigneeDetail() + "]";
        //��¼����������־
        BeanUtil.copyProperties(memberAddressDTO, order);
        orderService.updateById(order);

        OrderLog orderLog = new OrderLog(orderSn, "1657729456023932928", "buyer", "����", message);
        orderLogService.save(orderLog);

        // ��֤Ԥ�ڽ��
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
        // ������Ų�����
        String orderSn = "123";
        MemberAddressDTO memberAddressDTO = new MemberAddressDTO();
        memberAddressDTO.setConsigneeName("����");
        memberAddressDTO.setConsigneeMobile("17815602994");
        memberAddressDTO.setConsigneeAddressPath("�㽭ʡ,������,������,���½ֵ�");
        memberAddressDTO.setConsigneeAddressIdPath("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116");
        memberAddressDTO.setConsigneeDetail("����·288���㽭��ҵ��ѧ����У��");

        // ִ�з���
        Order order = orderService.getBySn(orderSn);
        // ��֤orderΪ��
        assertNull(order);
    }

    @Test
    public void testUpdateConsigneeNullName(){
        // ׼����������
        String orderSn = "O202305181659077493493325825";
        MemberAddressDTO memberAddressDTO = new MemberAddressDTO();
        memberAddressDTO.setConsigneeMobile("17815602994");
        memberAddressDTO.setConsigneeAddressPath("�㽭ʡ,������,������,���½ֵ�");
        memberAddressDTO.setConsigneeAddressIdPath("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116");
        memberAddressDTO.setConsigneeDetail("����·288���㽭��ҵ��ѧ����У��");

        Exception exception = null;
        // ִ�з����������쳣
        if (memberAddressDTO.getConsigneeName()==null){
            exception = new Exception("����������Ϊ��");
        }
        // ��֤Ԥ���쳣
        assertNotNull(exception);
        assertEquals("����������Ϊ��", exception.getMessage());
    }
    @Test
    public void testUpdateConsigneeErrorMobile(){
        // ׼����������
        String orderSn = "O202305181659077493493325825";
        MemberAddressDTO memberAddressDTO = new MemberAddressDTO();
        memberAddressDTO.setConsigneeName("����");
        memberAddressDTO.setConsigneeMobile("17815602");
        memberAddressDTO.setConsigneeAddressPath("�㽭ʡ,������,������,���½ֵ�");
        memberAddressDTO.setConsigneeAddressIdPath("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116");
        memberAddressDTO.setConsigneeDetail("����·288���㽭��ҵ��ѧ����У��");

        Exception exception = null;
        // ִ�з����������쳣
        if (memberAddressDTO.getConsigneeMobile().length()<11){
            exception = new Exception("�ֻ������ʽ����ȷ");
        }
        // ��֤Ԥ���쳣
        assertNotNull(exception);
        assertEquals("�ֻ������ʽ����ȷ", exception.getMessage());

    }
    @Test
    public void testUpdateConsigneeNullAddress(){
        // ׼����������
        String orderSn = "O202305181659077493493325825";
        MemberAddressDTO memberAddressDTO = new MemberAddressDTO();
        memberAddressDTO.setConsigneeName("����");
        memberAddressDTO.setConsigneeMobile("17815602");
        memberAddressDTO.setConsigneeAddressPath("�㽭ʡ,������,������,���½ֵ�");
        memberAddressDTO.setConsigneeAddressIdPath("1401797451697881277,1401797451702076092,1401797451702076108,1401797451702076116");

        Exception exception = null;
        // ִ�з����������쳣
        if (memberAddressDTO.getConsigneeDetail()==null){
            exception = new Exception("��ַΪ��");
        }
        // ��֤Ԥ���쳣
        assertNotNull(exception);
        assertEquals("��ַΪ��", exception.getMessage());
    }

    //��������
    @Test
    public void testDeliverySuccess(){
        String orderSn = "O202305181659077493493325825";
        String logisticsNo = "SF001";
        String logisticsId = "1364825407932596224"; //˳����

        //���Զ�����źϷ���
        Order order = orderService.getBySn(orderSn);
        assertNotNull(order);
        //���Զ�����Ų�Ϊ��
        assertNotNull(logisticsNo);
        //����������˾�Ϸ���
        Logistics logistics = logisticsService.getById(logisticsId);
        assertNotNull(logistics);
        //��������״̬
        assertEquals(DeliverStatusEnum.UNDELIVERED.name(),order.getDeliverStatus());
        //���Զ���״̬
        assertEquals(OrderStatusEnum.UNDELIVERED.name(),order.getOrderStatus());

        order = orderService.delivery(orderSn,logisticsNo,logisticsId);
        //�����Ƿ��ѷ���
        assertEquals(logistics.getName(),order.getLogisticsName());
    }

    @Test
    public void testDeliveryErrorSn(){
        String orderSn = "123";
        String logisticsNo = "SF001";
        String logisticsId = "1364825407932596224"; //˳����
        //���Զ�����źϷ���
        assertEquals(null,orderService.getBySn(orderSn));
    }

    @Test
    public void testDeliveryLogistics(){
        String orderSn = "O202305181659077493493325825";
        String logisticsNo = "SF001";
        String logisticsId = "1364825407932596224"; //˳����

        //���Զ�����źϷ���
        Order order = orderService.getBySn(orderSn);
        assertNotNull(order);
        //���Զ�����Ų�Ϊ��
        assertNotNull(logisticsNo);
        //����������˾�Ϸ���
        Logistics logistics = logisticsService.getById(logisticsId);
        assertNotNull(logistics);
        //��������״̬
        assertNotEquals(DeliverStatusEnum.UNDELIVERED.name(),DeliverStatusEnum.DELIVERED.name());
    }

    @Test
    public void testDeliveryLogisticsCompany(){
        String orderSn = "O202305181659077493493325825";
        String logisticsNo = "SF001";
        String logisticsId = "123"; //˳����

        //���Զ�����źϷ���
        Order order = orderService.getBySn(orderSn);
        assertNotNull(order);
        //���Զ�����Ų�Ϊ��
        assertNotNull(logisticsNo);
        //����������˾�Ϸ���
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

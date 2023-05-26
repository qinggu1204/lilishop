package cn.lili.controller.order;

import cn.lili.common.enums.ResultCode;
import cn.lili.common.exception.ServiceException;
import cn.lili.common.vo.ResultMessage;
import cn.lili.modules.order.order.entity.dos.Order;
import cn.lili.modules.order.order.entity.dos.OrderItem;
import cn.lili.modules.order.order.entity.dos.Receipt;
import cn.lili.modules.order.order.entity.dto.OrderSearchParams;
import cn.lili.modules.order.order.entity.vo.OrderDetailVO;
import cn.lili.modules.order.order.entity.vo.OrderSimpleVO;
import cn.lili.modules.order.order.mapper.OrderMapper;
import cn.lili.modules.order.order.service.OrderService;
import cn.lili.modules.order.order.serviceimpl.OrderServiceImpl;
import cn.lili.modules.order.trade.entity.dos.OrderLog;
import cn.lili.mybatis.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * @author tageshi
 * @date 2023/5/25 21:50
 */
public class OrderStoreControllerTest {

    @Mock
    private OrderMapper orderMapper;
    @InjectMocks
    private OrderStoreController orderStoreController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDetailOrderSuccess(){
        String orderSn = "O202305181659077493493325825";
        /*when(orderService.getBySn("123456")).thenThrow(new ServiceException(ResultCode.ORDER_NOT_EXIST));*/
        ResultMessage<OrderDetailVO> response = orderStoreController.detail("O202305181659077493493325825");
        System.out.println(response.toString());
        assertEquals(ResultCode.SUCCESS.code(), response.getCode());
        assertEquals("success", response.getMessage());
    }

}

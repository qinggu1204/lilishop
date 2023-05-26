package cn.lili.modules.order.order.mapper;

import cn.lili.modules.order.order.entity.vo.OrderSimpleVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testOrderMapper {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testQueryByParams() {
        /*Assertions.assertEquals(1,1+0);*/
        // 创建一个分页对象
        Page<OrderSimpleVO> page = new Page<>(1, 10);

        // 创建一个查询条件的 Wrapper 对象
        QueryWrapper<OrderSimpleVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("member_name", "josephgu");

        // 调用接口方法进行查询
        IPage<OrderSimpleVO> result = orderMapper.queryByParams(page, queryWrapper);

        // 验证返回结果是否为空
        Assertions.assertNotNull(result);

        // 验证分页信息是否正确
        Assertions.assertEquals(1, result.getCurrent());
        Assertions.assertEquals(10, result.getSize());

        // 验证查询结果列表是否为空
        Assertions.assertFalse(result.getRecords().isEmpty());

        // 遍历打印订单信息
        for (OrderSimpleVO order : result.getRecords()) {
            System.out.println("Order SN: " + order.getSn());
            System.out.println("Flow Price: " + order.getFlowPrice());
            System.out.println("Create Time: " + order.getCreateTime());
            // 其他属性类似，根据需要进行验证和打印
        }
    }
}

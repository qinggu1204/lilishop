package lili.controller.member;

import cn.lili.controller.member.MemberEvaluationBuyerController;
import cn.lili.modules.member.entity.dto.EvaluationQueryParams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberEvaluationBuyerControllerTest {
    @Autowired
    private MemberEvaluationBuyerController memberEvaluationBuyerController;

    /**
     * 测试正常流程
     */
    @Test
    void queryGoodsEvaluationTest1() {
        EvaluationQueryParams evaluationQueryParams = new EvaluationQueryParams();
        String goodsId = "test";
        memberEvaluationBuyerController.queryGoodsEvaluation(evaluationQueryParams, goodsId);
        Assertions.assertTrue(true);
    }

    /**
     * 测试null流程
     */
    @Test
    void queryGoodsEvaluationTest2() {
        EvaluationQueryParams evaluationQueryParams = null;
        String goodsId = "test";
        memberEvaluationBuyerController.queryGoodsEvaluation(evaluationQueryParams, goodsId);
        Assertions.assertTrue(true);
    }

    @Test
    void queryGoodsEvaluationTest3() {
        EvaluationQueryParams evaluationQueryParams = new EvaluationQueryParams();
        String goodsId = null;
        memberEvaluationBuyerController.queryGoodsEvaluation(evaluationQueryParams, goodsId);
        Assertions.assertTrue(true);
    }

    @Test
    void queryGoodsEvaluationTest4() {
        EvaluationQueryParams evaluationQueryParams = null;
        String goodsId = null;
        memberEvaluationBuyerController.queryGoodsEvaluation(evaluationQueryParams, goodsId);
        Assertions.assertTrue(true);
    }

    @Test
    void queryGoodsEvaluationTest5() {
        EvaluationQueryParams evaluationQueryParams = null;
        String goodsId = "";
        memberEvaluationBuyerController.queryGoodsEvaluation(evaluationQueryParams, goodsId);
        Assertions.assertTrue(true);
    }
}
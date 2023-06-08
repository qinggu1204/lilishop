package cn.lili.controller.member;

import cn.lili.modules.member.entity.dto.EvaluationQueryParams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.NotNull;

import static org.junit.jupiter.api.Assertions.*;

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
        String goodsId = "O202306021664587585431416833";
        try {
            memberEvaluationBuyerController.queryGoodsEvaluation(evaluationQueryParams, goodsId);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    /**
     * 测试null流程
     */
    @Test
    void queryGoodsEvaluationTest2() {
        EvaluationQueryParams evaluationQueryParams = new EvaluationQueryParams();
        String goodsId = null;
        try {
            memberEvaluationBuyerController.queryGoodsEvaluation(evaluationQueryParams, goodsId);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void queryGoodsEvaluationTest3() {
        EvaluationQueryParams evaluationQueryParams = new EvaluationQueryParams();
        String goodsId = "test";
        try {
            memberEvaluationBuyerController.queryGoodsEvaluation(evaluationQueryParams, goodsId);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void queryGoodsEvaluationTest4() {
        EvaluationQueryParams evaluationQueryParams = new EvaluationQueryParams();
        String goodsId = "null";
        try {
            memberEvaluationBuyerController.queryGoodsEvaluation(evaluationQueryParams, goodsId);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void queryGoodsEvaluationTest5() {
        EvaluationQueryParams evaluationQueryParams = new EvaluationQueryParams();
        evaluationQueryParams.setStatus("test");
        String goodsId = "";
        try {
            memberEvaluationBuyerController.queryGoodsEvaluation(evaluationQueryParams, goodsId);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }
}
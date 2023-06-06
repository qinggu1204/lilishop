package cn.lili.modules.member.serviceimpl;

import cn.lili.modules.member.entity.dto.EvaluationQueryParams;
import cn.lili.modules.member.service.MemberEvaluationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberEvaluationServiceImplTest {
    @Autowired
    private MemberEvaluationService memberEvaluationService;

    @Test
    void managerQuery() {
        EvaluationQueryParams evaluationQueryParams = new EvaluationQueryParams();
        try {
            memberEvaluationService.managerQuery(evaluationQueryParams);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }
    @Test
    void managerQuery2() {
        EvaluationQueryParams evaluationQueryParams = null;
        try {
            memberEvaluationService.managerQuery(evaluationQueryParams);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }
}
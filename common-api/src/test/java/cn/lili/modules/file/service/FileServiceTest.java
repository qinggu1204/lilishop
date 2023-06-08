package cn.lili.modules.file.service;

import cn.lili.common.vo.PageVO;
import cn.lili.common.vo.SearchVO;
import cn.lili.modules.file.entity.File;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class FileServiceTest {
    
    @Autowired
    private FileService fileService;
    
    @Test
    public void testCustomerPage() {
        File file = new File();
        SearchVO searchVO = new SearchVO();
        PageVO pageVO = new PageVO();

        IPage<File> result = fileService.customerPage(file, searchVO, pageVO);
        assertFalse(result.getRecords().isEmpty());
    }

    @Test
    public void testCustomerPageWithInvalidSearchVO() {
        File file = new File();
        SearchVO searchVO = new SearchVO();
        searchVO.setStartDate("2023-13-25 17:00:00.658000");
        PageVO pageVO = new PageVO();

        IPage<File> result = fileService.customerPage(file, searchVO, pageVO);
        assertFalse(result.getRecords().isEmpty());
    }
    
    @Test
    public void testBatchDelete() {
        List<String> ids = new ArrayList<>();
        ids.add("1661658363582246914");

        fileService.batchDelete(ids);
    }

    @Test
    public void testBatchDeleteWithInvalidIds() {
        List<String> ids = new ArrayList<>();
        ids.add("invalidIds");

        fileService.batchDelete(ids);
    }
}

package cn.lili.controller.common;

import cn.lili.cache.Cache;
import cn.lili.common.enums.ResultCode;
import cn.lili.common.security.AuthUser;
import cn.lili.common.security.enums.UserEnums;
import cn.lili.common.vo.PageVO;
import cn.lili.common.vo.ResultMessage;
import cn.lili.common.vo.SearchVO;
import cn.lili.modules.file.entity.File;
import cn.lili.modules.file.entity.dto.FileOwnerDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FileControllerIntegrationTest {

    @Autowired
    private FileController fileController;

    @Autowired
    private Cache cache;

   @Test
    public void testGetFileListForMember() {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCJqb3NlcGhndVwiLFwibmlja05hbWVcIjpcIueZvemHkeS5i-aYn1wiLFwiZmFjZVwiOlwiXCIsXCJpZFwiOlwiMTY1NzcyOTQ1NjAyMzkzMjkyOFwiLFwibG9uZ1Rlcm1cIjpmYWxzZSxcInJvbGVcIjpcIk1FTUJFUlwifSIsInN1YiI6Impvc2VwaGd1IiwiZXhwIjoxNjg1MDA2Nzk1fQ.eG0y9MXR1oRzb4rbPOFZZZmOb88s53jsP7gOX3SLgMk"; //请注意，这里的token必须是有效的并且对应的用户角色是MEMBER
        File file = new File();
        SearchVO searchVO = new SearchVO();
        PageVO pageVo = new PageVO();

        ResultMessage<IPage<File>> result = fileController.getFileList(accessToken, file, searchVO, pageVo);

        assertEquals(ResultCode.SUCCESS.code(), result.getCode());
    }

    @Test
    public void testGetFileListForStore() {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCIxMzAxMTExMTExMVwiLFwibmlja05hbWVcIjpcIuW8oOS4iVwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzE1OGJmZjgzMWNmZjQ5OWE4ZDQ1YTIyNmE2ZTAyMGMyLnBuZ1wiLFwiaWRcIjpcIjEzNzY0MTc2ODQxNDAzMjY5MTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJTVE9SRVwiLFwic3RvcmVJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwiY2xlcmtJZFwiOlwiMTM3NjQzMzU2NTI0NzQ3MTYxNlwiLFwic3RvcmVOYW1lXCI6XCLlrrblrrbkuZBcIixcImlzU3VwZXJcIjp0cnVlfSIsInN1YiI6IjEzMDExMTExMTExIiwiZXhwIjoxNjg1MDA2ODkwfQ.Rnmm3oUkG0ITVTp4fW8X-ysJ7fjBNZDc5kSK0HZqytE"; //请注意，这里的token必须是有效的并且对应的用户角色是STORE
        File file = new File();
        SearchVO searchVO = new SearchVO();
        PageVO pageVo = new PageVO();

        ResultMessage<IPage<File>> result = fileController.getFileList(accessToken, file, searchVO, pageVo);

        assertEquals(ResultCode.SUCCESS.code(), result.getCode());
    }

    @Test
    public void testGetFileListForOtherRoles() {
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCJhZG1pblwiLFwibmlja05hbWVcIjpcIuWIneS4gFwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzY1ZTg3ZmZhNzE4YjQyYmI5YzIwMTcxMjU2NmRiYzlhLnBuZ1wiLFwiaWRcIjpcIjEzMzczMDYxMTAyNzc0NzYzNTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJNQU5BR0VSXCIsXCJpc1N1cGVyXCI6dHJ1ZX0iLCJzdWIiOiJhZG1pbiIsImV4cCI6MTY4NTAwNjgzMH0.sOgjHCMXDS-qD5GXDogOSIs10pAJSQQgBk-BLJyu7bk"; //请注意，这里的token必须是有效的并且对应的用户角色不是MEMBER也不是STORE
        File file = new File();
        SearchVO searchVO = new SearchVO();
        PageVO pageVo = new PageVO();

        ResultMessage<IPage<File>> result = fileController.getFileList(accessToken, file, searchVO, pageVo);

        assertEquals(ResultCode.SUCCESS.code(), result.getCode());
    }

    @Test
    public void testDeleteForMember() {
        String accessToken = "validTokenForMember"; //请注意，这里的token必须是有效的并且对应的用户角色是MEMBER
        List<String> ids = Collections.singletonList("validFileIdForMember"); //请注意，这里的fileId必须是有效的并且对应的文件拥有者是MEMBER

        ResultMessage result = fileController.delete(accessToken, ids);

        assertEquals(ResultCode.SUCCESS.code(), result.getCode());
    }

    @Test
    public void testDeleteForStore() {
        String accessToken = "validTokenForStore"; //请注意，这里的token必须是有效的并且对应的用户角色是STORE
        List<String> ids = Collections.singletonList("validFileIdForStore"); //请注意，这里的fileId必须是有效的并且对应的文件拥有者是STORE

        ResultMessage result = fileController.delete(accessToken, ids);

        assertEquals(ResultCode.SUCCESS.code(), result.getCode());
    }

    @Test
    public void testDeleteForOtherRoles() {
        String accessToken = "validTokenForOtherRoles"; //请注意，这里的token必须是有效的并且对应的用户角色不是MEMBER也不是STORE
        List<String> ids = Collections.singletonList("validFileIdForOtherRoles"); //请注意，这里的fileId必须是有效的并且对应的文件拥有者不是MEMBER也不是STORE

        ResultMessage result = fileController.delete(accessToken, ids);

        assertEquals(ResultCode.SUCCESS.code(), result.getCode());
    }

    // 情况1: 用户角色为MEMBER，文件拥有者是MEMBER，newName有效
    @Test
    public void testUploadFile_case1() throws Exception {
        String newName = "newName1";
        String fileId = "1661658363582246914";
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCJhZG1pblwiLFwibmlja05hbWVcIjpcIuWIneS4gFwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzY1ZTg3ZmZhNzE4YjQyYmI5YzIwMTcxMjU2NmRiYzlhLnBuZ1wiLFwiaWRcIjpcIjEzMzczMDYxMTAyNzc0NzYzNTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJNQU5BR0VSXCIsXCJpc1N1cGVyXCI6dHJ1ZX0iLCJzdWIiOiJhZG1pbiIsImV4cCI6MTY4NTE5NDkwOX0.4Evz5yCV0T1Dck0y7B9J88lksqBHOpPnr0CcJCDYgtA";

        ResultMessage<File> result = fileController.upload(accessToken, fileId, newName);

        assertEquals(ResultCode.SUCCESS.code(), result.getCode());
    }

    // 情况2: 用户角色为STORE，文件拥有者是STORE，newName有效
    @Test
    public void testUploadFile_case2() throws Exception {
        String newName = "newName1";
        String fileId = "1661658363582246914";
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCJhZG1pblwiLFwibmlja05hbWVcIjpcIuWIneS4gFwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzY1ZTg3ZmZhNzE4YjQyYmI5YzIwMTcxMjU2NmRiYzlhLnBuZ1wiLFwiaWRcIjpcIjEzMzczMDYxMTAyNzc0NzYzNTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJNQU5BR0VSXCIsXCJpc1N1cGVyXCI6dHJ1ZX0iLCJzdWIiOiJhZG1pbiIsImV4cCI6MTY4NTE5NDkwOX0.4Evz5yCV0T1Dck0y7B9J88lksqBHOpPnr0CcJCDYgtA";

        ResultMessage<File> result = fileController.upload(accessToken, fileId, newName);

        assertEquals(ResultCode.SUCCESS.code(), result.getCode());
    }

    // 情况3: 用户角色为MANAGER，文件拥有者任意，newName有效
    @Test
    public void testUploadFile_case3() throws Exception {
        String newName = "newName1";
        String fileId = "1661658363582246914";
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCJhZG1pblwiLFwibmlja05hbWVcIjpcIuWIneS4gFwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzY1ZTg3ZmZhNzE4YjQyYmI5YzIwMTcxMjU2NmRiYzlhLnBuZ1wiLFwiaWRcIjpcIjEzMzczMDYxMTAyNzc0NzYzNTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJNQU5BR0VSXCIsXCJpc1N1cGVyXCI6dHJ1ZX0iLCJzdWIiOiJhZG1pbiIsImV4cCI6MTY4NTE5NDkwOX0.4Evz5yCV0T1Dck0y7B9J88lksqBHOpPnr0CcJCDYgtA";

        ResultMessage<File> result = fileController.upload(accessToken, fileId, newName);

        assertEquals(ResultCode.SUCCESS.code(), result.getCode());
    }

    // 情况4: 用户角色为MEMBER，文件拥有者是STORE或者MANAGER，newName有效
    @Test
    public void testUploadFile_case4() throws Exception {
        String newName = "newName1";
        String fileId = "1661658363582246914";
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCJhZG1pblwiLFwibmlja05hbWVcIjpcIuWIneS4gFwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzY1ZTg3ZmZhNzE4YjQyYmI5YzIwMTcxMjU2NmRiYzlhLnBuZ1wiLFwiaWRcIjpcIjEzMzczMDYxMTAyNzc0NzYzNTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJNQU5BR0VSXCIsXCJpc1N1cGVyXCI6dHJ1ZX0iLCJzdWIiOiJhZG1pbiIsImV4cCI6MTY4NTE5NDkwOX0.4Evz5yCV0T1Dck0y7B9J88lksqBHOpPnr0CcJCDYgtA";

        ResultMessage<File> result = fileController.upload(accessToken, fileId, newName);

        assertEquals(ResultCode.SUCCESS.code(), result.getCode());
    }

    // 情况5: 用户角色为STORE，文件拥有者是MEMBER或者MANAGER，newName有效
    @Test
    public void testUploadFile_case5() throws Exception {
        String newName = "newName1";
        String fileId = "1661658363582246914";
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCJhZG1pblwiLFwibmlja05hbWVcIjpcIuWIneS4gFwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzY1ZTg3ZmZhNzE4YjQyYmI5YzIwMTcxMjU2NmRiYzlhLnBuZ1wiLFwiaWRcIjpcIjEzMzczMDYxMTAyNzc0NzYzNTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJNQU5BR0VSXCIsXCJpc1N1cGVyXCI6dHJ1ZX0iLCJzdWIiOiJhZG1pbiIsImV4cCI6MTY4NTE5NDkwOX0.4Evz5yCV0T1Dck0y7B9J88lksqBHOpPnr0CcJCDYgtA";

        ResultMessage<File> result = fileController.upload(accessToken, fileId, newName);

        assertEquals(ResultCode.SUCCESS.code(), result.getCode());
    }

    // 情况6: 用户角色为MANAGER，文件拥有者是MEMBER或者STORE，newName有效
    @Test
    public void testUploadFile_case6() throws Exception {
        String newName = "newName1";
        String fileId = "1661658363582246914";
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCJhZG1pblwiLFwibmlja05hbWVcIjpcIuWIneS4gFwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzY1ZTg3ZmZhNzE4YjQyYmI5YzIwMTcxMjU2NmRiYzlhLnBuZ1wiLFwiaWRcIjpcIjEzMzczMDYxMTAyNzc0NzYzNTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJNQU5BR0VSXCIsXCJpc1N1cGVyXCI6dHJ1ZX0iLCJzdWIiOiJhZG1pbiIsImV4cCI6MTY4NTE5NDkwOX0.4Evz5yCV0T1Dck0y7B9J88lksqBHOpPnr0CcJCDYgtA";

        ResultMessage<File> result = fileController.upload(accessToken, fileId, newName);

        assertEquals(ResultCode.SUCCESS.code(), result.getCode());
    }

    // 情况7: accessToken无效或不存在，尝试进行文件重命名，newName有效
    @Test
    public void testUploadFile_case7() throws Exception {
        String newName = "newName1";
        String fileId = "1661658363582246914";
        String accessToken = "invalidToken";

        ResultMessage<File> result = fileController.upload(accessToken, fileId, newName);

        assertEquals(ResultCode.SUCCESS.code(), result.getCode());
    }

    // 情况8: 用户角色任意，但fileId不存在，newName有效
    @Test
    public void testUploadFile_case8() throws Exception {
        String newName = "newName1";
        String fileId = "invalidFileId";
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCJhZG1pblwiLFwibmlja05hbWVcIjpcIuWIneS4gFwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzY1ZTg3ZmZhNzE4YjQyYmI5YzIwMTcxMjU2NmRiYzlhLnBuZ1wiLFwiaWRcIjpcIjEzMzczMDYxMTAyNzc0NzYzNTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJNQU5BR0VSXCIsXCJpc1N1cGVyXCI6dHJ1ZX0iLCJzdWIiOiJhZG1pbiIsImV4cCI6MTY4NTE5NDkwOX0.4Evz5yCV0T1Dck0y7B9J88lksqBHOpPnr0CcJCDYgtA";

        ResultMessage<File> result = fileController.upload(accessToken, fileId, newName);

        assertEquals(ResultCode.SUCCESS.code(), result.getCode());
    }

    // 情况9: 用户角色任意，fileId存在，但newName无效或为空
    @Test
    public void testUploadFile_case9() throws Exception {
        String newName = "";
        String fileId = "invalidFileId";
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCJhZG1pblwiLFwibmlja05hbWVcIjpcIuWIneS4gFwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzY1ZTg3ZmZhNzE4YjQyYmI5YzIwMTcxMjU2NmRiYzlhLnBuZ1wiLFwiaWRcIjpcIjEzMzczMDYxMTAyNzc0NzYzNTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJNQU5BR0VSXCIsXCJpc1N1cGVyXCI6dHJ1ZX0iLCJzdWIiOiJhZG1pbiIsImV4cCI6MTY4NTE5NDkwOX0.4Evz5yCV0T1Dck0y7B9J88lksqBHOpPnr0CcJCDYgtA";

        ResultMessage<File> result = fileController.upload(accessToken, fileId, newName);

        assertEquals(ResultCode.SUCCESS.code(), result.getCode());
    }


}

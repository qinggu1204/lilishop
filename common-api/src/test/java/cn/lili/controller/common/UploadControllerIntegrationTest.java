package cn.lili.controller.common;

import cn.lili.common.enums.ResultCode;
import cn.lili.controller.common.UploadController;
import cn.lili.common.vo.ResultMessage;
import cn.lili.modules.file.entity.File;
import cn.lili.modules.file.service.FileService;
import cn.lili.modules.system.entity.enums.SettingEnum;
import cn.lili.modules.system.service.SettingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UploadControllerIntegrationTest {

    @Autowired
    private UploadController uploadController;

    @Autowired
    private FileService fileService;

    @Autowired
    private SettingService settingService;
    
    @Test
    public void testUploadFile() throws Exception {
        String originalFileName = "test.jpg";
        String contentType = "image/jpeg";
        byte[] content = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        MultipartFile file = new MockMultipartFile(originalFileName, originalFileName, contentType, content);

        String base64 = null;
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCJhZG1pblwiLFwibmlja05hbWVcIjpcIuWIneS4gFwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzY1ZTg3ZmZhNzE4YjQyYmI5YzIwMTcxMjU2NmRiYzlhLnBuZ1wiLFwiaWRcIjpcIjEzMzczMDYxMTAyNzc0NzYzNTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJNQU5BR0VSXCIsXCJpc1N1cGVyXCI6dHJ1ZX0iLCJzdWIiOiJhZG1pbiIsImV4cCI6MTY4NDk4NDM1MX0.vvqJLIqLwW-JgFQHIm6UkdT8kr7qtTTXT--xzuAJfms";  //请注意，这里的token必须是有效的
        ResultMessage<Object> result = uploadController.upload(file, base64, accessToken);

        assertEquals(ResultCode.SUCCESS.code(), result.getCode());
    }

    @Test
    public void testUploadWithNullFile() throws Exception {
        MultipartFile file = null;
        String base64 = null;
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCJhZG1pblwiLFwibmlja05hbWVcIjpcIuWIneS4gFwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzY1ZTg3ZmZhNzE4YjQyYmI5YzIwMTcxMjU2NmRiYzlhLnBuZ1wiLFwiaWRcIjpcIjEzMzczMDYxMTAyNzc0NzYzNTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJNQU5BR0VSXCIsXCJpc1N1cGVyXCI6dHJ1ZX0iLCJzdWIiOiJhZG1pbiIsImV4cCI6MTY4NDk4NDM1MX0.vvqJLIqLwW-JgFQHIm6UkdT8kr7qtTTXT--xzuAJfms";  //请注意，这里的token必须是有效的
        ResultMessage<Object> result = uploadController.upload(file, base64, accessToken);

        assertEquals(ResultCode.FILE_NOT_EXIST_ERROR.code(), result.getCode());
    }

    @Test
    public void testUploadWithInvalidToken() throws Exception {
        String originalFileName = "test.jpg";
        String contentType = "image/jpeg";
        byte[] content = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        MultipartFile file = new MockMultipartFile(originalFileName, originalFileName, contentType, content);

        String base64 = null;
        String accessToken = "invalidToken";
        ResultMessage<Object> result = uploadController.upload(file, base64, accessToken);

        assertEquals(ResultCode.USER_AUTHORITY_ERROR.code(), result.getCode());
    }

    @Test
    public void testUploadWithUnsupportedFileType() throws Exception {
        String originalFileName = "test.txt";
        String contentType = "text/plain";
        byte[] content = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        MultipartFile file = new MockMultipartFile(originalFileName, originalFileName, contentType, content);

        String base64 = null;
        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCJhZG1pblwiLFwibmlja05hbWVcIjpcIuWIneS4gFwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzY1ZTg3ZmZhNzE4YjQyYmI5YzIwMTcxMjU2NmRiYzlhLnBuZ1wiLFwiaWRcIjpcIjEzMzczMDYxMTAyNzc0NzYzNTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJNQU5BR0VSXCIsXCJpc1N1cGVyXCI6dHJ1ZX0iLCJzdWIiOiJhZG1pbiIsImV4cCI6MTY4NDk4NDM1MX0.vvqJLIqLwW-JgFQHIm6UkdT8kr7qtTTXT--xzuAJfms";  //请注意，这里的token必须是有效的
        ResultMessage<Object> result = uploadController.upload(file, base64, accessToken);

        assertEquals(ResultCode.FILE_TYPE_NOT_SUPPORT.code(), result.getCode());
    }
}

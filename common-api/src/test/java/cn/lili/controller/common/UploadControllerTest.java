package cn.lili.controller.common;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UploadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFileUpload() throws Exception {
        // 生成一个测试用的MultipartFile对象
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "test.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "Hello, World!".getBytes(StandardCharsets.UTF_8)
        );

        String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyQ29udGV4dCI6IntcInVzZXJuYW1lXCI6XCJhZG1pblwiLFwibmlja05hbWVcIjpcIuWIneS4gFwiLFwiZmFjZVwiOlwiaHR0cHM6Ly9saWxpc2hvcC1vc3Mub3NzLWNuLWJlaWppbmcuYWxpeXVuY3MuY29tLzY1ZTg3ZmZhNzE4YjQyYmI5YzIwMTcxMjU2NmRiYzlhLnBuZ1wiLFwiaWRcIjpcIjEzMzczMDYxMTAyNzc0NzYzNTJcIixcImxvbmdUZXJtXCI6ZmFsc2UsXCJyb2xlXCI6XCJNQU5BR0VSXCIsXCJpc1N1cGVyXCI6dHJ1ZX0iLCJzdWIiOiJhZG1pbiIsImV4cCI6MTY4NDkzNTg3N30.s_GLpZDl8XBxba3WoQ7Hxb961Xby-rEKJSJZZPz1E30";
        // 发起文件上传请求
        mockMvc.perform(MockMvcRequestBuilders.multipart("/common/common/upload/file")
                        .file(file)
                        .header("accessToken", accessToken))
                .andExpect(MockMvcResultMatchers.status().isOk())
                // 验证返回的结果
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("200"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Success"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").value("file-upload-result"));
    }
}

package com.project.code_manager;

import com.project.code_manager.controller.CodeController;
import com.project.code_manager.dao.CodeDao;
import com.project.code_manager.entity.Code;
import com.project.code_manager.entity.GeographicInformationCode;
import com.project.code_manager.entity.TimeCode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CodeManagerApplicationTests {

    @Test
    void contextLoads() {
        //CodeController codeController = new CodeController();
        //Code code = new Code("110101001001202105220204001010302001");
        //codeController.decode("110101001001202105220204001010302001");
        System.out.println("110101001001202105220204003000101002".equals("110101001001202212021116252010101002"));
    }

}

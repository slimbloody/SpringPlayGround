package com.slim.playground.springtest.classpathFile;


import java.io.File;
import java.io.IOException;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/ClassPathTest")
public class ClassPathTestController {
    public static String html;

    static {
        ClassPathResource classPathResource = new ClassPathResource("/html/shunfeng.html");
        File file = null;
        try {
            file = classPathResource.getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file != null) {
            try {
                html = FileUtils.readFileToString(file, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
                html = null;
            }
        } else {
            html = null;
        }

        // 顺丰没加载到模板抛错退出
        if (Objects.isNull(html)) {
            throw new RuntimeException();
        }
    }

    @PostMapping("/test")
    public void test() {
        log.info("name: {}", html);
    }
}

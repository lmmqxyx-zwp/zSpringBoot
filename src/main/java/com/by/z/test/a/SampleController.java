package com.by.z.test.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author zwp
 */
@Controller
@EnableAutoConfiguration
public class SampleController {
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        // 测试启动多个Controller
        Object[] os = new Object[]{T1Controller.class, SampleController.class};

        // 启动本身的Connllener
        //SpringApplication.run(SampleController.class, args);

        SpringApplication.run(os, args);

    }

}

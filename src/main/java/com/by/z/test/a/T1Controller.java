package com.by.z.test.a;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用来测试的Controller
 * 在{@link SampleController 中添加用来测试一次性启动多个Controller}
 *
 * @author zwp
 */
@Controller
@EnableAutoConfiguration
public class T1Controller {

    @RequestMapping("/t1Home")
    @ResponseBody
    String t1Home() {
        return "t1Home Hello World!";
    }

}

package top.lujianwei.boot.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.lujianwei.boot.springboot.config.JdbcAutoConfig;
import top.lujianwei.boot.springboot.config.JdbcConfig;
import top.lujianwei.booter.HelloService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    private JdbcConfig jdbcConfig;

    @Autowired
    private JdbcAutoConfig jdbcAutoConfig;

    @Autowired
    private HelloService helloService;

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public Map<String, Object> home() {
        logger.debug("this is an debug log");
        logger.info("this is an info log");
        logger.error("this is an error log");
        logger.error("aaaaaaaa");
        System.out.println("cccc");
        logger.debug(jdbcConfig.getUsername() + "----" + jdbcConfig.getPassword());
        logger.debug(jdbcAutoConfig.getUsername() + "----" + jdbcAutoConfig.getPassword());
        Map<String, Object> map = new HashMap<>();
        map.put("x", "cccc");
        return map;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String sayHello() {
        return helloService.sayHello();
    }

}

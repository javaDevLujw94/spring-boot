package top.lujianwei.boot.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import top.lujianwei.boot.springboot.model.LujwMessage;
import top.lujianwei.boot.springboot.model.LujwResponse;

import java.util.Date;

@Controller
@EnableScheduling
public class LujwController {

    private static final Logger logger = LoggerFactory.getLogger(LujwController.class);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public LujwResponse say(LujwMessage lujwMessage) throws Exception {
        Thread.sleep(3000);
        return new LujwResponse("Welcome, " + lujwMessage.getName() + "!");
    }

    @Scheduled(fixedRate = 1000)
    public void fixSay() {
//        logger.info("----------------" + new Date().toString());
        simpMessagingTemplate.convertAndSend("/topic/getTime", "Welcome, 现在是" + new Date().toString() + "!");
    }


}

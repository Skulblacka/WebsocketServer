package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    @Autowired
    Manager manager;
//    @MessageMapping("/controller")
//    @SendTo("/topic/greetings")
//    public Greeting greeting(HelloMessage message) throws Exception {
////        Thread.sleep(1000); // simulated delay
////        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
//        return new Greeting("Hello, " + message.getName() + "!");
//    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(String message) throws Exception {
//        Thread.sleep(1000); // simulated delay
//        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
        ;
        return manager.getPosition(message);
    }


}
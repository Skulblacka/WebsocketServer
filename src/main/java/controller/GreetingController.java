package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import service.Manager;

@Controller
public class GreetingController {

    @Autowired
    Manager2 manager2;

    Manager manager = new Manager();
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
        //return manager2.getPosition(message);

        return manager.playerAction(message);
    }


}
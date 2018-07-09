package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import service.Manager;

@Controller
public class CommunicationController {


    Manager manager = new Manager();


    @MessageMapping("/play")
    @SendTo("/game/connection")
    public String clientConnection(String message) throws Exception {

        return manager.playerAction(message);
    }


}
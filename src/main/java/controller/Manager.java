package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.Player;

import java.util.ArrayList;
import java.util.List;

@Component
public class Manager {

    List<Player> players= new ArrayList<Player>();
    int pos_x=100;
    int speed=5;

    public String getPosition(String message){

        JsonObject o = new JsonParser().parse(message).getAsJsonObject();
        System.out.println(o.get("name"));
        System.out.println(o.get("key"));



        if(o.get("key").toString().equals("\"a\"")){
            pos_x=pos_x+(speed*(-1));
        }

        if(o.get("key").toString().equals("\"d\"")){
            pos_x=pos_x+speed;
        }

        JsonObject posi= new JsonObject();
        posi.add("name",o.get("name"));
        posi.addProperty("key",pos_x);


        return ""+posi;
    }
}

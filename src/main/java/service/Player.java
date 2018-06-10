package service;

import org.springframework.stereotype.Service;

@Service
public class Player {
    String name;
    int startPosition;
    int speedX;

    public Player(String name){
        this.name=name;
    }
    public void move(){
        startPosition=startPosition+speedX;
    }

    public int getPosition(){
        return this.startPosition;
    }

    public String getName(){
        return this.name;
    }
}

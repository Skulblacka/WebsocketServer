package service;

import org.springframework.stereotype.Service;

@Service
public class Player {
    private String name;
    private int id;
    int pos_X=100;
    int pos_Y;
    int speed=5;

    public Player(String name) {
        this.name = name;
        this.id=randomPlayerID(1000000,1000000000);
        fixName();
    }

    public void move(int direction) {
        pos_X = pos_X + (speed*direction);
    }

    public int getPosition_X() {
        return this.pos_X;
    }

    public String getName() {
        System.out.println(name);
        return this.name;
    }
     public int getPlayerID(){
        return id;
     }

    private int randomPlayerID(double min, double max) {
        double range = (max - min);
        return (int) ((Math.random() * range) + min);
    }

    private void fixName(){

        name = name.replace("\"", "");
        System.out.println();
    }
}

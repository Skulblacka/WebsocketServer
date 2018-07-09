package service;

import org.springframework.stereotype.Service;

@Service
public class Player {
    private String name;
    private int id;
    int pos_X=100;
    int pos_Y=100;
    int speed=5;

    public Player(String name) {
        this.name = name;
        this.id=randomPlayerID(1000000,1000000000);
        fixName();
    }

    public void move_X(int direction) {
        pos_X = pos_X + (speed*direction);
        if(pos_X<0){
            pos_X=0;
        }
        if(pos_X>1000){
            pos_X=1000;
        }
    }
    public void move_Y(int direction) {
        pos_Y = pos_Y + (speed*direction);
        if(pos_Y<0){
            pos_Y=0;
        }
        if(pos_Y>1000){
            pos_Y=1000;
        }
    }

    public int getPosition_X() {
        return this.pos_X;
    }

    public int getPosition_Y() {
        return this.pos_Y;
    }

    public String getName() {
        System.out.println("name: "+name+"  "+pos_X+":"+pos_Y);
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

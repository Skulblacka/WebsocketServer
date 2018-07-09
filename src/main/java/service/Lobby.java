package service;

import java.util.ArrayList;
import java.util.List;

public class Lobby {

    List<Player> lobby = new ArrayList<Player>();//store all player in the current lobby
    private String lobbyID;

    Lobby() {
        lobbyID = randomLobbyID(1000000, 100000000);
    }

    public String getLobbyID(){
        return lobbyID;
    }

    public List<Player> getPlayerFromLobby(){
        return lobby;
    }

    public boolean isLobbyFull(){
        if(lobby.size()<10){
            return false;
        }else{
            return true;
        }
    }

    public void addNewPlayerToLobby(Player player){
        lobby.add(player);
    }

    private String randomLobbyID(double min, double max) {
        double range = (max - min);
        return "" + (int) ((Math.random() * range) + min);
    }


}

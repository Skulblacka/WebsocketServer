package service;

import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    List<Player> players = new ArrayList<Player>();
    List<Lobby> lobbys = new ArrayList<Lobby>();
    Lobby lobby = new Lobby();

    public String playerAction(String message) {

        JsonObject playerInfo = new JsonParser().parse(message).getAsJsonObject();

        String name = playerInfo.get("name").toString();
        name = name.replace("\"", "");


        isNewPlayer(name);

        return action(playerInfo);
    }

    private String action(JsonObject playerInfo) {
        String name = playerInfo.get("name").toString();
        name = name.replace("\"", "");

        String key = playerInfo.get("key").toString();
        key = key.replace("\"", "");

        Player player = getCurrentPlayer(name);

        if (player != null) {
            movePlayer(player, key);
        }

        return buildLobbySituation(player);
    }

    private String buildLobbySituation(Player player) {

        JsonStructure json = new JsonStructure();
        json.values = new String[10][4];
        int i = 0;
        for (Player p : players) {
                json.values[i][0] = p.getName();
                json.values[i][1] = "" + p.getPosition_X();
                json.values[i][2] = "" + p.getPosition_Y();
                json.values[i][3] = "" + p.getPlayerID();

            i++;
        }

        return new Gson().toJson(json);
    }

    private void movePlayer(Player player, String key) {
        if (key.equals("a")) {
            player.move_X(-1);
        }
        if (key.equals("d")) {
            player.move_X(1);
        }
        if (key.equals("s")) {
            player.move_Y(1);
        }
        if (key.equals("w")) {
            player.move_Y(-1);
        }
    }

    private Player getCurrentPlayer(String name) {

        for (Player p : players) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }


    private void isNewPlayer(String name) {

        boolean playerExist = false;

        if (players.size() > 0) {
            for (Player p : players) {
                if (p.getName().equals(name)) {
                    playerExist = true;
                }
            }

            if (!playerExist) {//wenn spieler nicht existiert
                addNewPlayer(name);
            }
        } else {
            addNewPlayer(name);
        }

    }

    private void addNewPlayer(String name) {
        Player player = new Player(name);

        lobby.addNewPlayerToLobby(player);

        players.add(player);

    }


}

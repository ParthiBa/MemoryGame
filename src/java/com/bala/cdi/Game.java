/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bala.cdi;

import java.io.Serializable;
import java.util.HashMap;
import javax.enterprise.context.SessionScoped;
import javax.json.JsonObject;

@SessionScoped
public class Game implements Serializable{
private static final Long version = 1L;

private String GameId;
private String GameName;
private int HishScore =0;
private HashMap<String,player> playerList = new HashMap<String,player>();

    public HashMap<String, player> getPlayerList() {
        return playerList;
    }
    
    public void AddPlayer(player p){
       if(!hasPlayer(p.getPlayerName())){
        playerList.put(p.getPlayerName(), p);
       }
    }
    
    public void RemovePlayer(player p){
        if(hasPlayer(p.getPlayerName())){
            playerList.remove(p);
        }
    }

    public boolean hasPlayer(String playername){
       if(playerList.containsKey(playername)){
           return true;
       }
       return false;
    }
    public String getGameId() {
        return GameId;
    }

    public void setGameId(String GameId) {
        this.GameId = GameId;
    }

    public String getGameName() {
        return GameName;
    }

    public void setGameName(String GameName) {
        this.GameName = GameName;
    }

    public int getHishScore() {
        return HishScore;
    }

    public void setHishScore(int HishScore) {
        this.HishScore = HishScore;
    }
    
    
    
}

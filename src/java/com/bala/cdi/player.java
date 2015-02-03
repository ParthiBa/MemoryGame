/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bala.cdi;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Prasanna Mac
 */@SessionScoped
public class player implements Serializable{
    private static final long version = 1L;
    private String playerId;
    private String playerName;
    private String playerScore;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(String playerScore) {
        this.playerScore = playerScore;
    }
   
}

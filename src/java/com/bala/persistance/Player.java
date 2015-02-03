/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bala.persistance;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author A0123057N
 */
@Entity
@Table(name = "player")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p"),
    @NamedQuery(name = "Player.findByPlayerid", query = "SELECT p FROM Player p WHERE p.playerid = :playerid"),
    @NamedQuery(name = "Player.findByPlayername", query = "SELECT p FROM Player p WHERE p.playername = :playername"),
    @NamedQuery(name = "Player.findByPlayerdeviceid", query = "SELECT p FROM Player p WHERE p.playerdeviceid = :playerdeviceid")})
public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "playerid")
    private String playerid;
    @Size(max = 45)
    @Column(name = "playername")
    private String playername;
    @Size(max = 45)
    @Column(name = "playerdeviceid")
    private String playerdeviceid;
    @OneToMany(mappedBy = "gameplayer")
    private Collection<Gametable> gametableCollection;

    public Player() {
    }

    public Player(String playerid) {
        this.playerid = playerid;
    }

    public String getPlayerid() {
        return playerid;
    }

    public void setPlayerid(String playerid) {
        this.playerid = playerid;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getPlayerdeviceid() {
        return playerdeviceid;
    }

    public void setPlayerdeviceid(String playerdeviceid) {
        this.playerdeviceid = playerdeviceid;
    }

    @XmlTransient
    public Collection<Gametable> getGametableCollection() {
        return gametableCollection;
    }

    public void setGametableCollection(Collection<Gametable> gametableCollection) {
        this.gametableCollection = gametableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (playerid != null ? playerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Player)) {
            return false;
        }
        Player other = (Player) object;
        if ((this.playerid == null && other.playerid != null) || (this.playerid != null && !this.playerid.equals(other.playerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bala.persistance.Player[ playerid=" + playerid + " ]";
    }
    
}

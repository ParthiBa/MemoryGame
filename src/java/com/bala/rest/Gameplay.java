/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bala.rest;

import com.bala.cdi.Game;
import com.bala.cdi.GameGroups;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.sse.EventOutput;

@Path("/gamePlay")
@RequestScoped
public class Gameplay {
 @Inject GameGroups gameGroups;
 @Inject Game myGame;
    
    @GET
    @Path("/{gamename}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response startgame(@PathParam("gamename") String name){
        EventOutput eo = new EventOutput();
        gameGroups.add(eo, name);
        myGame.hasPlayer(name);
        return Response.ok().build();
       
    }
            
     @GET
     @Path("/play")
    @Produces(MediaType.APPLICATION_JSON)
    public Response playgame(){
       
        return Response.ok().build();
    }
    
      @GET
     @Path("/leave")
    @Produces(MediaType.APPLICATION_JSON)
    public Response leavegame(){

        return Response.ok().build();
    }  
            
}


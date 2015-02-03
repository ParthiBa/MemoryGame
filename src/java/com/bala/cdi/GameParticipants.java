/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bala.cdi;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.enterprise.context.ApplicationScoped;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseBroadcaster;

@ApplicationScoped
public class GameParticipants {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private SseBroadcaster broadcaster = new SseBroadcaster();
    
    public void add(EventOutput eo) {
        Lock l = lock.writeLock();
        l.lock();
        try {
            broadcaster.add(eo);
        } finally {
            l.unlock();
        }
    }
    
    public void publish(String name, String game) {
        OutboundEvent event = new OutboundEvent.Builder()
                .data(String.class, name)
                //.name(game)
                .build();
        Lock l = lock.readLock();
        l.lock();
        try {
            broadcaster.broadcast(event);
        } finally {
            l.unlock();
        }
    }
}


package de.lanpodder.provihack.model;

import java.util.UUID;

import lombok.Data;

@Data
public class Events {
    private String eventName;
    private String eventDatum;
    private String description;
    private int id;
    private String site;

    public Events(String name, String date, int id) {
        this.eventDatum = date;
        this.eventName = name;
        this.id = id;
    }

    public Events(String name, String date, int id, String description){
        this.eventDatum = date;
        this.eventName = name;
        this.id = id;
        this.description = description;
    }
}
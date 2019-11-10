package de.lanpodder.provihack.model;

import lombok.Data;

@Data
public class Versicherung {
    private String versicherungsBezeichnung;
    private int id;

    public Versicherung(String bez, int id) {
        this.versicherungsBezeichnung = bez;
        this.id = id;
    }
}
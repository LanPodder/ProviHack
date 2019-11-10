package de.lanpodder.provihack.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UserInfo {
    private List<Versicherung> gebuchteVersicherungen;
    private String versicherungsNr;
    private String name, lastName, gender;
    private int einkommen, alter;
    private String haustiere;
    private String auto;

    public UserInfo() {
        this.gebuchteVersicherungen = new ArrayList<>();
    }

    public void addVersicherung(Versicherung versicherung){
        gebuchteVersicherungen.add(versicherung);
    }
}
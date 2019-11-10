package de.lanpodder.provihack.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import de.lanpodder.provihack.model.UserInfo;
import de.lanpodder.provihack.model.Versicherung;

@Service
public class VersicherungsService {
    private List<Versicherung> versicherungen;

    public VersicherungsService() {
        versicherungen = new ArrayList<>();
        initDummy();
    }

    public List<Versicherung> getAllVersicherungen() {
        return versicherungen;
    }

    public Versicherung getVersicherungById(int id) {
        return versicherungen.stream().filter(x -> x.getId() == id).collect(Collectors.toList()).get(0);
    }

    public void addVersicherung(Versicherung v) {
        versicherungen.add(v);
    }

    public List<Versicherung> getRecommendedVersicherung(UserInfo user) {
        List<Versicherung> rec = new ArrayList<>();
        if (user.getEinkommen() < 10000) {
            rec.add(getVersicherungById(12));
        }
        if(user.getEinkommen() > 10000){
            rec.add(getVersicherungById(16));
        }
        if (user.getHaustiere() != null) {
            if (user.getHaustiere().contains("Hund")) {
                rec.add(getVersicherungById(14));
            }
            if (user.getHaustiere().contains("Katze")) {
                rec.add(getVersicherungById(15));
            }
        }
        if (user.getAuto() != null) {
            if (user.getAuto().contains("Auto")) {
                rec.add(getVersicherungById(6));
                rec.add(getVersicherungById(7));
            }
        }
        if (user.getAlter() <= 24) {
            rec.add(getVersicherungById(8));
            rec.add(getVersicherungById(9));
        }
        return rec;
    }

    private void initDummy() {
        addVersicherung(new Versicherung("Krankenversicherung", 1));
        addVersicherung(new Versicherung("KFZ-Versicherung", 2));
        addVersicherung(new Versicherung("Reiseversicherung", 3));
        addVersicherung(new Versicherung("Altersvorsorge", 4));
        addVersicherung(new Versicherung("Privathaftpflicht", 5));
        addVersicherung(new Versicherung("Autoversicherung", 6));
        addVersicherung(new Versicherung("Autoschutzbrief & MeinCopilot", 7));
        addVersicherung(new Versicherung("Handyversicherung", 8));
        addVersicherung(new Versicherung("Internetschutz", 9));
        addVersicherung(new Versicherung("Verkehrs-Rechtschutz", 10));
        addVersicherung(new Versicherung("Baufinanzierung", 11));
        addVersicherung(new Versicherung("JuniorRente", 12));
        addVersicherung(new Versicherung("Auslandsreise Versicherung", 13));
        addVersicherung(new Versicherung("Hundeversicherung", 14));
        addVersicherung(new Versicherung("Katzenversicherung", 15));
        addVersicherung(new Versicherung("GarantRente", 16));
    }
}
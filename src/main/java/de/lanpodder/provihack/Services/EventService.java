package de.lanpodder.provihack.Services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import de.lanpodder.provihack.model.Events;

@Service
public class EventService {
    private List<Events> events;
    public EventService(List<Events> events) {
        this.events = events;
        initDummy();
    }

    public Events getEventById(int id){
        return events.stream().filter(x->x.getId()==id).collect(Collectors.toList()).get(0);
    }

    public void addEvent(Events e){
        events.add(e);
    }

    public List<Events> getEvents(){
        return events;
    }

    private void initDummy(){
        String descript = "Lust und Zeit bei spannenden Herausforderungen mitzumachen?\n"+
        "Eigene Hardware einpacken und los geht`s!\n"+
        "Bitte beachte unsere Teilnahmebedingungen und die Informationen zur Datenverarbeitung.\n"+
        "Frage nach unter hackathon@provinzial.com\n";
        Events provihack = new Events("ProviHack", "8.11.2019", 1, descript);
        provihack.setSite("https://www.provinzial.com/content/_micro/hackathon/");
        addEvent(provihack);
        addEvent(new Events("Event 1", "7.12.2019", 2));
        addEvent(new Events("Event 2", "25.01.2020", 3));
    }
}
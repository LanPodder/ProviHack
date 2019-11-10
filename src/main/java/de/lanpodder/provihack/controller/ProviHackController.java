package de.lanpodder.provihack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import de.lanpodder.provihack.Services.EventService;
import de.lanpodder.provihack.Services.VersicherungsService;
import de.lanpodder.provihack.model.Events;
import de.lanpodder.provihack.model.UserInfo;
import de.lanpodder.provihack.model.Versicherung;
import de.lanpodder.provihack.model.builder.UserBuilder;

@Controller
public class ProviHackController {
    UserInfo user;
    EventService eventService;
    VersicherungsService versicherungsService;

    public ProviHackController(EventService eventService, VersicherungsService versicherungsService) {
        this.eventService = eventService;
        this.versicherungsService = versicherungsService;
        UserBuilder b = new UserBuilder();
        user = b.setName("Alan").setLastName("Shref").setVersicherungsNr("XWA5544SFSG").buildUser();
        user.addVersicherung(versicherungsService.getVersicherungById(1));
        user.addVersicherung(versicherungsService.getVersicherungById(2));
        user.addVersicherung(versicherungsService.getVersicherungById(3));

    }

    @GetMapping("/")
    public String frontPage(Model m) {
        m.addAttribute("userinfo", user);
        m.addAttribute("upcomingevents", eventService.getEvents());
        List<Versicherung> rec = versicherungsService.getRecommendedVersicherung(user);
        if (rec != null) {
            if (rec.size() > 0)
                m.addAttribute("empfohlen", rec.get(0).getVersicherungsBezeichnung());
        }
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model m) {
        m.addAttribute("userinfo", user);
        return "profile";
    }

    @GetMapping("/recommended")
    public String recommended(Model m) {
        m.addAttribute("empfohleneversicherungen", versicherungsService.getRecommendedVersicherung(user));
        m.addAttribute("alleversicherungen", versicherungsService.getAllVersicherungen());
        return "recommended";
    }

    @GetMapping("/event")
    public String eventDetails(Model m, int id) {
        m.addAttribute("event", eventService.getEventById(id));
        return "event";
    }

    @PostMapping("/profilinfo")
    public String profilInfo(Model m, UserInfo user) {
        System.out.println(this.user);
        System.out.println(user);
        this.user.setEinkommen(user.getEinkommen());
        this.user.setAlter(user.getAlter());
        this.user.setAlter(user.getAlter());
        this.user.setAlter(user.getAlter());
        return "redirect:/";
    }
}
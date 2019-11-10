package de.lanpodder.provihack.model.builder;

import de.lanpodder.provihack.model.UserInfo;

public class UserBuilder {
    UserInfo user;
    public UserBuilder() {
        user = new UserInfo();
    }

    public UserInfo buildUser(){
        return user;
    }

    public UserBuilder setName(String name){
        user.setName(name);
        return this;
    }

    public UserBuilder setLastName(String lastname){
        user.setLastName(lastname);
        return this;
    }

    public UserBuilder setVersicherungsNr(String nr){
        user.setVersicherungsNr(nr);
        return this;
    }
}
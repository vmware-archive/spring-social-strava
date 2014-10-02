package org.springframework.social.strava.api;

import java.io.Serializable;

public class StravaAthleteProfile implements Serializable {
    private long id;
    private String name;
    private String email;
    private String login;

    public StravaAthleteProfile(long id, String name, String email, String login) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getId() {
        return id;
    }
}

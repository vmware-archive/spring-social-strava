package org.springframework.social.strava.api;

import java.io.Serializable;

public class StravaAthleteProfile implements Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private String email;

    public StravaAthleteProfile(long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }
}

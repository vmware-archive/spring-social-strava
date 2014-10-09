package org.springframework.social.strava.api;

import java.io.Serializable;

public class StravaAthleteProfile implements Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String avatarMedium;
    private String avatarLarge;

    public StravaAthleteProfile(long id, String firstName, String lastName, String email, String avatarMedium, String avatarLarge) {
        this.id = id;
        this.email = email;
        this.avatarMedium = avatarMedium;
        this.avatarLarge = avatarLarge;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatarMedium() {
        return avatarMedium;
    }

    public String getAvatarLarge() {
        return avatarLarge;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

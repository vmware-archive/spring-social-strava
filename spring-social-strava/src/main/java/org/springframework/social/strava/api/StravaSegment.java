package org.springframework.social.strava.api;

public class StravaSegment {
    private long id;
    private String name;
    private String activityType;
    private Float distance;
    private StravaMap map;

    public StravaSegment(long id) {
        this.id = id;
    }

    public StravaSegment(long id, String name, String activityType, Float distance, StravaMap map) {
        this.id = id;
        this.name = name;
        this.activityType = activityType;
        this.distance = distance;
        this.map = map;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getActivityType() {
        return activityType;
    }

    public Float getDistance() {
        return distance;
    }

    public StravaMap getMap() {
        return map;
    }
}

package org.springframework.social.strava.api;

import java.io.Serializable;
import java.util.List;

public class StravaActivity implements Serializable {
    private long id;
    private String name;
    private String type;
    private String description;
    private float distance;
    private long elapsedTime;
    private String date;
    private StravaMap map;
    private List<StravaSegmentEffort> segmentEfforts;

    public StravaActivity(long id, String name, String type, String description, float distance, long elapsedTime, String date, StravaMap map, List<StravaSegmentEffort> segmentEfforts) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.distance = distance;
        this.elapsedTime = elapsedTime;
        this.date = date;
        this.map = map;
        this.segmentEfforts = segmentEfforts;
    }

    public StravaActivity(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public float getDistance() {
        return distance;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public String getDate() {
        return date;
    }

    public StravaMap getMap() {
        return map;
    }

    public List<StravaSegmentEffort> getSegmentEfforts() {
        return segmentEfforts;
    }
}

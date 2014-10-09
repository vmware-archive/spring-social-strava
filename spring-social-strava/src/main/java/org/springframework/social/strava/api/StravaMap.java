package org.springframework.social.strava.api;

public class StravaMap {
    private String id;
    private String polyline;
    private long resource_state;

    public StravaMap(String id, String polyline, long resource_state) {
        this.id = id;
        this.polyline = polyline;
        this.resource_state = resource_state;
    }

    public String getId() {
        return id;
    }

    public String getPolyline() {
        return polyline;
    }

    public long getResource_state() {
        return resource_state;
    }
}

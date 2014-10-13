package org.springframework.social.strava.api;

public class StravaMap {
    private String id;
    private String polyline;
    private String summaryPolyline;
    private long resource_state;

    public StravaMap(String id, String polyline, String summaryPolyline, long resource_state) {
        this.id = id;
        this.polyline = polyline;
        this.summaryPolyline = summaryPolyline;
        this.resource_state = resource_state;
    }

    public String getId() {
        return id;
    }

    public String getPolyline() {
        return polyline;
    }

    public String getSummaryPolyline() {
        return summaryPolyline;
    }

    public long getResource_state() {
        return resource_state;
    }
}

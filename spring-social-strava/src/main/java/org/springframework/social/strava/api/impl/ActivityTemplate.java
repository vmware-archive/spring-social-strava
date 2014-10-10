package org.springframework.social.strava.api.impl;

import org.springframework.social.strava.api.ActivityOperations;
import org.springframework.social.strava.api.StravaActivity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

public class ActivityTemplate extends AbstractStravaOperations implements ActivityOperations {

    private final RestTemplate restTemplate;

    public ActivityTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
        super(isAuthorizedForUser);
        this.restTemplate = restTemplate;
    }

    public StravaActivity getActivityById(String id) {
        return restTemplate.getForObject(buildUri("/activities/" + id), StravaActivity.class);
    }

    public ArrayList<StravaActivity> getAllActivities(int limit) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
        parameters.set("per_page", String.valueOf(limit));
        return restTemplate.getForObject(buildUri("/activities", parameters), StravaActivityList.class);
    }

    public ArrayList<StravaActivity> getAllActivities() {
        return getAllActivities(200);
    }

    @SuppressWarnings("serial")
    private static class StravaActivityList extends ArrayList<StravaActivity> {}
}

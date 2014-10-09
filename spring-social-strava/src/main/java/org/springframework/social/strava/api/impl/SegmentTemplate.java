package org.springframework.social.strava.api.impl;

import org.springframework.social.strava.api.SegmentOperations;
import org.springframework.social.strava.api.StravaSegment;
import org.springframework.web.client.RestTemplate;

public class SegmentTemplate extends AbstractStravaOperations implements SegmentOperations {
    private final RestTemplate restTemplate;

    /**
     * @param restTemplate        A RestTemplate
     * @param isAuthorizedForUser Boolean indicating whether the RestTemplate is authorized for a user
     */
    public SegmentTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
        super(isAuthorizedForUser);
        this.restTemplate = restTemplate;
    }

    public StravaSegment getSegmentById(String id) {
        return restTemplate.getForObject(buildUri("/segments/" + id), StravaSegment.class);
    }
}

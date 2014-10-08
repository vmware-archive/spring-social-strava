package org.springframework.social.strava.api.impl;

import org.springframework.social.strava.api.SegmentEffortOperations;
import org.springframework.social.strava.api.StravaSegmentEffort;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class SegmentEffortTemplate extends AbstractStravaOperations implements SegmentEffortOperations {
    private final RestTemplate restTemplate;

    /**
     * @param restTemplate        A RestTemplate
     * @param isAuthorizedForUser Boolean indicating whether the RestTemplate is authorized for a user
     */
    public SegmentEffortTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
        super(isAuthorizedForUser);
        this.restTemplate = restTemplate;
    }

    public List<StravaSegmentEffort> getSegmentEfforts(String segmentId, String athleteId) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
        parameters.set("athlete_id", athleteId);
        return restTemplate.getForObject(buildUri("/segments/" + segmentId + "/all_efforts", parameters), StravaSegmentEffortList.class);
    }

    public StravaSegmentEffort getSegmentEffortById(String id) {
        return restTemplate.getForObject(buildUri("/segment_efforts/" + id), StravaSegmentEffort.class);
    }

    public List<StravaSegmentEffort> getAllSegmentEfforts(String segmentId, String startTime, String endTime) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
        parameters.set("start_date_local", startTime);
        parameters.set("end_date_local", endTime);
        parameters.set("per_page", "200");
        return restTemplate.getForObject(buildUri("/segments/" + segmentId + "/all_efforts", parameters), StravaSegmentEffortList.class);
    }

    @SuppressWarnings("serial")
    private static class StravaSegmentEffortList extends ArrayList<StravaSegmentEffort> {}

}

package org.springframework.social.strava.api.impl.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.strava.api.StravaSegment;
import org.springframework.social.strava.api.StravaSegmentEffort;
import org.springframework.social.strava.api.StravaSegmentEffortAthlete;

/**
 * Created by pivotal on 10/3/14.
 */
abstract class StravaSegmentEffortMixin extends StravaObjectMixin  {


    @JsonProperty("name")
    String name;

    @JsonProperty("date")
    String date;

    StravaSegmentEffortMixin(
            @JsonProperty("id") long id,
            @JsonProperty("name") String name,
            @JsonProperty("athlete") StravaSegmentEffortAthlete athlete,
            @JsonProperty("distance") float distance,
            @JsonProperty("start_date") String date,
            @JsonProperty("segment") StravaSegment segment,
            @JsonProperty("elapsed_time") long elapsedTime) {}
}

package org.springframework.social.strava.api.impl.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.strava.api.StravaMap;
import org.springframework.social.strava.api.StravaSegmentEffort;

import java.util.List;

/**
 * Created by pivotal on 10/3/14.
 */
abstract class StravaActivityMixin extends StravaObjectMixin  {

    @JsonProperty("name")
    String name;

    @JsonProperty("start_date")
    String date;

    @JsonProperty("description")
    String description;

    @JsonProperty("type")
    String type;

    StravaActivityMixin(
            @JsonProperty("id") long id,
            @JsonProperty("name") String name,
            @JsonProperty("type") String type,
            @JsonProperty("description") String description,
            @JsonProperty("distance") float distance,
            @JsonProperty("elapsed_time") long elapsedTime,
            @JsonProperty("start_date") String date,
            @JsonProperty("map") StravaMap map,
            @JsonProperty("segment_efforts") List<StravaSegmentEffort> segmentEfforts){}
}

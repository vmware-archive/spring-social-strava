package org.springframework.social.strava.api.impl.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.strava.api.StravaMap;

abstract class StravaSegmentDetailsMixin extends StravaObjectMixin  {

    @JsonProperty("name")
    String name;

    @JsonProperty("activity_type")
    String activityType;

    StravaSegmentDetailsMixin(
            @JsonProperty("id") long id,
            @JsonProperty("name") String name,
            @JsonProperty("activity_type") String activityType,
            @JsonProperty("distance") Float distance,
            @JsonProperty("map") StravaMap map
    ) {}
}

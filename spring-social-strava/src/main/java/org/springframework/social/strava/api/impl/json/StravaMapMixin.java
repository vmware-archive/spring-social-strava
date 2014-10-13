package org.springframework.social.strava.api.impl.json;

import com.fasterxml.jackson.annotation.JsonProperty;

abstract class StravaMapMixin extends StravaObjectMixin  {

    @JsonProperty("id")
    String id;

    @JsonProperty("polyline")
    String polyline;

    @JsonProperty("summary_polyline")
    String summaryPolyline;

    StravaMapMixin(
            @JsonProperty("id") String id,
            @JsonProperty("polyline") String polyline,
            @JsonProperty("summary_polyline") String summaryPolyline,
            @JsonProperty("resource_state") long resourceState
    ) {}
}

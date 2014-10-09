package org.springframework.social.strava.api.impl.json;

import com.fasterxml.jackson.annotation.JsonProperty;

abstract class StravaSegmentMixin extends StravaObjectMixin  {

    StravaSegmentMixin(
            @JsonProperty("id") long id) {}
}

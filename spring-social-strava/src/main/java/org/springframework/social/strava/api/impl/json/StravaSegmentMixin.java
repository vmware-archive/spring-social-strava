package org.springframework.social.strava.api.impl.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pivotal on 10/3/14.
 */
abstract class StravaSegmentMixin extends StravaObjectMixin  {

    StravaSegmentMixin(
            @JsonProperty("id") long id) {}
}

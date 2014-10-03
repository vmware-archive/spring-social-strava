package org.springframework.social.strava.api.impl.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pivotal on 10/3/14.
 */
abstract class StravaSegmentEffortAthleteMixin extends StravaObjectMixin  {

    StravaSegmentEffortAthleteMixin(
            @JsonProperty("id") long id) {}

}

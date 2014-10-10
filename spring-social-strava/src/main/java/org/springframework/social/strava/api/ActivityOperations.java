package org.springframework.social.strava.api;

import java.util.List;

public interface ActivityOperations {
    StravaActivity getActivityById(String id);
    List<StravaActivity> getAllActivities();
}

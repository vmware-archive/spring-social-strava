package org.springframework.social.strava.api;

import java.util.List;

public interface SegmentEffortOperations {
    List<StravaSegmentEffort> getSegmentEfforts(String segmentId, String athleteId);
    StravaSegmentEffort getSegmentEffortById(String id);
    List<StravaSegmentEffort> getAllSegmentEfforts(String segmentId, String startTime, String endTime);
}

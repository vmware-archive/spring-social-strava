/*
 * Copyright 2013-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.strava.api.impl;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.social.strava.api.StravaActivity;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class ActivityTest extends AbstractStravaApiTest {

	@Test
	public void testGetActivityById() throws Exception {
		mockServer.expect(requestTo("https://www.strava.com/api/v3/activities/1234")).andExpect(method(GET))
				.andExpect(header("Authorization", "Bearer ACCESS_TOKEN"))
				.andRespond(withSuccess(new ClassPathResource("activity.json", getClass()), MediaType.APPLICATION_JSON));

        StravaActivity activity = strava.activityOperations().getActivityById("1234");

		assertEquals(321934, activity.getId());
		assertEquals("12/12/2012 San Francisco", activity.getName());
        assertEquals("Run", activity.getType());
        assertEquals("the best ride ever", activity.getDescription());
		assertEquals(4475.4, activity.getDistance(), .1);
        assertEquals(1333, activity.getElapsedTime());
        assertEquals("2012-12-13T03:43:19Z", activity.getDate());
		assertEquals("kiteFpCBCD]", activity.getMap().getPolyline());
		assertEquals(1, activity.getSegmentEfforts().size());
		assertEquals(543755075, activity.getSegmentEfforts().get(0).getId());
		assertEquals(2417854, activity.getSegmentEfforts().get(0).getSegment().getId());
	}

    @Test
    public void testGetAllActivities() throws Exception {
        mockServer.expect(requestTo("https://www.strava.com/api/v3/activities")).andExpect(method(GET))
                .andExpect(header("Authorization", "Bearer ACCESS_TOKEN"))
                .andRespond(withSuccess(new ClassPathResource("activities.json", getClass()), MediaType.APPLICATION_JSON));

        List<StravaActivity> activities = strava.activityOperations().getAllActivities();
        assertEquals(1, activities.size());

        StravaActivity activity = activities.get(0);

        assertEquals(321934, activity.getId());
        assertEquals("12/12/2012 San Francisco", activity.getName());
        assertEquals("Run", activity.getType());
        assertEquals("the best ride ever", activity.getDescription());
        assertEquals(4475.4, activity.getDistance(), .1);
        assertEquals(1333, activity.getElapsedTime());
        assertEquals("2012-12-13T03:43:19Z", activity.getDate());
        assertEquals("kiteFpCBCD]", activity.getMap().getPolyline());
        assertEquals(1, activity.getSegmentEfforts().size());
        assertEquals(543755075, activity.getSegmentEfforts().get(0).getId());
        assertEquals(2417854, activity.getSegmentEfforts().get(0).getSegment().getId());
    }
}

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
import org.springframework.social.strava.api.StravaSegmentEffort;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class SegmentEffortTemplateTest extends AbstractStravaApiTest {

	@Test
	public void testGetSegmentEfforts() throws Exception {
		mockServer.expect(requestTo("https://www.strava.com/api/v3/segments/1234/all_efforts?athlete_id=9876")).andExpect(method(GET))
				.andExpect(header("Authorization", "Bearer ACCESS_TOKEN"))
				.andRespond(withSuccess(new ClassPathResource("segmentEfforts.json", getClass()), MediaType.APPLICATION_JSON));
		List<StravaSegmentEffort> segmentEfforts = strava.segmentEffortOperations().getSegmentEfforts("1234", "9876");
		assertEquals(3, segmentEfforts.size());

        StravaSegmentEffort segmentEffort = segmentEfforts.get(0);

		assertEquals(188196580, segmentEffort.getId());
		assertEquals("SF2G San Bruno Ave Climb", segmentEffort.getName());
        assertEquals("5099", segmentEffort.getAthlete().getId());
		assertEquals(236.82, segmentEffort.getDistance(), .1);
		assertEquals("2006-04-21T13:20:40Z", segmentEffort.getDate());
		assertEquals(345781, segmentEffort.getSegment().getId());
		assertEquals(62, segmentEffort.getElapsedTime());
	}

    @Test
    public void testGetSegmentEffortById() throws Exception {
        mockServer.expect(requestTo("https://www.strava.com/api/v3/segment_efforts/1234567")).andExpect(method(GET))
                .andExpect(header("Authorization", "Bearer ACCESS_TOKEN"))
                .andRespond(withSuccess(new ClassPathResource("segmentEffort.json", getClass()), MediaType.APPLICATION_JSON));

        StravaSegmentEffort segmentEffort = strava.segmentEffortOperations().getSegmentEffortById("1234567");
        assertEquals(188196580, segmentEffort.getId());
        assertEquals("SF2G San Bruno Ave Climb", segmentEffort.getName());
        assertEquals("5099", segmentEffort.getAthlete().getId());
        assertEquals(236.82, segmentEffort.getDistance(), .1);
        assertEquals("2006-04-21T13:20:40Z", segmentEffort.getDate());
        assertEquals(345781, segmentEffort.getSegment().getId());
        assertEquals(62, segmentEffort.getElapsedTime());
    }

	@Test
	public void testGetAllSegmentEfforts() throws Exception {
		mockServer.expect(requestTo("https://www.strava.com/api/v3/segments/1234/all_efforts?start_date_local=2006-04-21T13%3A20%3A40Z&end_date_local=2006-04-22T13%3A20%3A40Z&per_page=200")).andExpect(method(GET))
				.andExpect(header("Authorization", "Bearer ACCESS_TOKEN"))
				.andRespond(withSuccess(new ClassPathResource("segmentEfforts.json", getClass()), MediaType.APPLICATION_JSON));

        List<StravaSegmentEffort> segmentEfforts = strava.segmentEffortOperations().getAllSegmentEfforts("1234", "2006-04-21T13:20:40Z", "2006-04-22T13:20:40Z");
		assertEquals(3, segmentEfforts.size());

        StravaSegmentEffort segmentEffort = segmentEfforts.get(0);

		assertEquals(188196580, segmentEffort.getId());
		assertEquals("SF2G San Bruno Ave Climb", segmentEffort.getName());
        assertEquals("5099", segmentEffort.getAthlete().getId());
		assertEquals(236.82, segmentEffort.getDistance(), .1);
		assertEquals("2006-04-21T13:20:40Z", segmentEffort.getDate());
		assertEquals(345781, segmentEffort.getSegment().getId());
		assertEquals(62, segmentEffort.getElapsedTime());
	}
}

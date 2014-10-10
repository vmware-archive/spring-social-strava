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
import org.springframework.social.strava.api.StravaSegment;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class SegmentTemplateTest extends AbstractStravaApiTest {

	@Test
	public void testGetSegmentById() throws Exception {
		mockServer.expect(requestTo("https://www.strava.com/api/v3/segments/1234")).andExpect(method(GET))
				.andExpect(header("Authorization", "Bearer ACCESS_TOKEN"))
				.andRespond(withSuccess(new ClassPathResource("segment.json", getClass()), MediaType.APPLICATION_JSON));

        StravaSegment segment = strava.segmentOperations().getSegmentById("1234");

		assertEquals(229781, segment.getId());
		assertEquals("Hawk Hill", segment.getName());
        assertEquals("Ride", segment.getActivityType());
		assertEquals(2684.82, segment.getDistance(), .1);
		assertEquals("}g|e...VJr@", segment.getMap().getPolyline());
	}
}

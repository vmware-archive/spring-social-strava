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
import org.springframework.social.strava.api.StravaAthleteProfile;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class AthleteTemplateTest extends AbstractStravaApiTest {

	@Test
	public void getUserProfile() throws Exception {
		mockServer.expect(requestTo("https://www.strava.com/api/v3/athlete")).andExpect(method(GET))
				.andExpect(header("Authorization", "Bearer ACCESS_TOKEN"))
				.andRespond(withSuccess(new ClassPathResource("profile.json", getClass()), MediaType.APPLICATION_JSON));
		StravaAthleteProfile profile = strava.athleteOperations().getAthleteProfile();
		assertEquals("John Applestrava", profile.getName());
		assertEquals("john@applestrava.com", profile.getEmail());
		assertEquals(227615, profile.getId());
        assertEquals("http://pics.com/227615/medium.jpg", profile.getAvatarMedium());
        assertEquals("http://pics.com/227615/large.jpg", profile.getAvatarLarge());
	}

	@Test
	public void getAthleteById() throws Exception {
		mockServer.expect(requestTo("https://www.strava.com/api/v3/athletes/5678")).andExpect(method(GET))
				.andExpect(header("Authorization", "Bearer ACCESS_TOKEN"))
				.andRespond(withSuccess(new ClassPathResource("athlete.json", getClass()), MediaType.APPLICATION_JSON));
		StravaAthleteProfile profile = strava.athleteOperations().getAthleteProfileById("5678");
		assertEquals("John Applestrava", profile.getName());
		assertEquals(227615, profile.getId());
		assertEquals("http://pics.com/227615/medium.jpg", profile.getAvatarMedium());
		assertEquals("http://pics.com/227615/large.jpg", profile.getAvatarLarge());
	}

	@Test
	public void getProfileId() {
		mockServer.expect(requestTo("https://www.strava.com/api/v3/athlete")).andExpect(method(GET))
				.andExpect(header("Authorization", "Bearer ACCESS_TOKEN"))
				.andRespond(withSuccess(new ClassPathResource("profile.json", getClass()), MediaType.APPLICATION_JSON));
		assertEquals("227615", strava.athleteOperations().getProfileId());
	}

	@Test
	public void getProfileUrl() {
		mockServer.expect(requestTo("https://www.strava.com/api/v3/athlete")).andExpect(method(GET))
				.andExpect(header("Authorization", "Bearer ACCESS_TOKEN"))
				.andRespond(withSuccess(new ClassPathResource("profile.json", getClass()), MediaType.APPLICATION_JSON));
		assertEquals("https://www.strava.com/athletes/227615", strava.athleteOperations().getProfileUrl());
	}


}

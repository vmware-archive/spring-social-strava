/*
 * Copyright 2013 the original author or authors.
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
package org.springframework.social.strava.connect;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.strava.api.Strava;
import org.springframework.social.strava.api.AthleteOperations;
import org.springframework.social.strava.api.StravaAthleteProfile;

public class StravaAdapterTest {

	private StravaAdapter apiAdapter = new StravaAdapter();
	
	private Strava strava = Mockito.mock(Strava.class);
	
	@Test
	public void fetchProfile() {
		AthleteOperations athleteOperations = Mockito.mock(AthleteOperations.class);
		when(strava.athleteOperations()).thenReturn(athleteOperations);
		when(athleteOperations.getAthleteProfile()).thenReturn(createProfile(123456L, "Craig", "Walls", "cwalls@example.com"));
        UserProfile profile = apiAdapter.fetchUserProfile(strava);
        assertEquals("Craig Walls", profile.getName());
        assertEquals("cwalls@example.com", profile.getEmail());
        assertEquals("cwalls@example.com", profile.getUsername());
	}

    private StravaAthleteProfile createProfile(long id, String firstName, String lastName, String email) {
        return new StravaAthleteProfile(id, firstName, lastName, email);
    }
}
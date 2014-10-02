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
package org.springframework.social.strava.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.strava.api.Strava;
import org.springframework.social.strava.api.StravaAthleteProfile;
import org.springframework.web.client.HttpClientErrorException;

public class StravaAdapter implements ApiAdapter<Strava> {

	public boolean test(Strava strava) {
		try {
			strava.athleteOperations().getAthleteProfile();
			return true;
		} catch (HttpClientErrorException e) {
			// TODO : Beef up Strava's error handling and trigger off of a more specific exception
			return false;
		}
	}

	public void setConnectionValues(Strava strava, ConnectionValues values) {
        StravaAthleteProfile profile = strava.athleteOperations().getAthleteProfile();
		values.setProviderUserId(String.valueOf(profile.getId()));		
		values.setDisplayName(profile.getName());
		values.setProfileUrl("https://www.strava.com/athlete/" + profile.getId()); // TODO: Expose and use HTML URL
	}

	public UserProfile fetchUserProfile(Strava strava) {
        StravaAthleteProfile profile = strava.athleteOperations().getAthleteProfile();
		return new UserProfileBuilder().setName(profile.getName()).setEmail(profile.getEmail()).setUsername(profile.getEmail()).build();
	}

	public void updateStatus(Strava strava, String message) {
		// not supported
	}

}

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
package org.springframework.social.strava.api.impl;

import static java.util.Arrays.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.social.strava.api.StravaAthleteProfile;
import org.springframework.social.strava.api.StravaSegment;
import org.springframework.social.strava.api.AthleteOperations;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * User template implementation.
 * </p>
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 * @author Andy Wilkinson
 */
public class AthleteTemplate extends AbstractStravaOperations implements AthleteOperations {

	private final RestTemplate restTemplate;
	
	/**
	 * @param restTemplate A RestTemplate
	 * @param isAuthorizedForUser Boolean indicating whether the RestTemplate is authorized for a user
	 */
	public AthleteTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	public String getProfileId() {
		return String.valueOf(getAthleteProfile().getId());
	}

	public StravaAthleteProfile getAthleteProfile() {
		return restTemplate.getForObject(buildUri("/athlete"), StravaAthleteProfile.class);
	}

	public String getProfileUrl() {
		return "https://www.strava.com/athletes/" + getProfileId();
	}

    public List<StravaSegment> getSegments(String user) {
        return asList(new StravaSegment());
    }

	private String buildAthleteUri(String path) {
		return buildUri("/athlete/{athlete}" + path);
	}
	
	private Date toDate(String dateString, DateFormat dateFormat) {
		try {
			return dateFormat.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.ENGLISH);
	
}

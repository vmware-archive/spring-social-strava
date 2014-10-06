/*
 * Copyright 2013-2012 the original author or authors.
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

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.strava.api.SegmentEffortOperations;
import org.springframework.social.strava.api.Strava;
import org.springframework.social.strava.api.AthleteOperations;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;
import org.springframework.social.strava.api.impl.json.StravaModule;

/**
 * <p>
 * The central class for interacting with Strava.
 * </p>
 */
public class StravaTemplate extends AbstractOAuth2ApiBinding implements Strava {
    private AthleteOperations athleteOperations;
    private SegmentEffortOperations segmentEffortOperations;

    /**
     * No-arg constructor to support cases in which you want to call the Strava
     * API without requiring authorization. This is useful for public operations,
     * such as getting the list of watchers for a public repository.
     */
    public StravaTemplate() {
        super();
        initSubApis();
    }

    /**
     * Constructs a StravaTemplate with the minimal amount of information
     * required to sign requests with an OAuth <code>Authorization</code>
     * header.
     *
     * @param accessToken An access token granted to the application after OAuth
     *                    authentication.
     */
    public StravaTemplate(String accessToken) {
        super(accessToken);
        initSubApis();
    }

    @Override
    protected OAuth2Version getOAuth2Version() {
        return OAuth2Version.BEARER;
    }

    public AthleteOperations athleteOperations() {
        return athleteOperations;
    }

    @Override
    protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
        MappingJackson2HttpMessageConverter converter = super.getJsonMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new StravaModule());
        converter.setObjectMapper(objectMapper);
        return converter;
    }

    // internal helpers

    private void initSubApis() {
        this.athleteOperations = new AthleteTemplate(getRestTemplate(), isAuthorized());
        this.segmentEffortOperations = new SegmentEffortTemplate(getRestTemplate(), isAuthorized());
    }

    public SegmentEffortOperations segmentEffortOperations() {
        return segmentEffortOperations;
    }
}

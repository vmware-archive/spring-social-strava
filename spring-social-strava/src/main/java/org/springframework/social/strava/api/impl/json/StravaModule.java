/*
 * Copyright 2014 the original author or authors.
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
package org.springframework.social.strava.api.impl.json;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.social.strava.api.*;

/**
 * Jackson module for setting up mixin annotations on Strava model types.
 *
 * @author Andy Wilkinson
 */
public class StravaModule extends SimpleModule {

    public StravaModule() {
        super("StravaModule");
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(StravaAthleteProfile.class, StravaAthleteProfileMixin.class);
        context.setMixInAnnotations(StravaSegmentEffort.class, StravaSegmentEffortMixin.class);
        context.setMixInAnnotations(StravaSegmentEffortAthlete.class, StravaSegmentEffortAthleteMixin.class);
        context.setMixInAnnotations(StravaSegment.class, StravaSegmentMixin.class);
        context.setMixInAnnotations(StravaSegment.class, StravaSegmentDetailsMixin.class);
        context.setMixInAnnotations(StravaMap.class, StravaMapMixin.class);
        context.setMixInAnnotations(StravaActivity.class, StravaActivityMixin.class);
    }
}

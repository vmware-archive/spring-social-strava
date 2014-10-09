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
package org.springframework.social.strava.api;

import org.springframework.social.ApiBinding;

/**
 * Interface specifying a basic set of operations for interacting with Strava.
 * Implemented by {@link org.springframework.social.strava.api.impl.StravaTemplate}.
 * 
 * Many of the methods contained in this interface require OAuth authentication
 * with Strava. When a method's description speaks of the "current user", it is
 * referring to the user for whom the access token has been issued.
 * 
 */
public interface Strava extends ApiBinding {
	/**
	 * Returns the portion of the Strava API containing the user operations.
	 * 
	 * @return athlete operations
	 */
	AthleteOperations athleteOperations();

	/**
	 * Returns the portion of the Strava API containing the segment effort operations.
	 *
	 * @return segment effort operations
	 */
	SegmentEffortOperations segmentEffortOperations();

	/**
	 * Returns the portion of the Strava API containing the segment operations.
	 *
	 * @return segment operations
	 */
	SegmentOperations segmentOperations();
}

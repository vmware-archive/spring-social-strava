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

import org.springframework.social.MissingAuthorizationException;

/**
 * <p>
 * Based on <code>AbstractStravaOperations</code>, by Keith Donald.
 * </p>
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
class AbstractStravaOperations {
	private final boolean isAuthorized;
	
	public AbstractStravaOperations(boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
	}
	
	protected void requireAuthorization() {
		if (!isAuthorized) {
			throw new MissingAuthorizationException("strava");
		}
	}
	
	// Using String here instead of URI so I can include braces in the path. See, e.g., RepoTemplate. [WLW]
	protected String buildUri(String path) {
//		return URIBuilder.fromUri(API_URL_BASE + path).build();
		return API_URL_BASE + path;
	}
	
	// Strava API v3
	private static final String API_URL_BASE = "https://www.strava.com/api/v3";
}

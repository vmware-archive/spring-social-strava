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
package org.springframework.social.strava.config.xml;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser;
import org.springframework.social.config.xml.ApiHelper;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.strava.api.Strava;
import org.springframework.social.strava.api.impl.StravaTemplate;
import org.springframework.social.strava.connect.StravaConnectionFactory;
import org.springframework.social.strava.security.StravaAuthenticationService;
import org.springframework.social.security.provider.SocialAuthenticationService;

/**
 * Implementation of {@link AbstractConnectionFactoryBeanDefinitionParser} that creates a {@link org.springframework.social.strava.connect.StravaConnectionFactory}.
 * @author Craig Walls
 */
class StravaConfigBeanDefinitionParser extends AbstractProviderConfigBeanDefinitionParser {

	public StravaConfigBeanDefinitionParser() {
		super(StravaConnectionFactory.class, GitHubApiHelper.class);
	}
	
	@Override
	protected Class<? extends SocialAuthenticationService<?>> getAuthenticationServiceClass() {
		return StravaAuthenticationService.class;
	}
	
	@Override
	protected BeanDefinition getConnectionFactoryBeanDefinition(String appId, String appSecret, Map<String, Object> allAttributes) {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(StravaConnectionFactory.class).addConstructorArgValue(appId).addConstructorArgValue(appSecret);
		return builder.getBeanDefinition();
	}

	static class GitHubApiHelper implements ApiHelper<Strava> {

		private final UsersConnectionRepository usersConnectionRepository;

		private final UserIdSource userIdSource;

		private GitHubApiHelper(UsersConnectionRepository usersConnectionRepository, UserIdSource userIdSource) {
			this.usersConnectionRepository = usersConnectionRepository;
			this.userIdSource = userIdSource;		
		}

		public Strava getApi() {
			if (logger.isDebugEnabled()) {
				logger.debug("Getting API binding instance for Strava");
			}
			
			Connection<Strava> connection = usersConnectionRepository.createConnectionRepository(userIdSource.getUserId()).findPrimaryConnection(Strava.class);
			if (logger.isDebugEnabled() && connection == null) {
				logger.debug("No current connection; Returning default StravaTemplate instance.");
			}
			return connection != null ? connection.getApi() : new StravaTemplate();
		}

		private final static Log logger = LogFactory.getLog(GitHubApiHelper.class);

	}
	
}

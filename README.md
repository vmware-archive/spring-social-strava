# Spring Social Strava

To check out the project and build from source, do the following:

    git clone git://github.com/pivotal/spring-social-strava.git
    cd spring-social-strava
    ./gradlew build

Use the `Strava Connection Factory` to obtain an OAuth2 connection to strava.
    
    StravaConnectionFactory(CLIENT_ID, CLIENT_SECRET)
    
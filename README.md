# Strava-API
[![Build Status](https://travis-ci.org/simplaapliko/strava-api.svg)](https://travis-ci.org/simplaapliko/strava-api)
[![Release](https://jitpack.io/v/simplaapliko/strava-api.svg)](https://jitpack.io/#simplaapliko/strava-api)

## Usage

**Gradle**

Add the following to your `build.gradle`:
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    ...
    
    // add specific version
    implementation 'com.github.simplaapliko.strava-api:auth:x.y.z'
    implementation 'com.github.simplaapliko.strava-api:common:x.y.z'
    implementation 'com.github.simplaapliko.strava-api:coroutine:x.y.z'
    implementation 'com.github.simplaapliko.strava-api:rxjava2:x.y.z'
    
    // or a snapshot
    // implementation 'com.github.simplaapliko.strava-api:auth:master-SNAPSHOT'
}
```

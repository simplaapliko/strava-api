/*
 * Copyright (C) 2018 Oleg Kan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.simplaapliko.strava.api

object Auth {

    enum class ApprovalPrompt (val id: String) {
        AUTO("auto"),
        FORCE("force");

        override fun toString(): String {
            return id
        }
    }

    enum class Scope(val id: String) {
        /**
         * read public segments, public routes, public profile data, public posts, public events,
         * club feeds, and leaderboards
         */
        READ("read"),

        /**
         * read private routes, private segments, and private events for the user
         */
        READ_ALL("read_all"),

        /**
         * read all profile information even if the user has set their profile visibility to Followers or Only You
         */
        PROFILE_READ_ALL("profile:read_all"),

        /**
         * update the user's weight and Functional Threshold Power (FTP),
         * and access to star or unstar segments on their behalf
         */
        PROFILE_READ_WRITE("profile:write"),

        /**
         * read the user's activity data for activities that are visible to Everyone and Followers,
         * excluding privacy zone data
         */
        ACTIVITY_READ("activity:read"),

        /**
         * the same access as activity:read,
         * plus privacy zone data and access to read the user's activities with visibility set to Only You
         */
        ACTIVITY_READ_ALL("activity:read_all"),

        /**
         * access to create manual activities and uploads,
         * and access to edit any activities that are visible to the app, based on activity read access level
         */
        ACTIVITY_WRITE("activity:write");

        override fun toString(): String {
            return id
        }
    }

    object UrlBuilder {
        const val BASE_URL = "https://www.strava.com/oauth/mobile/"
        const val AUTHORIZE = "authorize"

        /**
         * @param clientId The application’s ID, obtained during registration.
         * @param redirectUri URL to which the user will be redirected after authentication.
         * Must be within the callback domain specified by the application.
         * localhost and 127.0.0.1 are white-listed.
         * @param approvalPrompt force or auto, use force to always show the authorization prompt
         * even if the user has already authorized the current application, default is auto.
         * @param scope Requested scopes, as a comma delimited string,
         * e.g. "activity:read_all,activity:write".
         * @param state Returned in the redirect URI.
         * Useful if the authentication is done from various points in an app.
         */
        fun build(
            clientId: Int,
            redirectUri: String,
            scope: Scope,
            approvalPrompt: ApprovalPrompt = ApprovalPrompt.AUTO,
            state: String = "authorize"
        ): String {
            return build(clientId, redirectUri, listOf(scope), approvalPrompt, state)
        }

        /**
         * @param clientId The application’s ID, obtained during registration.
         * @param redirectUri URL to which the user will be redirected after authentication.
         * Must be within the callback domain specified by the application.
         * localhost and 127.0.0.1 are white-listed.
         * @param scopes Requested scopes, as a comma delimited string,
         * e.g. "activity:read_all,activity:write".
         * @param approvalPrompt force or auto, use force to always show the authorization prompt
         * even if the user has already authorized the current application, default is auto.
         * @param state Returned in the redirect URI.
         * Useful if the authentication is done from various points in an app.
         */
        fun build(
            clientId: Int,
            redirectUri: String,
            scopes: List<Scope>,
            approvalPrompt: ApprovalPrompt = ApprovalPrompt.AUTO,
            state: String = "authorize"
        ): String {
            val commaSeparatedScope = scopes.joinToString(separator = ",") { it -> it.id }

            return "$BASE_URL$AUTHORIZE" +
                    "?response_type=code" +
                    "&client_id=$clientId" +
                    "&redirect_uri=$redirectUri" +
                    "&approval_prompt=$approvalPrompt" +
                    "&scope=$commaSeparatedScope" +
                    "&state=$state"
        }
    }
}

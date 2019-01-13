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

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class AuthUrlBuilderTest {

    @Test
    fun build_singleScope() {
        val clientId = 101
        val redirectUri = "http://localhost/token_exchange"
        val scope = AuthUrlBuilder.Scope.READ_ALL

        val url = AuthUrlBuilder.build( clientId, redirectUri, scope)

        val expectedUrl = "https://www.strava.com/oauth/mobile/authorize?response_type=code" +
                "&client_id=101&redirect_uri=http://localhost/token_exchange&approval_prompt=auto" +
                "&scope=read_all&state=authorize"

        assertThat(url).isEqualTo(expectedUrl)
    }

    @Test
    fun build_listOfScopes() {
        val clientId = 101
        val redirectUri = "http://localhost/token_exchange"
        val scopes = listOf(AuthUrlBuilder.Scope.READ_ALL, AuthUrlBuilder.Scope.PROFILE_READ_ALL)

        val url = AuthUrlBuilder.build(clientId, redirectUri, scopes)

        val expectedUrl = "https://www.strava.com/oauth/mobile/authorize?response_type=code" +
                "&client_id=101&redirect_uri=http://localhost/token_exchange&approval_prompt=auto" +
                "&scope=read_all,profile:read_all&state=authorize"

        assertThat(url).isEqualTo(expectedUrl)
    }

    @Test
    fun build_provideState() {
        val clientId = 101
        val redirectUri = "http://localhost/token_exchange"
        val scope = AuthUrlBuilder.Scope.READ_ALL
        val state = "state"

        val url = AuthUrlBuilder.build(clientId = clientId, redirectUri = redirectUri, scope = scope, state = state)

        val expectedUrl = "https://www.strava.com/oauth/mobile/authorize?response_type=code" +
                "&client_id=101&redirect_uri=http://localhost/token_exchange&approval_prompt=auto" +
                "&scope=read_all&state=state"

        assertThat(url).isEqualTo(expectedUrl)
    }

    @Test
    fun build_provideApprovalPrompt() {
        val clientId = 101
        val redirectUri = "http://localhost/token_exchange"
        val scope = AuthUrlBuilder.Scope.READ_ALL
        val approvalPrompt = AuthUrlBuilder.ApprovalPrompt.FORCE

        val url = AuthUrlBuilder.build(clientId = clientId, redirectUri = redirectUri, scope = scope,
            approvalPrompt = approvalPrompt)

        val expectedUrl = "https://www.strava.com/oauth/mobile/authorize?response_type=code" +
                "&client_id=101&redirect_uri=http://localhost/token_exchange&approval_prompt=force" +
                "&scope=read_all&state=authorize"

        assertThat(url).isEqualTo(expectedUrl)
    }
}

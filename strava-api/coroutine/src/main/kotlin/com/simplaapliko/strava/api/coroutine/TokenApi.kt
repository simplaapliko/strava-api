// Generated code, do not modify.
package com.simplaapliko.strava.api.coroutine

import com.simplaapliko.strava.model.RefreshToken
import com.simplaapliko.strava.model.Token
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

public interface TokenApi {
    /**
     * @param clientId The application’s ID, obtained during registration.
     * @param clientSecret The application’s secret, obtained during registration.
     * @param code The 'code' parameter obtained in the redirect.
     * @param grantType The grant type for the request.
     *      For initial authentication, must always be "authorization_code".
     */
    @FormUrlEncoded
    @POST("oauth/token")
    public suspend fun token(
        @Field("client_id") clientId: Int,
        @Field("client_secret") clientSecret: String,
        @Field("code") code: String,
        @Field("grant_type") grantType: String = "authorization_code",
    ): Token

    /**
     * @param clientId The application’s ID, obtained during registration.
     * @param clientSecret The application’s secret, obtained during registration.
     * @param refreshToken The refresh token obtained for this user,
     *      to be used to get the next access token for this user.
     * @param grantType The grant type for the request.
     *      When refreshing an access token, must always be "refresh_token".
     */
    @FormUrlEncoded
    @POST("oauth/token")
    public suspend fun refreshToken(
        @Field("client_id") clientId: Int,
        @Field("client_secret") clientSecret: String,
        @Field("refresh_token") refreshToken: String,
        @Field("grant_type") grantType: String = "refresh_token",
    ): RefreshToken

    /**
     * @param accessToken Responds with the refresh tokens that were revoked.
     */
    @FormUrlEncoded
    @POST("oauth/deauthorize")
    public suspend fun deauthorize(@Field("access_token") accessToken: String)
}

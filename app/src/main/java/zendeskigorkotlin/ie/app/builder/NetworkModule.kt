package zendeskigorkotlin.ie.app.builder

/**
 * Created by igorfrankiv on 07/10/2018.
 */
import javax.inject.Named

import dagger.Module
import dagger.Provides
import okhttp3.Credentials
import okhttp3.OkHttpClient
import zendeskigorkotlin.ie.app.builder.helpers.AuthenticationInterceptor
import zendeskigorkotlin.ie.constants.UserParam

/*** Created by igorfrankiv on 27/04/2018. */

@Module
class NetworkModule {
    @IAppScope
    @Provides
    @Named("ZendeskServiceNew")
    fun authenticationInterceptor(): AuthenticationInterceptor {
        return AuthenticationInterceptor(Credentials.basic(UserParam.USERNAME,
                UserParam.PASSWORD))
    }

    @IAppScope
    @Provides
    @Named("ZendeskServiceNew")
    fun okHttpClient(@Named("ZendeskServiceNew") authenticationInterceptor: AuthenticationInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addNetworkInterceptor(authenticationInterceptor).build()
    }
}
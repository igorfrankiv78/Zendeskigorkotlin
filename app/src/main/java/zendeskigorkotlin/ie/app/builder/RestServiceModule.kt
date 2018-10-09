package zendeskigorkotlin.ie.app.builder

import com.twistedequations.mvl.rx.AndroidRxSchedulers
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import zendeskigorkotlin.ie.constants.UserParam
import zendeskigorkotlin.ie.zendesk.ZendeskService
import javax.inject.Named

/*** Created by igorfrankiv on 07/10/2018.*/
@Module
class RestServiceModule {

    @IAppScope
    @Provides
    fun zendeskService(@Named("ZendeskServiceNew") okHttpClient: OkHttpClient, androidSchedulers: AndroidRxSchedulers
    ): ZendeskService {
        return Retrofit.Builder().baseUrl(UserParam.API_BASE_URL).
                addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(androidSchedulers.network())).
                addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build().create(ZendeskService::class.java)
    }
}
package zendeskigorkotlin.ie.app.builder

import dagger.Component
import android.content.Context
import zendeskigorkotlin.ie.zendesk.ZendeskService
import com.twistedequations.mvl.rx.AndroidRxSchedulers
/*** Created by igorfrankiv on 07/10/2018.*/

@IAppScope
@Component(modules = arrayOf(RxMvpAppModule::class, NetworkModule::class, RestServiceModule::class, RxModule::class))
interface IRxMvpAppComponent {

    fun context(): Context
    fun rxSchedulers(): AndroidRxSchedulers
    fun zendeskService(): ZendeskService
}
package zendeskigorkotlin.ie.app.builder

/**
 * Created by igorfrankiv on 07/10/2018.
 */
import dagger.Module
import dagger.Provides
import com.twistedequations.mvl.rx.AndroidRxSchedulers
import zendeskigorkotlin.ie.app.builder.helpers.MyAndroidRxSchedulers

@Module
class RxModule {

    @IAppScope
    @Provides
    fun rxSchedulers():AndroidRxSchedulers = MyAndroidRxSchedulers()

}
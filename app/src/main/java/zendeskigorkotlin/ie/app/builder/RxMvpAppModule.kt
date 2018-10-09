package zendeskigorkotlin.ie.app.builder

/**
 * Created by igorfrankiv on 07/10/2018.
 */
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class RxMvpAppModule {

    private val context:Context;

    constructor( context: Context) {
        this.context = context;
    }

    @Provides
    @IAppScope
    fun context():Context {
        return context;
    }
}
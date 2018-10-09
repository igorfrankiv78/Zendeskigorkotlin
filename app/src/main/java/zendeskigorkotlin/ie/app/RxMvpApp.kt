package zendeskigorlibrary.ie.app

/*** Created by igorfrankiv on 26/02/2018.*/
import android.app.Activity
import android.app.Application
import android.app.Service
import android.os.Build
import android.webkit.WebView
import zendeskigorkotlin.ie.app.builder.DaggerIRxMvpAppComponent
import zendeskigorkotlin.ie.app.builder.IRxMvpAppComponent
import zendeskigorkotlin.ie.app.builder.RxMvpAppModule

class RxMvpApp  : Application() {

    companion object {

        @JvmStatic
        fun get(activity: Activity): RxMvpApp {
            return activity.application as RxMvpApp
        }

        @JvmStatic
        fun get(service: Service): RxMvpApp {
            return service.application as RxMvpApp
        }
    }

    private val IRxMvpAppComponent: IRxMvpAppComponent by lazy {
        DaggerIRxMvpAppComponent.builder().rxMvpAppModule(RxMvpAppModule(this)).build()
    }

    override fun onCreate() {
        super.onCreate()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true)
        }
    }

    fun component(): IRxMvpAppComponent {
        return IRxMvpAppComponent
    }
}
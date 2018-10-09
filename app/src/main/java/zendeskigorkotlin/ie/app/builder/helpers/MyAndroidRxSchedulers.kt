package zendeskigorkotlin.ie.app.builder.helpers

/**
 * Created by igorfrankiv on 07/10/2018.
 */
import rx.Scheduler;
import rx.schedulers.Schedulers;
import com.twistedequations.mvl.rx.AndroidRxSchedulers;

class MyAndroidRxSchedulers:AndroidRxSchedulers {

    override fun network():Scheduler {
        return Schedulers.immediate();
    }

    override fun io():Scheduler {
        return Schedulers.immediate();
    }

    override fun computation():Scheduler {
        return Schedulers.immediate();
    }

    override fun newThread():Scheduler {
        return Schedulers.immediate();
    }

    override fun immediate(): Scheduler {
        return Schedulers.immediate();
    }

    override fun mainThread(): Scheduler {
        return Schedulers.immediate();
    }
}
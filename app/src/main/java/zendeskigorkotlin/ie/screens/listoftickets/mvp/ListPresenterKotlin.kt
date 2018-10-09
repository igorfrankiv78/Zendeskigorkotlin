package zendeskigorkotlin.ie.screens.listoftickets.mvp

/*** Created by igorfrankiv on 07/10/2018. ***/
import rx.Observable
import rx.Subscription
import javax.inject.Inject
import rx.functions.Action1
import rx.subscriptions.CompositeSubscription
import com.twistedequations.mvl.rx.AndroidRxSchedulers
import zendeskigorkotlin.ie.model.TicketsResults

class ListPresenterKotlin {

    private val mIListView: IListViewKotlin
    private val mListModelKotlin: ListModelKotlin
    private val mSchedulers: AndroidRxSchedulers
    private val compositeSubscription = CompositeSubscription()

    @Inject
    constructor(iListView: IListViewKotlin, mListModelKotlin: ListModelKotlin, schedulers: AndroidRxSchedulers) {
        this.mIListView = iListView
        this.mListModelKotlin = mListModelKotlin
        this.mSchedulers = schedulers
    }

    fun onCreate() {
        compositeSubscription.add(getAllTickets())
    }

    fun onDestroy() {
        compositeSubscription.clear()
    }

    private fun getAllTickets(): Subscription {
        return Observable.just(null) //inital load
                // Void is replaced by the underscore sighn
                .flatMap({ _ -> mListModelKotlin.getAllTheTickets() }) //get the tickets data from API Server
                .doOnError({ throwable ->
                    throwable.printStackTrace() //Log errors
                    mIListView.showError(throwable)
                })
                .subscribeOn(mSchedulers.network())
                .observeOn(mSchedulers.mainThread())
                .subscribe(Action1<TicketsResults> { this.mIListView.showTickets(it) }) // display data
    }
}
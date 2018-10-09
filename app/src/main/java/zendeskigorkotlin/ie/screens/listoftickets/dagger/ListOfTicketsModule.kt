package zendeskigorkotlin.ie.screens.listoftickets.dagger

import com.twistedequations.mvl.rx.AndroidRxSchedulers
import dagger.Module
import dagger.Provides
import zendeskigorkotlin.ie.model.TicketsResults
import zendeskigorkotlin.ie.screens.listoftickets.helpers.MyObservable
import zendeskigorkotlin.ie.screens.listoftickets.mvp.IListViewKotlin
import zendeskigorkotlin.ie.screens.listoftickets.mvp.ListModelKotlin
import zendeskigorkotlin.ie.screens.listoftickets.mvp.ListPresenterKotlin
import zendeskigorkotlin.ie.zendesk.ZendeskService

/*** Created by igorfrankiv on 08/10/2018.*/
@Module
class ListOfTicketsModule(internal var mView: IListViewKotlin) {

    @Provides
    fun iListView(): IListViewKotlin {
        return mView
    }

    @Provides
    @ListKotlinScope
    fun homePresenter(iListView: IListViewKotlin, listModel: ListModelKotlin, schedulers: AndroidRxSchedulers): ListPresenterKotlin {
        return ListPresenterKotlin(iListView, listModel, schedulers)
    }

    @Provides
    @ListKotlinScope
    fun listModel(zendeskService: ZendeskService, myObservable: MyObservable<TicketsResults>): ListModelKotlin {
        return ListModelKotlin(zendeskService, myObservable)
    }
}
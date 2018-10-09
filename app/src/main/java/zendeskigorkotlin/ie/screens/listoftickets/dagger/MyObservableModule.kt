package zendeskigorkotlin.ie.screens.listoftickets.dagger

import dagger.Module
import dagger.Provides
import zendeskigorkotlin.ie.model.TicketsResults
import zendeskigorkotlin.ie.screens.listoftickets.helpers.MyObservable

/*** Created by igorfrankiv on 08/10/2018.*/
@Module
class MyObservableModule {
    @ListKotlinScope
    @Provides
    fun myObservable(): MyObservable<TicketsResults> {
        return MyObservable()
    }
}

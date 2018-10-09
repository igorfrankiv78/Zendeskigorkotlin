package zendeskigorkotlin.ie.screens.listoftickets.dagger

/*** Created by igorfrankiv on 07/10/2018.*/
import dagger.Component
import zendeskigorkotlin.ie.app.builder.IRxMvpAppComponent
import zendeskigorkotlin.ie.model.TicketsResults
import zendeskigorkotlin.ie.screens.listoftickets.ListOfTicketsKotlin
import zendeskigorkotlin.ie.screens.listoftickets.helpers.MyObservable

@ListKotlinScope
@Component(modules = arrayOf( MyObservableModule::class, ListOfTicketsModule::class ),
           dependencies = arrayOf(IRxMvpAppComponent::class))
interface IListKotlinComponent {
    fun myObservable(): MyObservable<TicketsResults>
    fun inject(listOfTickets: ListOfTicketsKotlin)
}
package zendeskigorkotlin.ie.screens.listoftickets.mvp

/**
 * Created by igorfrankiv on 06/10/2018.
 */
import rx.Observable
import zendeskigorkotlin.ie.model.TicketsResults

interface IListModelKotlin {
    fun getAllTheTickets(): Observable<TicketsResults>?
}
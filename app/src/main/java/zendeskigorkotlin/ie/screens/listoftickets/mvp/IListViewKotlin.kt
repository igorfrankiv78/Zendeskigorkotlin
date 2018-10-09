package zendeskigorkotlin.ie.screens.listoftickets.mvp

import zendeskigorkotlin.ie.model.Tickets
import zendeskigorkotlin.ie.model.TicketsResults

/*** Created by igorfrankiv on 06/10/2018.*/
interface IListViewKotlin {

    fun showTickets(ticketsResults: TicketsResults)

    fun setLoading(loading:Boolean)

    fun showError(throwable: Throwable)
}
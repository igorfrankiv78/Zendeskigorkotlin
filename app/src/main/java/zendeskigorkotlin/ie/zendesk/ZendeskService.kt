package zendeskigorkotlin.ie.zendesk

/*** Created by igorfrankiv on 07/10/2018.*/
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url
import zendeskigorkotlin.ie.model.TicketsResults
/*** Created by igorfrankiv on 27/04/2018.  */

interface ZendeskService {
    @GET
    fun getTickets(@Url url: String): Call<TicketsResults>
}

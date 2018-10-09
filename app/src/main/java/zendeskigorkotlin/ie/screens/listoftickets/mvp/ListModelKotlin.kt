package zendeskigorkotlin.ie.screens.listoftickets.mvp

/*** Created by igorfrankiv on 06/10/2018.*/
import rx.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import zendeskigorkotlin.ie.constants.UserParam
import zendeskigorkotlin.ie.model.TicketsResults
import zendeskigorkotlin.ie.screens.listoftickets.helpers.MyObservable
import zendeskigorkotlin.ie.zendesk.ZendeskService

class ListModelKotlin(val mZendeskServiceJava: ZendeskService, val myObservable: MyObservable<TicketsResults>):IListModelKotlin
{
    override fun getAllTheTickets(): Observable<TicketsResults>? {

        mZendeskServiceJava.getTickets(UserParam.URL).enqueue(object : Callback<TicketsResults> {
            override fun onResponse(call: Call<TicketsResults>?, response: Response<TicketsResults>?) {
                if (response != null && response.isSuccessful)
                    if (response.body() != null && response.body().results != null)
                        myObservable.add( response.body() )
                    else
                        myObservable.add( TicketsResults(null, response.code() ) )
                 else
                        myObservable.add( TicketsResults(null, null ) )
            }
            override fun onFailure(call: Call<TicketsResults>?, t: Throwable?) {
                myObservable.observable.doOnError({ throwable -> throwable.cause })
            }
        })

        return myObservable.observable
    }
}
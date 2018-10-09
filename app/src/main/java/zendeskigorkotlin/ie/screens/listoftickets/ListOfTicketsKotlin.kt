package zendeskigorkotlin.ie.screens.listoftickets

/*** Created by igorfrankiv on 07/10/2018.*/
import android.util.Log
import javax.inject.Inject
import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import zendeskigorkotlin.ie.R
import zendeskigorkotlin.ie.model.TicketsResults
import zendeskigorkotlin.ie.screens.listoftickets.dagger.DaggerIListKotlinComponent
import zendeskigorkotlin.ie.screens.listoftickets.dagger.ListOfTicketsModule
import zendeskigorkotlin.ie.screens.listoftickets.mvp.IListViewKotlin
import zendeskigorkotlin.ie.screens.listoftickets.mvp.ListPresenterKotlin
import zendeskigorkotlin.ie.screens.listoftickets.viewadapt.ZendeskListViewAdapterKotlin
import zendeskigorlibrary.ie.app.RxMvpApp
/*** Created by igorfrankiv on 30/09/2018. ***/

class ListOfTicketsKotlin: Activity(), IListViewKotlin {

    @Inject
    lateinit var mListPresenter: ListPresenterKotlin

    private var mRecyclerViewVirtical: RecyclerView? = null
    private var mZendeskListViewAdapter: ZendeskListViewAdapterKotlin? = null
    private val error:String = "Error Loading Zendesk Tickets"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView( R.layout.activity_testr)

        DaggerIListKotlinComponent.builder()
                .iRxMvpAppComponent(RxMvpApp.get(this).component())
                .listOfTicketsModule(ListOfTicketsModule(this))
                .build().inject(this)

        mListPresenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        mListPresenter.onDestroy()
    }

    override fun showTickets(ticketsResults: TicketsResults){
        if( ticketsResults != null && ticketsResults.results != null){// Warning:(59, 13) Condition 'ticketsResults != null' is always 'true'
            Log.e("ticketsResults.size = ", ticketsResults.results.size.toString()  );
            mZendeskListViewAdapter = ZendeskListViewAdapterKotlin(ticketsResults, this)
            mRecyclerViewVirtical = findViewById<View>(R.id.recycler_view) as RecyclerView
            val layoutManager = LinearLayoutManager(getApplicationContext());
            mRecyclerViewVirtical!!.setLayoutManager(layoutManager);
            mRecyclerViewVirtical!!.setAdapter(mZendeskListViewAdapter);
        }
        else if( ticketsResults.code != null )
             alertDialog(error +" : "+ticketsResults.code.toString())
        else
             alertDialog( error )
    }

    override fun setLoading(loading:Boolean){
    }

    override fun showError(throwable: Throwable) {
        alertDialog(error)
    }

    fun alertDialog(message: String){
         AlertDialog.Builder(this)
                 .setTitle(message)
                 .setPositiveButton(android.R.string.ok) { dialogInterface, i -> dialogInterface.dismiss() }
                 .show()                                                                                        
    }
}
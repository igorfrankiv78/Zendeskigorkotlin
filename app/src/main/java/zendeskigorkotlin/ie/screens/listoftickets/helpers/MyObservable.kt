package zendeskigorkotlin.ie.screens.listoftickets.helpers

import rx.Observable
import rx.subjects.PublishSubject
/*** Created by igorfrankiv on 05/03/2018. */

class MyObservable<TicketsResults> {

    protected val onAdd: PublishSubject<TicketsResults>
    val observable: Observable<TicketsResults>
        get() = onAdd

    init {
        this.onAdd = PublishSubject.create()
    }

    fun add(value: TicketsResults) {
        onAdd.onNext(value)
    }
}

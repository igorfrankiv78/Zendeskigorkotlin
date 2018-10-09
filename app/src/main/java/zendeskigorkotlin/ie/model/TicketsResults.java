package zendeskigorkotlin.ie.model;

import android.support.annotation.NonNull;

import java.util.List;

/*** Created by igor on 03/06/2017. */
public final class TicketsResults {

    private final List<Tickets> tickets;
    private final Integer code;

    public TicketsResults ( List<Tickets> tickets, Integer code)
    {
       this.tickets = tickets;
       this.code = code;
    }

    public List<Tickets> getResults() {
        return tickets;
    }

    /** HTTP status code. */
    public int getCode() {
        return code;
    }
}

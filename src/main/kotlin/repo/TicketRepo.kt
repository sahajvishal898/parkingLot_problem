package repo

import invoice.Ticket

object TicketRepo {

    val allTickets= mutableMapOf<Int,Ticket>()

    fun addTicket(ticket:Ticket) {
        allTickets[ticket.ticketNo]=ticket
    }

    fun getTicket(ticketNo:Int): Ticket? {
        return allTickets[ticketNo]
    }





}
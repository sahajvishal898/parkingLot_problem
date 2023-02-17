package invoice

import parkingType.VehicleParking
import parkingType.VehicleType
import java.time.LocalDateTime


class Ticket(val ticketNo: Int, val parkingSpotForVehicle: VehicleParking, val spotNo: Int) {

    var date: LocalDateTime = LocalDateTime.now()

    fun getTicketDetails(): String {
        var ticketInvoice = ""
        ticketInvoice += "Parking Ticket:\nTicket Number: $ticketNo\nSpot Number: $spotNo\n" +
                "Entry Date-time: $date"
        return ticketInvoice
    }


}
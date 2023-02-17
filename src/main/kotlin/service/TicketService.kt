package service

import factory.ParkingFactory
import invoice.Ticket
import parkingType.VehicleParking
import repo.TicketRepo

object TicketService {

    fun generateTicket(parkingSpotForVehicle: VehicleParking, parkingSpotNumber: Int): Ticket {

        val ticket = Ticket(ParkingFactory.getTicketNo(), parkingSpotForVehicle, parkingSpotNumber)
        TicketRepo.addTicket(ticket)
        return ticket
    }
}
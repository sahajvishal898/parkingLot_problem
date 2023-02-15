package service

import factory.ParkingFactory
import invoice.Receipt
import invoice.Ticket
import parkingLocation.ParkingArea
import parkingType.*
import repo.TicketRepo
import java.time.LocalDateTime

object ParkingService {

    fun parkVehicle(parkingArea: ParkingArea,vehicle:String): Ticket? {


        val vehicleType= ParkingFactory.getVehicleType(vehicle) ?: return null
        val parkingSpotForVehicle= parkingArea.getParkingForVehicle(vehicleType) ?: return null
        val parkingSpotNumber= parkingSpotForVehicle.getParkingSpot() ?: return null

        val ticket= TicketService.generateTicket(parkingSpotForVehicle,parkingSpotNumber)

        parkingSpotForVehicle.parkVehicleAtSpot(parkingSpotNumber)

        return ticket
    }


    fun unParkVehicle(parkingArea: ParkingArea, ticketNo: Int,dateOfUnparking:LocalDateTime=LocalDateTime.now()): Receipt? {

        val ticket = TicketRepo.getTicket(ticketNo) ?: return null
        val vehicleParking = ticket.parkingSpotForVehicle

        vehicleParking.unparkVechicleFromSpot(ticket.spotNo)

        return ReceiptService.generateReceipt(vehicleParking, ticket,dateOfUnparking)
    }




    fun createParking(
        parkingArea: String, motorcyclesParkingCnt: Int,
        carParkingCount: Int, busParkingCount: Int
    ): ParkingArea? {
        val allParkingLots = ParkingFactory.getAllParkingLotForParking(parkingArea,motorcyclesParkingCnt, carParkingCount, busParkingCount)

        return ParkingFactory.getParkingForLocation(parkingArea,allParkingLots)
    }

}
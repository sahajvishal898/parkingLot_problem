package service

import exception.CustomException
import factory.ParkingFactory
import invoice.Receipt
import invoice.Ticket
import parkingLocation.ParkingArea
import repo.TicketRepo
import java.lang.Exception
import java.time.LocalDateTime

object ParkingService {

    fun parkVehicle(parkingArea: ParkingArea, vehicle: String): Ticket {


        val vehicleType = ParkingFactory.getVehicleType(vehicle) ?: throw CustomException("No vehicle of this type")
        val parkingSpotForVehicle = parkingArea.getParkingForVehicle(vehicleType)
            ?: throw CustomException("No parking for this type of vehicle")
        val parkingSpotNumber = parkingSpotForVehicle.getParkingSpot() ?: throw CustomException("No spot available ")

        val ticket = TicketService.generateTicket(parkingSpotForVehicle, parkingSpotNumber)

        parkingSpotForVehicle.parkVehicleAtSpot(parkingSpotNumber)

        return ticket
    }


    fun unParkVehicle(ticketNo: Int, dateOfUnparking: LocalDateTime = LocalDateTime.now()): Receipt {

        val ticket = TicketRepo.getTicket(ticketNo) ?: throw Exception("No ticket with this no")
        val vehicleParking = ticket.parkingSpotForVehicle

        vehicleParking.unparkVechicleFromSpot(ticket.spotNo)

        return ReceiptService.generateReceipt(vehicleParking, ticket, dateOfUnparking)
    }


    fun createParking(
        parkingArea: String, motorcyclesParkingCnt: Int,
        carParkingCount: Int, busParkingCount: Int
    ): ParkingArea? {
        val allParkingLots = ParkingFactory.getAllParkingLotForParking(
            parkingArea,
            motorcyclesParkingCnt,
            carParkingCount,
            busParkingCount
        )

        return ParkingFactory.getParkingForLocation(parkingArea, allParkingLots)
    }

}
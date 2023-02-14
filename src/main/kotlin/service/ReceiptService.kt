package service

import factory.ParkingFactory
import invoice.Receipt
import invoice.Ticket
import parkingType.VehicleParking
import java.time.Duration
import java.time.LocalDateTime


object ReceiptService {

    fun generateReceipt(vehicleParking: VehicleParking, ticket: Ticket,dateOfUnparking:LocalDateTime): Receipt {

        val durationInHours = Duration.between(ticket.date,dateOfUnparking).toHours().toInt()

        val fee = vehicleParking.parkingFees.getTotalFees(durationInHours)

        return Receipt(ParkingFactory.getReceiptNo(), ticket.date, dateOfUnparking, fee)

    }

}
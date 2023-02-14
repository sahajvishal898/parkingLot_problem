package factory

import parkingLocation.AirportParking
import parkingLocation.MallParking
import parkingLocation.ParkingArea
import parkingLocation.StadiumParking
import parkingType.*

object ParkingFactory {

    var ticketNumber: Int =1
    var receiptNumber: Int =1

    fun getTicketNo(): Int {
        return ticketNumber++
    }
    fun getReceiptNo(): Int {
        return receiptNumber++
    }

    fun getParkingForLocation(parkingLocation:String, allParkingLot:MutableList<VehicleParking>): ParkingArea? {

        if(parkingLocation=="Mall")
            return MallParking(allParkingLot)
        if(parkingLocation=="Stadium")
            return StadiumParking(allParkingLot)
        if(parkingLocation=="Airport")
            return AirportParking(allParkingLot)
        return null
    }

    fun getVehicleType(vehicleType:String): VehicleType? {

        if(vehicleType=="Motorcycle" || vehicleType=="Scooter")
            return VehicleType.MOTORCYCLE
        if(vehicleType=="Car" || vehicleType=="Suv")
            return VehicleType.CAR
        if(vehicleType=="Bus" || vehicleType=="Truck")
            return VehicleType.BUS
        return null
    }



}
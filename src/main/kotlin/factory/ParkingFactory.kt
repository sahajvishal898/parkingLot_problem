package factory

import fees.*
import parkingLocation.AirportParking
import parkingLocation.MallParking
import parkingLocation.ParkingArea
import parkingLocation.StadiumParking
import parkingType.*

object ParkingFactory {

    var ticketNumber: Int = 1
    var receiptNumber: Int = 1

    fun getTicketNo(): Int {
        return ticketNumber++
    }

    fun getReceiptNo(): Int {
        return receiptNumber++
    }

    fun getParkingForLocation(parkingLocation: String, allParkingLot: MutableList<VehicleParking>): ParkingArea? {

        if (parkingLocation == "Mall")
            return MallParking(allParkingLot)
        if (parkingLocation == "Stadium")
            return StadiumParking(allParkingLot)
        if (parkingLocation == "Airport")
            return AirportParking(allParkingLot)
        return null
    }

    fun getAllParkingLotForParking(
        parkingArea: String,
        motorcyclesParkingCnt: Int,
        carParkingCount: Int,
        busParkingCount: Int
    ): MutableList<VehicleParking> {

        val allParkingLots = mutableListOf<VehicleParking>()

        if (parkingArea == "Mall") {
            val motorcyclesParking = MotorcyclesParking(motorcyclesParkingCnt, MotorcycleFeeInMall())
            val carParking = CarsParking(carParkingCount, CarParkingFeeInMall())
            val busParking = BusParking(busParkingCount, BusParkingFeeInMall())
            allParkingLots.add(motorcyclesParking)
            allParkingLots.add(carParking)
            allParkingLots.add(busParking)

        }
        if (parkingArea == "Stadium") {
            val motorcyclesParking = MotorcyclesParking(motorcyclesParkingCnt, MotorcycleFeeInStadium())
            val carParking = CarsParking(carParkingCount, CarParkingFeeInStadium())
            allParkingLots.add(motorcyclesParking)
            allParkingLots.add(carParking)
        }
        if (parkingArea == "Airport") {
            val motorcyclesParking = MotorcyclesParking(motorcyclesParkingCnt, MotorcycleFeeInAirport())
            val carParking = CarsParking(carParkingCount, CarParkingFeeInAirport())
            allParkingLots.add(motorcyclesParking)
            allParkingLots.add(carParking)
        }
        return allParkingLots
    }

    fun getVehicleType(vehicleType: String): VehicleType? {

        if (vehicleType == "Motorcycle" || vehicleType == "Scooter")
            return VehicleType.MOTORCYCLE
        if (vehicleType == "Car" || vehicleType == "Suv")
            return VehicleType.CAR
        if (vehicleType == "Bus" || vehicleType == "Truck")
            return VehicleType.BUS
        return null
    }


}
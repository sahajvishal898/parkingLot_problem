package parkingLocation

import parkingType.VehicleParking
import parkingType.VehicleType

open class ParkingArea(var parkingLot:MutableList<VehicleParking>) {

    fun getParkingForVehicle(vehicleType: VehicleType): VehicleParking? {

        for(parkingForVehicle in parkingLot){
            if(parkingForVehicle.lotType==vehicleType)
                return parkingForVehicle
        }
        return null
    }




}
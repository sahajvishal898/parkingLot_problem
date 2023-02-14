package parkingType

import fees.ParkingFees

open class VehicleParking(private val spotSize: Int, val lotType: VehicleType, val parkingFees: ParkingFees) {


    private var spotSchema = arrayListOf<Int>()

    init {
        for (nums in 1..spotSize) {
            spotSchema.add(1)
        }
    }


    fun getParkingSpot(): Int? {
        for (spotNumber in 1..spotSize)
            if (spotSchema[spotNumber] == 1) {
                return spotNumber
            }
        return null
    }

    fun parkVehicleAtSpot(spotNumber: Int) {
        spotSchema[spotNumber] = 0
    }

    fun unparkVechicleFromSpot(spotNo: Int) {
        spotSchema[spotNo] = 1
    }


}
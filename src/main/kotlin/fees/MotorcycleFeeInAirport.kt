package fees

import kotlin.math.ceil

class MotorcycleFeeInAirport:ParkingFees() {

    override fun getTotalFees(parkingDurationInHours: Int): Int {

        var totalFee=0
        if(parkingDurationInHours<1)
            totalFee=0
        if(parkingDurationInHours in 1..7)
            totalFee=40
        if(parkingDurationInHours in 8..23)
            totalFee=60
        if(parkingDurationInHours>23){
            totalFee= ceil(parkingDurationInHours/(24.0)).toInt()*80
        }
        return totalFee
    }


}
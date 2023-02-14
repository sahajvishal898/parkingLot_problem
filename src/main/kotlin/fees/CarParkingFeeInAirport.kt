package fees

import kotlin.math.ceil

class CarParkingFeeInAirport:ParkingFees() {

    override fun getTotalFees(parkingDurationInHours: Int): Int {

        var totalFee=0
        if(parkingDurationInHours in 0..11)
            totalFee=60
        if(parkingDurationInHours in 12..23)
            totalFee=80
        if(parkingDurationInHours>23){
            totalFee= ceil(parkingDurationInHours/(24.0)).toInt()*100
        }
        return totalFee
    }


}
package fees

class CarParkingFeeInStadium :ParkingFees() {

    override fun getTotalFees(parkingDurationInHours: Int): Int {

        var totalFee=0
        if(parkingDurationInHours<4)
            totalFee+=60
        if(parkingDurationInHours>=4 && parkingDurationInHours<12)
            totalFee+=120
        if(parkingDurationInHours>11)
            totalFee+=(parkingDurationInHours-11)*200
        return totalFee
    }


}
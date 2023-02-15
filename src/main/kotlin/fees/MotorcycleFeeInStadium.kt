package fees

class MotorcycleParkingFeeInStadium :ParkingFees() {

    override fun getTotalFees(parkingDurationInHours: Int): Int {

        var totalFee=0
        if(parkingDurationInHours<4)
            totalFee+=30
        if(parkingDurationInHours>=4 && parkingDurationInHours<12)
            totalFee+=60
        if(parkingDurationInHours>11)
            totalFee+=(parkingDurationInHours-11)*100
        return totalFee
    }


}
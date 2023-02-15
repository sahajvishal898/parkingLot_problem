package fees

class CarParkingFeeInStadium :ParkingFees() {

    override fun getTotalFees(parkingDurationInHours: Int): Int {

        var totalFee=0

        if(parkingDurationInHours<4) {
            totalFee+=60
            return totalFee
        }
        totalFee+=30
        if(parkingDurationInHours in 4..11) {
            totalFee += 120
            return totalFee
        }
        totalFee+=60
        if(parkingDurationInHours>11)
            totalFee+=(parkingDurationInHours-11)*200
        return totalFee
    }
}
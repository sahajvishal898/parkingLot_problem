package fees

class CarParkingFeeInMall:ParkingFees() {
    override fun getTotalFees(parkingDurationInHours: Int): Int {

        val feesPerHour = 50

        return parkingDurationInHours * feesPerHour
    }
}
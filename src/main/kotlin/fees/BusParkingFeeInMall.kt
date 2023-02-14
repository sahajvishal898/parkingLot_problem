package fees

class BusParkingFeeInMall:ParkingFees() {
    override fun getTotalFees(parkingDurationInHours: Int): Int {
        val feesPerHour = 20
        return parkingDurationInHours * feesPerHour
    }
}
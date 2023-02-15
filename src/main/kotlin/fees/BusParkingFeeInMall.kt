package fees

class BusParkingFeeInMall:ParkingFees() {
    override fun getTotalFees(parkingDurationInHours: Int): Int {
        val feesPerHour = 50
        return parkingDurationInHours * feesPerHour
    }
}
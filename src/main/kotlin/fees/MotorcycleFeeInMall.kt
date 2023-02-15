package fees

class MotorcycleParkingFeeInMall:ParkingFees() {

    override fun getTotalFees(parkingDurationInHours: Int): Int {

        val feesPerHour = 10

        return parkingDurationInHours * feesPerHour
    }


}
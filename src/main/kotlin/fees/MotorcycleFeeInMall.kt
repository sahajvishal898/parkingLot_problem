package fees

class MotorcycleFeeInMall : ParkingFees() {

    override fun getTotalFees(parkingDurationInHours: Int): Int {

        val feesPerHour = 10

        return parkingDurationInHours * feesPerHour
    }


}
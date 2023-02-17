import factory.ParkingFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import repo.TicketRepo
import service.ParkingService
import java.time.LocalDateTime


class ParkingTest {

    @BeforeEach
    fun `clear all data`() {
        ParkingFactory.ticketNumber = 1
        ParkingFactory.receiptNumber = 1
        TicketRepo.allTickets.clear()
    }

    @Test
    fun `check if proper ticket is generated when first motercycle come in mall`() {
        val parking = ParkingService.createParking("Mall", 10, 20, 10) ?: return

        val ticket1 = ParkingService.parkVehicle(parking, "Motorcycle")

        assertNotNull(ticket1)
        assertEquals(1, ticket1.ticketNo)
        assertEquals(1, ticket1.spotNo)
    }


    @Test
    fun `check if proper ticket is generated when two motorcycles comes in mall`() {
        val parking = ParkingService.createParking("Mall", 10, 20, 10) ?: return

        val ticket1 = ParkingService.parkVehicle(parking, "Motorcycle")
        val ticket2 = ParkingService.parkVehicle(parking, "Motorcycle")

        assertNotNull(ticket1)
        assertNotNull(ticket2)
        assertEquals(1, ticket1.ticketNo)
        assertEquals(1, ticket1.spotNo)
        assertEquals(2, ticket2.ticketNo)
        assertEquals(2, ticket2.spotNo)
    }


    @Test
    fun `check if proper ticket is generated when one motorcycles and one car comes in mall`() {
        val parking = ParkingService.createParking("Mall", 10, 20, 10) ?: return

        val ticket1 = ParkingService.parkVehicle(parking, "Motorcycle")
        val ticket2 = ParkingService.parkVehicle(parking, "Car")

        assertNotNull(ticket1)
        assertNotNull(ticket2)
        assertEquals(1, ticket1.ticketNo)
        assertEquals(1, ticket1.spotNo)
        assertEquals(2, ticket2.ticketNo)
        assertEquals(1, ticket2.spotNo)
    }

    @Test
    fun `check if proper receipt is generated when motorcycle unpark after one hour from Mall`() {
        val parking = ParkingService.createParking("Mall", 10, 20, 10) ?: return

        val ticket1 = ParkingService.parkVehicle(parking, "Motorcycle")
        val receipt1 = ParkingService.unParkVehicle(ticket1.ticketNo, LocalDateTime.now().plusHours(1))

        assertNotNull(ticket1)
        assertNotNull(receipt1)
        assertEquals(1, ticket1.ticketNo)
        assertEquals(1, ticket1.spotNo)
        assertEquals(1, receipt1.receiptNo)
        assertEquals(10, receipt1.fee)
    }

    @Test
    fun `check if proper receipt is generated when car unpark after one hour`() {
        val parking = ParkingService.createParking("Mall", 10, 20, 10) ?: return

        val ticket1 = ParkingService.parkVehicle(parking, "Car")
        val receipt1 = ParkingService.unParkVehicle(ticket1.ticketNo, LocalDateTime.now().plusHours(1))

        assertNotNull(ticket1)
        assertNotNull(receipt1)
        assertEquals(1, ticket1.ticketNo)
        assertEquals(1, ticket1.spotNo)
        assertEquals(1, receipt1.receiptNo)
        assertEquals(20, receipt1.fee)
    }

    @Test
    fun `check if proper ticket and receipt is generated when two motorcycles comes and first one leaves after 2nd arrived`() {
        val parking = ParkingService.createParking("Mall", 10, 20, 10) ?: return

        val ticket1 = ParkingService.parkVehicle(parking, "Motorcycle")
        val ticket2 = ParkingService.parkVehicle(parking, "Motorcycle")
        val receipt1 = ParkingService.unParkVehicle(ticket1.ticketNo)

        assertNotNull(ticket1)
        assertNotNull(ticket2)
        assertNotNull(receipt1)
        assertEquals(1, ticket1.ticketNo)
        assertEquals(1, ticket1.spotNo)
        assertEquals(2, ticket2.ticketNo)
        assertEquals(2, ticket2.spotNo)
        assertEquals(1, receipt1.receiptNo)
    }


    @Test
    fun `check if proper receipt is generated when motorcycle unpark after 13 hour from Stadium`() {
        val parking = ParkingService.createParking("Stadium", 10, 20, 10) ?: return

        val ticket1 = ParkingService.parkVehicle(parking, "Motorcycle")
        val receipt1 = ParkingService.unParkVehicle(ticket1.ticketNo, LocalDateTime.now().plusHours(13))

        assertNotNull(ticket1)
        assertNotNull(receipt1)
        assertEquals(1, ticket1.ticketNo)
        assertEquals(1, ticket1.spotNo)
        assertEquals(1, receipt1.receiptNo)
        assertEquals(290, receipt1.fee)
    }


}
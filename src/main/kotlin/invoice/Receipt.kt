package invoice

import java.time.LocalDateTime

class Receipt(val receiptNo:Int, val entryTime: LocalDateTime, val exitTime: LocalDateTime, val fee:Int) {

    fun getReceiptDetails() : String {
        var receiptInvoice=""
        receiptInvoice+="Parking Receipt:\nReceipt Number: R-$receiptNo\n"+
                 "Entry Date-time: $entryTime\nExit Date-time: $exitTime\nFees: $fee"
        return receiptInvoice
    }
}
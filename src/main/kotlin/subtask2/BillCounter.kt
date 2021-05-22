package subtask2

class BillCounter {

    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val excludedDishPrice = bill[k]
        val splitBill = (bill.sum() - excludedDishPrice) / 2

        if (splitBill == b) return "Bon Appetit"
        return (b - splitBill).toString()
    }
}

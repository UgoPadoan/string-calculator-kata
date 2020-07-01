package stringcalculator

class StringCalculator {

    fun add(numbers: String): Int {
        if(numbers.isEmpty()) return 0
        var sum = 0;
        numbers.split(",").forEach {
            sum+=it.toInt()
        }
        return sum
    }

}
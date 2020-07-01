package stringcalculator

object StringCalculator {
    fun sum(numbers: String): Int {
        return if (numbers.isEmpty()) 0 else numbers.toInt()
    }

}

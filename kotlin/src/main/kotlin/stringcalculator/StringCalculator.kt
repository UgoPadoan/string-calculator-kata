package stringcalculator

class StringCalculator {

    fun add(numbers: String): Int {
        if (numbers.isEmpty()) return 0
        return sum(numbers)
    }

    private fun sum(numbers: String): Int {
        return numbers.split(",", "\n").sumBy { it.toInt() }
    }
}
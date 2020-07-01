package stringcalculator

class StringCalculator {

    fun add(numbers: String): Int {
        if (numbers.isEmpty()) return 0
        return sum(numbers)
    }

    private fun sum(numbers: String): Int {
        var delimiter: String = ""
        var numbersPart: String = numbers
        if(numbers.startsWith("//")) {
            val delimiterAndNumbers = numbers.split("\n")
            delimiter = delimiterAndNumbers.first().removePrefix("//")
            numbersPart = delimiterAndNumbers.last()
        }
        return numbersPart.split(",", "\n", delimiter).sumBy { it.toInt() }
    }
}
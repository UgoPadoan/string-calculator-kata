package stringcalculator

class StringCalculator {

    fun add(numbers: String): Int {
        if (numbers.isEmpty()) return 0
        return sum(numbers)
    }

    private fun sum(numbers: String): Int {
        if (numbers.startsWith("//")) {
            var delimeter = numbers.removePrefix("//").split("\n").first()
            var numbersPart = numbers.removePrefix("//").split("\n").last()
            return numbersPart.split(delimeter).sumBy { it.toInt() }
        }
        else
            return numbers.split(",", "\n").sumBy { it.toInt() }
    }
}
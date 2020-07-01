package stringcalculator

class StringCalculator {

    fun add(numbers: String): Int {
        if (numbers.isEmpty()) return 0
        return sum(numbers)
    }

    private fun sum(numbers: String): Int {
        return if (numbers.startsWith("//")) {
            val (delimiter, numbersPart) = numbers.removePrefix("//").split("\n")
            sum(numbersPart, delimiter.toRegex())
        }
        else
            sum(numbers, "[,\n]".toRegex())
    }

    private fun sum(input: String, delimiter : Regex): Int {
        val numbers = input.split(delimiter)
        val negativeNumbers = numbers.filter { it.isNegative() }
        if (negativeNumbers.isNotEmpty()){
            throw NegativesNotAllowedException("negatives not allowed: " + negativeNumbers.joinToString(","))
        }
        return numbers.sumBy { it.toInt() }
    }

    private fun String.isNegative() = toInt() < 0
}
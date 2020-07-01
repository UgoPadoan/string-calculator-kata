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

    private fun sum(numbers: String, delimiter : Regex) = numbers.split(delimiter).sumBy {
        if(it.isNegative()) throw NegativesNotAllowedException("negatives not allowed")
        it.toInt()
    }

    private fun String.isNegative() = toInt() < 0
}
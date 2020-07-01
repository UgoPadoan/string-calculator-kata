package stringcalculator

object StringCalculator {
    fun sum(delimiterSeparatedNumbers: String): Int {

        var delimiter = "\n,"
        var stringOfNumbers = delimiterSeparatedNumbers


        if (delimiterSeparatedNumbers.startsWith(delimiterPrefix)) {
            delimiter = delimiterSeparatedNumbers.substringBetween(delimiterPrefix, delimiterPostfix)
            stringOfNumbers = delimiterSeparatedNumbers.substringAfter(delimiterPostfix)
        }

        val numbers = stringOfNumbers
                .mapToIntegers(delimiter)
                .filterNot { it > 1000 }

        if (numbers.any { it < 0 }) {
            throw Exception("negatives not allowed: ${numbers.negativeNumbers().joinToString(",")}")
        }

        return numbers.sum()
    }
}

private fun List<Int>.negativeNumbers() = filter { it < 0 }

private fun String.substringBetween(from: String, to: String) =
        substringAfter(from).substringBefore(to)

private fun String.mapToIntegers(delimiter: String): List<Int> {
    return split("[${delimiter}]".toRegex())
            .filterNot { it.isEmpty() }
            .map { it.toInt() }
}

private const val delimiterPrefix = "//"
private const val delimiterPostfix = "\n"
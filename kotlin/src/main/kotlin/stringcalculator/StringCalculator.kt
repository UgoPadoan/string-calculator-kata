package stringcalculator

object StringCalculator {
    fun sum(delimiterSeparatedNumbers: String): Int {

        val (delimiter, stringOfNumbers) = FOO(delimiterSeparatedNumbers)
        val numbers = stringOfNumbers.mapToIntegers(delimiter)

        if (numbers.any { it < 0 })
            throw Exception("negatives not allowed")

        return numbers.sum()
    }

    private fun FOO(delimiterSeparatedNumbers: String): Pair<String, String> {
        val delimiter = "\n,"
        val stringOfNumbers = delimiterSeparatedNumbers

        return if (delimiterSeparatedNumbers.startsWith(delimiterPrefix)) {
            Pair(
                    delimiterSeparatedNumbers.substringBetween(delimiterPrefix, delimiterPostfix),
                    delimiterSeparatedNumbers.substringAfter(delimiterPostfix)
            )
        } else Pair(delimiter, stringOfNumbers)
    }

}

private fun String.substringBetween(from: String, to: String) =
        substringAfter(from).substringBefore(to)

private fun String.mapToIntegers(delimiter: String): List<Int> {
    return split("[${delimiter}]".toRegex())
            .filterNot { it.isEmpty() }
            .map { it.toInt() }
}

private const val delimiterPrefix = "//"
private const val delimiterPostfix = "\n"
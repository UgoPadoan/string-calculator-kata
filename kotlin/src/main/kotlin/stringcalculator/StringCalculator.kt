package stringcalculator

object StringCalculator {
    fun sum(delimiterSeparatedNumbers: String): Int {

        var delimiter = "\n,"
        var stringOfNumbers = delimiterSeparatedNumbers


        if (delimiterSeparatedNumbers.startsWith(delimiterPrefix)) {
            delimiter = delimiterSeparatedNumbers.substringBefore(delimiterPostfix).substringAfter(delimiterPrefix)
            stringOfNumbers = delimiterSeparatedNumbers.substringAfter(delimiterPostfix)
        }

        val numbers = stringOfNumbers
                .split("[${delimiter}]".toRegex())
                .filterNot { it.isEmpty() }
                .map { it.toInt() }
        if (numbers.any { it < 0 })
            throw Exception()
        return numbers.sum()
    }

}

private const val delimiterPrefix = "//"
private const val delimiterPostfix = "\n"
package stringcalculator

object StringCalculator {
    fun sum(commaSeparatedNumbers: String): Int {

        var delimiter = "\n,"
        var numbers = commaSeparatedNumbers;


        if (commaSeparatedNumbers.startsWith(delimiterPrefix)){
            delimiter = commaSeparatedNumbers.substringBefore(delimiterPostFix).substringAfter(delimiterPrefix)
            numbers = commaSeparatedNumbers.substringAfter(delimiterPostFix)
        }

        return numbers
                .split("[${delimiter}]".toRegex())
                .filterNot { it.isEmpty() }
                .sumBy { it.toInt() }

    }

}

private const val delimiterPrefix = "//"
private const val delimiterPostFix = "\n"
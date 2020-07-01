package stringcalculator

object StringCalculator {
    fun sum(commaSeparatedNumbers: String): Int {

        var delimiter = "\n,"
        var numbers = commaSeparatedNumbers;

        if (commaSeparatedNumbers.startsWith("//")){
            delimiter = commaSeparatedNumbers.substring(2, commaSeparatedNumbers.indexOf("\n"))
            numbers = commaSeparatedNumbers.substringAfter("\n")
        }

        return numbers
                .split("[${delimiter}]".toRegex())
                .filterNot { it.isEmpty() }
                .sumBy { it.toInt() }
    }

}

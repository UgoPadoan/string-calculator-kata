package stringcalculator

object StringCalculator {
    fun sum(commaSeparatedNumbers: String): Int {
        return commaSeparatedNumbers
                .split("[\n,]".toRegex())
                .filterNot { it.isEmpty() }
                .sumBy { it.toInt() }
    }

}

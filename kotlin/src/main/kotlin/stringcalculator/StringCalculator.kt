package stringcalculator

object StringCalculator {
    fun sum(commaSeparatedNumbers: String): Int {
        return commaSeparatedNumbers
                .split(",")
                .filterNot { it.isEmpty() }
                .sumBy { it.toInt() }
    }

}

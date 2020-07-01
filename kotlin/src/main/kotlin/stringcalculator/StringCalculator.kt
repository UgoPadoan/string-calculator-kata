package stringcalculator

object StringCalculator {
    fun sum(commaSeparatedNumbers: String): Int {
        if(commaSeparatedNumbers.isEmpty()){
            return 0
        }

        return commaSeparatedNumbers.split(",").sumBy { it.toInt() }
    }

}

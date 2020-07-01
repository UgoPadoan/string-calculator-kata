package stringcalculator

object StringCalculator {
    fun sum(commaSeparatedNumbers: String): Int {
        if(commaSeparatedNumbers.isEmpty()){
            return 0
        }

        val numbers = commaSeparatedNumbers.split(",")
        var sum = 0

        for(number in numbers){
            sum += number.toInt()
        }

        return sum
    }

}

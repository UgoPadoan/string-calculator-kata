package stringcalculator

val delimiters = arrayOf(",", "\n")

fun add(s: String): Int {
  return when (s){
    "" -> 0
    else -> 
      s
      .split(*delimiters)
      .map(String::toInt)
      .sum()
  }
}
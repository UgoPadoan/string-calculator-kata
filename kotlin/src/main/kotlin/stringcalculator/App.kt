package stringcalculator

fun add(s: String): Int {
  return when (s){
    "" -> 0
    else -> 
      s
      .split(",")
      .map(String::toInt)
      .sum()
  }
}
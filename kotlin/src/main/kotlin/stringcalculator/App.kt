package stringcalculator

val defaultDelimiter = ","
val delimiters = arrayOf(defaultDelimiter, "\n")

fun add(s: String): Int = 
  s
  .addSplittingBy(*delimiters)

fun String.readUserDefinedDelimiter(): Pair<String, String> = when {
  this.startsWith("//") -> Pair(this.drop(4), this.substring(2,3))
  else -> Pair(this, defaultDelimiter)
}

fun Pair<String, Array<String>>.add(): Int {
  val (s, delimiters) = this
  return s.addSplittingBy(*delimiters)
}

fun String.addSplittingBy(vararg delimiters: String): Int = when (this) {
  "" -> 0
  else -> 
    this
    .split(*delimiters)
    .map(String::toInt)
    .sum()
}


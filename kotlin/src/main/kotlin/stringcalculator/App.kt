package stringcalculator

val defaultDelimiter = ","
val delimiters = arrayOf(defaultDelimiter, "\n")

fun add(s: String): Int = 
  s
  .readUserDefinedDelimiter()
  .addDefaultDelimiters()
  .add()

fun String.readUserDefinedDelimiter(): Pair<String, String> = when {
  this.startsWith("//") -> Pair(this.drop(4), this.substring(2,3))
  else -> Pair(this, defaultDelimiter)
}

fun Pair<String, Array<String>>.add(): Int =
  this.first.addSplittingBy(*this.second)

fun String.addSplittingBy(vararg delimiters: String): Int = when (this) {
  "" -> 0
  else -> 
    this
    .split(*delimiters)
    .map(String::toInt)
    .sum()
}

fun Pair<String, String>.addDefaultDelimiters(): Pair<String, Array<String>> =
  Pair(this.first, delimiters + this.second)


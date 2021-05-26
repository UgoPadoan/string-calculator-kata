package stringcalculator

val defaultDelimiter = ","
val delimiters = arrayOf(defaultDelimiter, "\n")

fun add(s: String): Int = 
  s
  .readUserDefinedDelimiter()
  .addDefaultDelimiters()
  .parseNumbers()
  .checkNotNegative()
  .sum()

fun String.readUserDefinedDelimiter(): Pair<String, String> = when {
  this.startsWith("//") -> Pair(this.drop(4), this.substring(2,3))
  else -> Pair(this, defaultDelimiter)
}

fun Pair<String, String>.addDefaultDelimiters(): Pair<String, Array<String>> =
  Pair(this.first, delimiters + this.second)

fun Pair<String, Array<String>>.parseNumbers(): List<Int> =
  this.first.parseNumbers(*this.second)

fun String.parseNumbers(vararg delimiters: String): List<Int> = when (this) {
  "" -> listOf(0)
  else -> 
    this
    .split(*delimiters)
    .map(String::toInt)
}

fun List<Int>.checkNotNegative(): List<Int> {
  val negatives =  this.filter { it < 0}
  if (negatives.size > 0) throw NegativesNotAllowed(negatives)
  return this
}


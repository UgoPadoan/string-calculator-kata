package stringcalculator

val defaultDelimiter = ","
val maxIntAllowed = 1000
val delimiters = arrayOf(defaultDelimiter, "\n")

fun add(s: String): Int = 
  s
  .let { readUserDefinedDelimiter( it ) }
  .let { addDefaultDelimiters(it) }
  .let { parseNumbers(it) }
  .let { assertNotNegative(it) }
  .filter { it <= maxIntAllowed}
  .sum()

fun readUserDefinedDelimiter(s: String): Pair<String, String> = when {
  s.startsWith("//") -> Pair(s.drop(4), s.substring(2,3))
  else -> Pair(s, defaultDelimiter)
}

fun addDefaultDelimiters(p: Pair<String, String>): Pair<String, Array<String>> =
  Pair(p.first, delimiters + p.second)

fun parseNumbers(p: Pair<String, Array<String>>): List<Int> =
  parseNumbers(p.first, *p.second)

fun parseNumbers(s: String, vararg delimiters: String): List<Int> = when (s) {
  "" -> listOf(0)
  else -> 
    s
    .split(*delimiters)
    .map(String::toInt)
}

fun assertNotNegative(ns: List<Int>): List<Int> {
  val negatives =  ns.filter { it < 0}
  if (negatives.size > 0) throw NegativesNotAllowed(negatives)
  return ns
}


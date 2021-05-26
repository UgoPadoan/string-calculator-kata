package stringcalculator

class NegativesNotAllowed : Exception {
    constructor(ns: List<Int>) : super("negatives not allowed: " + ns.toString())
}
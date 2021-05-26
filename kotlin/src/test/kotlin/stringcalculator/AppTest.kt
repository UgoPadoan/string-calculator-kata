package stringcalculator

import org.junit.Assert.assertTrue
import org.junit.Test

class AppTest {

    @Test
    fun testAddEmptyString() {
        assert(add("") == 0)
    }

    @Test
    fun testAddWithOnlyANumber() {
        assert(add("1") == 1)
    }

    @Test
    fun testAddWithMultipleNumbers() {
        assert(add("1,2") == 3)
    }

    @Test
    fun testAddWithMultipleNumbersJoinedByNewLinesAndComas() {
        assert(add("1\n2,3") == 6)
    }

    @Test
    fun testReadUserDefinedDelimiter() {
        assert("//;\n1;2".readUserDefinedDelimiter() == Pair("1;2", ";") )
        assert("//:\n1:2".readUserDefinedDelimiter() == Pair("1:2", ":") )
    }

    @Test
    fun testAddPair() {
        assert(Pair("1;2", arrayOf(";")).add() == 3 )
        assert(Pair("1:3", arrayOf(":")).add() == 4 )
    }
}
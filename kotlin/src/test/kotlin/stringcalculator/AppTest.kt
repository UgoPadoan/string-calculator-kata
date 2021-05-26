package stringcalculator

import org.junit.Assert.assertEquals
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertThrows
// import org.junit.Test.assertFailsWith

import org.junit.Test

class AppTest {

    @Test
    fun testAddEmptyString() {
        assertEquals(0, add(""))
    }

    @Test
    fun testAddWithOnlyANumber() {
        assertEquals(1, add("1"))
    }

    @Test
    fun testAddWithMultipleNumbers() {
        assertEquals(3, add("1,2"))
    }

    @Test
    fun testAddWithMultipleNumbersJoinedByNewLinesAndComas() {
        assertEquals(6, add("1\n2,3"))
    }

    @Test
    fun testSupportUserDefinedDelimiters() {
         assertEquals(3, add("//;\n1;2"))
    }

    @Test
    fun testThowExceptionOnNegativeNumbers() {
        val exception = assertThrows(NegativesNotAllowed::class.java) { add("1,4,-1")}
        assertEquals("negatives not allowed: -1", exception.message)
    }

    @Test
    fun testIgnoreBigNumbers() {
         assertEquals(2, add("//;\n2;1001"))
    }

    @Test
    fun testReadUserDefinedDelimiter() {
        assertEquals(Pair("1;2", ";"), "//;\n1;2".readUserDefinedDelimiter())
        assertEquals(Pair("1:2", ":"), "//:\n1:2".readUserDefinedDelimiter())
    }

    @Test
    fun testPairParseNumbers() {
        assertEquals(listOf(1, 2), Pair("1;2", arrayOf(";")).parseNumbers())
        assertEquals(listOf(1, 3), Pair("1:3", arrayOf(":")).parseNumbers())
    }

    @Test
    fun testMergeUserAndDefaultDelimiters() {
        assertEquals("1;2", Pair("1;2", ";").addDefaultDelimiters().first)
        assertArrayEquals(delimiters + ";", Pair("1;2", ";").addDefaultDelimiters().second)

        assertEquals("1;3", Pair("1;3", ":").addDefaultDelimiters().first)
        assertArrayEquals(delimiters + ":", Pair("1;3", ":").addDefaultDelimiters().second)
    }

    @Test
    fun testCheckNotNegatives() {
      assertEquals(listOf(1, 2), listOf(1, 2).checkNotNegative())
      val exception = assertThrows(NegativesNotAllowed::class.java) { listOf(1, -2, -3).checkNotNegative()}
      assertEquals("negatives not allowed: -2, -3", exception.message)
    }
}
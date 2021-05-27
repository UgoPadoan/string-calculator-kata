package stringcalculator

import org.junit.Assert.assertEquals
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertThrows
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
        assertEquals(Pair("1;2", ";"), readUserDefinedDelimiter("//;\n1;2"))
        assertEquals(Pair("1:2", ":"), readUserDefinedDelimiter("//:\n1:2"))
    }

    @Test
    fun testPairParseNumbers() {
        assertEquals(listOf(1, 2), parseNumbers(Pair("1;2", arrayOf(";"))))
        assertEquals(listOf(1, 3), parseNumbers(Pair("1:3", arrayOf(":"))))
    }

    @Test
    fun testMergeUserAndDefaultDelimiters() {
        assertEquals("1;2", addDefaultDelimiters(Pair("1;2", ";")).first)
        assertArrayEquals(delimiters + ";", addDefaultDelimiters(Pair("1;2", ";")).second)

        assertEquals("1;3", addDefaultDelimiters(Pair("1;3", ":")).first)
        assertArrayEquals(delimiters + ":", addDefaultDelimiters(Pair("1;3", ":")).second)
    }

    @Test
    fun testassertNotNegatives() {
      assertEquals(listOf(1, 2), assertNotNegative(listOf(1, 2)))
      val exception = assertThrows(NegativesNotAllowed::class.java) { assertNotNegative(listOf(1, -2, -3))}
      assertEquals("negatives not allowed: -2, -3", exception.message)
    }
}
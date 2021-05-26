package stringcalculator

import org.junit.Assert.assertEquals
import org.junit.Assert.assertArrayEquals

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
    fun testReadUserDefinedDelimiter() {
        assertEquals(Pair("1;2", ";"), "//;\n1;2".readUserDefinedDelimiter())
        assertEquals(Pair("1:2", ":"), "//:\n1:2".readUserDefinedDelimiter())
    }

    @Test
    fun testAddPair() {
        assertEquals(3, Pair("1;2", arrayOf(";")).add())
        assertEquals(4, Pair("1:3", arrayOf(":")).add())
    }

    @Test
    fun testMergeUserAndDefaultDelimiters() {
        assertEquals("1;2", Pair("1;2", ";").addDefaultDelimiters().first)
        assertArrayEquals(delimiters + ";", Pair("1;2", ";").addDefaultDelimiters().second)

        assertEquals("1;3", Pair("1;3", ":").addDefaultDelimiters().first)
        assertArrayEquals(delimiters + ":", Pair("1;3", ":").addDefaultDelimiters().second)
    }
}
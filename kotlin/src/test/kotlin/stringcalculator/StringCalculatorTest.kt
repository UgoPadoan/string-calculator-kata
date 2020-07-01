package stringcalculator

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Ignore
import org.junit.Test

class StringCalculatorTest {

    @Test
    fun `empty string sum should be 0`() {
        val sum: Int = StringCalculator.sum("")

        assertEquals(0, sum)
    }

    @Test
    fun `one number sum should be self`() {
        val sum: Int = StringCalculator.sum("1")

        assertEquals(1, sum)
    }

    @Test
    fun `two numbers sum should return the sum of the two numbers`() {
        val sum: Int = StringCalculator.sum("1,2")

        assertEquals(3, sum)
    }
}
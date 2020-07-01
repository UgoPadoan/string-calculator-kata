package stringcalculator

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
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
}
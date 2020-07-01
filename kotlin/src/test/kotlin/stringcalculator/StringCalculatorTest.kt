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
    fun `any numbers quantity sum should return the sum of the numbers`() {
        val sum: Int = StringCalculator.sum("1,2,3")

        assertEquals(6, sum)
    }


    @Test
    fun `check sum with any type of separator (new line or comma)`() {
        val sum: Int = StringCalculator.sum("1\n2,3")

        assertEquals(6, sum)
    }

}
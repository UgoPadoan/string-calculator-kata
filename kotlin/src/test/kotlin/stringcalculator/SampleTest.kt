package stringcalculator

import org.junit.Assert.assertEquals
import org.junit.Test

class SampleTest {

    @Test
    fun `string calculator with an empty string`() {
        assertEquals(0, StringCalculator().add(""))
    }

    @Test
    fun `string calculator with one number`() {
        val result = StringCalculator().add("1")

        assertEquals(1, result)
    }

    @Test
    fun `string calculator with two numbers`() {
        val result = StringCalculator().add("1,2")

        assertEquals(3, result)
    }

    @Test
    fun `string calculator with three numbers`() {
        val result = StringCalculator().add("1,2,3")

        assertEquals(6, result)
    }

    @Test
    fun `string calculator with new line`() {
        val result = StringCalculator().add("1\n2,3")

        assertEquals(6, result)
    }

    @Test
    fun `string calculator with custom delimeters`() {
        val result = StringCalculator().add("//;\n1;2;3")

        assertEquals(6, result)
    }

}
package stringcalculator

import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Test

class SampleTest {

    @Test
    fun `string calculator with an empty string`() {
        Assert.assertEquals(0, StringCalculator().add(""))
    }
}
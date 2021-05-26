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
}
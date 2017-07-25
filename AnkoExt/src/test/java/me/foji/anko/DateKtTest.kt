package me.foji.anko

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.*

/**
 *

 * @author Wizong 2017-07-25 13:09
 */
class DateKtTest {
    private var calendar: Calendar? = null

    @Before
    fun setUp() {
        calendar = Calendar.getInstance()
    }

    @Test
    fun toDateString() {
        assertEquals(2017, calendar?.get(Calendar.YEAR))
    }
}
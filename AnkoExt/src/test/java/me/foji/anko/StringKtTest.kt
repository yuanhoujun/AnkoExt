package me.foji.anko

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.text.SimpleDateFormat

/**
 * 测试String扩展方法
 *
 * @author Wizong 2017-05-19 13:09
 */
class StringKtTest {
    @Before
    fun setUp() {
    }

    @Test
    fun toDate() {
        val toDate = "2017-07-10".toDate("yyyy-MM-dd")
        val formatStr = SimpleDateFormat("yyyy-MM-dd").format(toDate)
        assertEquals("2017-07-10", formatStr)
    }

    @Test
    fun isPhoneNumber() {
        assertEquals(false, "88888".isPhoneNumber())
        assertEquals(true, "18888888888".isPhoneNumber(true))
    }

    @Test
    fun isIP() {
        assertEquals(false, "111".isIP())
        assertEquals(true, "192.168.0.1".isIP())
    }

    @Test
    fun isIdNumber() {
        assertEquals(false, "".isIdNumber())
        assertEquals(false, "1111111111".isIdNumber())
        assertEquals(true, "450520190010102937".isIdNumber())
    }

    @Test
    fun isEmail() {
        assertEquals(false, "".isEmail())
        assertEquals(true, "1@a.com".isEmail())
    }

    @Test
    fun isChinese() {
        assertEquals(false, "".isChinese())
        assertEquals(false, "abc".isChinese())
        assertEquals(true, "汉语".isChinese())
    }

    @Test
    fun safeConvertToInt() {
        assertEquals(0, "".safeConvertToInt())
        assertEquals(0, "android".safeConvertToInt())
        assertEquals(0, "安卓".safeConvertToInt())
    }

    @Test
    fun safeConvertToLong() {
        assertEquals(0, "".safeConvertToLong())
        assertEquals(0, "android".safeConvertToLong())
        assertEquals(0, "安卓".safeConvertToLong())
    }

    @Test
    fun safeConvertToFloat() {
        assertEquals(0f, "".safeConvertToFloat())
        assertEquals(0f, "android".safeConvertToFloat())
        assertEquals(0f, "安卓".safeConvertToFloat())
    }

    @Test
    fun safeConvertToDouble() {
        assertEquals(0F, "".safeConvertToDouble().toFloat())
        assertEquals(0F, "android".safeConvertToDouble().toFloat())
        assertEquals(0F, "安卓".safeConvertToDouble().toFloat())
    }

    @Test
    fun safeConvertToShort() {
        assertEquals(0, "".safeConvertToShort().toInt())
        assertEquals(0, "android".safeConvertToShort().toInt())
        assertEquals(0, "安卓".safeConvertToShort().toInt())
    }
}
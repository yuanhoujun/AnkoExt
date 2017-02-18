package me.foji.anko

import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

/**
 * 该文件主要用于添加一些字符串处理辅助类
 *
 * @author Scott Smith
 */
/**
 * 通过指定格式，将字符串转换为Date
 */
fun String.toDate(pattern: String): Date? {
    val formatter = SimpleDateFormat(pattern , Locale.CHINA)
    try {
        return formatter.parse(this)
    } catch (e: Exception) {
        return null
    }
}

/**
 * 判断当前字符串是否是一个有效的手机号
 * @return true 是 false 否
 */
fun String.isPhoneNumber(): Boolean {
    return Pattern.matches("^1\\d{10}$" , this)
}

/**
 * 判断当前字符串是否是一个有效的IP地址
 * return true 是 false 否
 */
fun String.isIP(): Boolean {
    return Pattern.matches("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$" , this)
}

/**
 * 判断当前字符串是否是一个有效的身份证号
 * return true 是 false 否
 */
fun String.isIdNumber(): Boolean {
    return Pattern.matches("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])" , this)
}

/**
 * 判断当前字符串是否是一个有效的邮箱地址
 * return true 是 false 否
 */
fun String.isEmail(): Boolean {
    return Pattern.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*" , this)
}

/**
 * 判断当前字符串是否全是中文
 * return true 是 false 否
 */
fun String.isChinese(): Boolean {
    return Pattern.matches("^[\u4e00-\u9fa5]+$" , this)
}
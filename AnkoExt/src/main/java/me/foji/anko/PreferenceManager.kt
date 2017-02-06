package me.foji.anko

import android.content.SharedPreferences

/**
 * 该文件主要增加一些SharePreferences简化方法，简化SharePreferences操作
 *
 * @author Scott Smith
 */
fun SharedPreferences.edit(init: SharedPreferences.Editor.()->Unit) {
    val editor = edit()
    editor.init()
    editor.apply()
}
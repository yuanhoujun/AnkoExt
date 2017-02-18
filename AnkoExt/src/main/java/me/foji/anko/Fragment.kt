package me.foji.anko

import android.app.Fragment
import android.support.annotation.IdRes
import android.view.LayoutInflater
import android.view.View

/**
 * 该文件主要增加一些Fragment简化方法，简化Fragment操作
 *
 * @author scott 2017-02-18 22:16
 */

/**
 * 类似Activity#findViewById
 */
@Suppress("UNCHECKED_CAST")
fun <V: View> Fragment.findViewById(@IdRes id: Int): V? {
    return view?.findViewById(id) as V
}

/**
 * 类似Activity#findViewById
 */
@Suppress("UNCHECKED_CAST")
fun <V: View> android.support.v4.app.Fragment.findViewById(@IdRes id: Int): V? {
    return view?.findViewById(id) as V
}

/**
 * 获取LayoutInflater
 */
fun Fragment.getLayoutInflater(): LayoutInflater {
    return LayoutInflater.from(activity)
}

/**
 * 获取LayoutInflater
 */
fun android.support.v4.app.Fragment.getLayoutInflater(): LayoutInflater {
    return LayoutInflater.from(activity)
}


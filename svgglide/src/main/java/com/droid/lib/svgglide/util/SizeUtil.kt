package com.droid.lib.svgglide.util

import java.io.InputStream
import java.nio.charset.Charset

object SizeUtil {

    fun getSize(source: String?): Int {
        return getSize(source, Charsets.UTF_8)
    }

    private fun getSize(source: String?, encoding: Charset): Int {
        return source?.toByteArray(encoding)?.size ?: 0
    }

    fun getSize(source: InputStream?): Int {
        return source?.available() ?: 0
    }
}
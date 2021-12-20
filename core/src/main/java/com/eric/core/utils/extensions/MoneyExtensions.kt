package com.eric.core.extensions

import java.text.DecimalFormat

fun Double.toBRValue(): String {
    val df = DecimalFormat()
    df.applyPattern("R$ #,##0.00")
    return df.format(this)
}
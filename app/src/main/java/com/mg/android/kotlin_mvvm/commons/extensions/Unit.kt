package com.mg.android.kotlin_mvvm.commons.extensions

import android.os.Handler

fun withDelay(delay : Long, block : () -> Unit) {
    Handler().postDelayed(Runnable(block), delay)
}

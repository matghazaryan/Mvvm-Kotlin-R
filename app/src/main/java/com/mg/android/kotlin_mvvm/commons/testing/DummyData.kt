package com.mg.android.kotlin_mvvm.commons.testing

import androidx.annotation.VisibleForTesting
import com.mg.android.kotlin_mvvm.commons.data.User

@VisibleForTesting(otherwise = VisibleForTesting.NONE)
object DummyData {
    fun User() = User("test@t.tt","tokentoekn",true)
}

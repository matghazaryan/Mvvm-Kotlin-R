package com.mg.android.kotlin_mvvm.helper

import com.mg.android.kotlin_mvvm.commons.data.remote.LoginService
import com.mg.android.kotlin_mvvm.commons.testing.DummyData
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class LoginRemoteDataTest {

    private val loginService = mock<LoginService>()

    @Test
    fun login(){
         val userName = "test@test.com"
         val password = "123456"
    }
}
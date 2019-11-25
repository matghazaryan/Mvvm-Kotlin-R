package com.mg.android.kotlin_mvvm.viewmodel

import android.os.Build
import androidx.lifecycle.Observer
import com.mg.android.kotlin_mvvm.commons.data.User
import com.mg.android.kotlin_mvvm.commons.model.ApiResponse
import com.mg.android.kotlin_mvvm.login.helper.LoginDataContract
import com.mg.android.kotlin_mvvm.login.viewModel.LoginViewModel
import com.mpaani.core.networking.Outcome
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.IOException
import java.util.*

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class LoginViewModelTest {

    private lateinit var viewModel: LoginViewModel
    private val repo: LoginDataContract.Repository = mock();
    private val compositeDisposable = CompositeDisposable()
    private val outcome: Observer<Outcome<ApiResponse<User>>> = mock()

    private val userName = "test@test.com"
    private val password = "123456"

    @Before
    fun init(){
        viewModel = LoginViewModel(repo,compositeDisposable)
        whenever(repo.loginOutcome).doReturn(PublishSubject.create())
        viewModel.userOutcome.observeForever(outcome)
    }

    @Test
    fun testLoginSuccess(){
        viewModel.login(userName,password)
        verify(repo).login(userName,password)

        repo.loginOutcome.onNext(Outcome.loading(true))
        verify(outcome).onChanged(Outcome.loading(true))

        repo.loginOutcome.onNext(Outcome.loading(false))
        verify(outcome).onChanged(Outcome.loading(false))
    }

    @Test
    fun testLoginFailure(){
       val exceptoin = IOException()
        repo.loginOutcome.onNext(Outcome.failure(exceptoin))
        verify(outcome).onChanged(Outcome.failure(exceptoin))
    }
}
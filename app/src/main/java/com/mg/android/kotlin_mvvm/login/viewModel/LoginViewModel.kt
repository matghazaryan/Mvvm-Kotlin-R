package com.mg.android.kotlin_mvvm.login.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.karntrehan.posts.core.extensions.toLiveData
import com.mg.android.kotlin_mvvm.commons.MvvmDH
import com.mg.android.kotlin_mvvm.commons.data.User
import com.mg.android.kotlin_mvvm.commons.model.ApiResponse
import com.mg.android.kotlin_mvvm.login.helper.LoginDataContract
import com.mpaani.core.networking.Outcome
import io.reactivex.disposables.CompositeDisposable

class LoginViewModel(private val repo: LoginDataContract.Repository,
                     private val compositeDisposable: CompositeDisposable) : ViewModel() {

    val userOutcome: LiveData<Outcome<ApiResponse<User>>> by lazy {
        repo.loginOutcome.toLiveData(compositeDisposable)
    }

    fun login(username: String?, password: String?){
        repo.login(username,password)
    }

    override fun onCleared() {
        super.onCleared()
        //clear the disposables when the viewmodel is cleared
        compositeDisposable.clear()
        MvvmDH.destroyLoginComponent()
    }
}
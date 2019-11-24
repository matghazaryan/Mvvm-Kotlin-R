package com.mg.android.kotlin_mvvm.login.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mg.android.kotlin_mvvm.login.helper.LoginDataContract
import io.reactivex.disposables.CompositeDisposable

@Suppress("UNCHECKED_CAST")
class LoginViewModelFactory(private val repository: LoginDataContract.Repository,private val compositeDisposable: CompositeDisposable) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(repository, compositeDisposable) as T
    }
}
package com.mg.android.kotlin_mvvm.login.repository

import com.karntrehan.posts.core.extensions.addTo
import com.karntrehan.posts.core.extensions.loading
import com.karntrehan.posts.core.extensions.performOnBackOutOnMain
import com.karntrehan.posts.core.networking.Scheduler
import com.mg.android.kotlin_mvvm.commons.data.User
import com.mg.android.kotlin_mvvm.login.helper.LoginDataContract
import com.mpaani.core.networking.Outcome
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject

class LoginRepository (
    private val local: LoginDataContract.Local,
    private val remote: LoginDataContract.Remote,
    private val scheduler: Scheduler,
    private val compositeDisposable: CompositeDisposable) : LoginDataContract.Repository {

    override val loginOutcome: PublishSubject<Outcome<User>> =
        PublishSubject.create<Outcome<User>>()

    override fun login(username: String?, password: String?) {
        loginOutcome.loading(true)
        remote.login(username,password)
            .performOnBackOutOnMain(scheduler)
            .subscribe(
                {user -> saveUser(user)},
                {error -> handleError(error)}
            ).addTo(compositeDisposable)

    }

    private fun saveUser(user: User?) {
        if (user != null){
            local.saveUser(user)
        }
    }

    override fun handleError(error: Throwable) {
        loginOutcome.loading(false)
    }
}

package com.mg.android.kotlin_mvvm.login.helper

import com.mg.android.kotlin_mvvm.commons.data.User
import com.mpaani.core.networking.Outcome
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject

interface LoginDataContract {

    interface Repository {
        val loginOutcome: PublishSubject<Outcome<User>>

        fun login(username: String?, password: String?)
        fun handleError(error: Throwable)
    }

    interface Local {
        fun getUser(): Flowable<User>
        fun saveUser(user: User)
    }

    interface Remote {
        fun login(username: String?, password: String?): Single<User>
    }
}
package com.mg.android.kotlin_mvvm.login.di

import com.karntrehan.posts.core.extensions.performOnBack
import com.karntrehan.posts.core.networking.Scheduler
import com.mg.android.kotlin_mvvm.commons.data.User
import com.mg.android.kotlin_mvvm.commons.data.local.user.UserDb
import com.mg.android.kotlin_mvvm.login.helper.LoginDataContract
import io.reactivex.Completable
import io.reactivex.Flowable

class LoginLocalData(private val userDb: UserDb,private val scheduler: Scheduler) : LoginDataContract.Local {

    override fun getUser(): Flowable<User> {
        return userDb.userDao().getUser()
    }

    override fun saveUser(user: User) {
        Completable.fromAction {
            userDb.userDao().insertUser(user)
        }.performOnBack(scheduler).subscribe()
    }
}
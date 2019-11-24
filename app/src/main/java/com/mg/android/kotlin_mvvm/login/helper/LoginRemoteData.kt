package com.mg.android.kotlin_mvvm.login.helper

import com.mg.android.kotlin_mvvm.commons.data.remote.LoginService

class LoginRemoteData(private val loginService: LoginService) : LoginDataContract.Remote {

    override fun login(username: String?, password: String?)  = loginService.login(username,password)
}
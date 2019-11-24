package com.mg.android.kotlin_mvvm.commons

import com.mg.android.kotlin_mvvm.MvvmKotlinRApp
import com.mg.android.kotlin_mvvm.login.di.DaggerLoginComponent
import com.mg.android.kotlin_mvvm.login.di.LoginComponent
import javax.inject.Singleton

@Singleton
object MvvmDH {

    private var loginComponent: LoginComponent? = null

    fun loginComponent(): LoginComponent {
        if (loginComponent == null)
            loginComponent = DaggerLoginComponent.builder().coreComponent(MvvmKotlinRApp.coreComponent).build()
        return loginComponent as LoginComponent
    }

    fun destroyLoginComponent() {
        loginComponent = null
    }
}
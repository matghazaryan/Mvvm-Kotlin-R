package com.mg.android.kotlin_mvvm.login.di

import android.content.Context
import androidx.room.Room
import com.karntrehan.posts.core.di.CoreComponent
import com.karntrehan.posts.core.networking.Scheduler
import com.mg.android.kotlin_mvvm.commons.data.local.user.UserDb
import com.mg.android.kotlin_mvvm.commons.data.remote.LoginService
import com.mg.android.kotlin_mvvm.constants.Constants
import com.mg.android.kotlin_mvvm.login.helper.LoginDataContract
import com.mg.android.kotlin_mvvm.login.helper.LoginRemoteData
import com.mg.android.kotlin_mvvm.login.repository.LoginRepository
import com.mg.android.kotlin_mvvm.login.view.LoginActivity
import com.mg.android.kotlin_mvvm.login.viewModel.LoginViewModelFactory
import dagger.Component
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit

@LoginScope
@Component(dependencies = [CoreComponent::class], modules = [LoginModule::class])
interface LoginComponent {
    fun inject(loginActivity: LoginActivity)
}

@Module
class LoginModule {

    /*ViewModel*/
    @Provides
    @LoginScope
    fun loginViewModelFactory(repo: LoginDataContract.Repository, compositeDisposable: CompositeDisposable): LoginViewModelFactory {
        return LoginViewModelFactory(repo, compositeDisposable)
    }

    /*Repository*/
    @Provides
    @LoginScope
    fun loginRepo(local: LoginDataContract.Local,remote: LoginDataContract.Remote, scheduler: Scheduler, compositeDisposable: CompositeDisposable)
            : LoginDataContract.Repository = LoginRepository(local,remote, scheduler, compositeDisposable)

    @Provides
    @LoginScope
    fun remoteData(loginService: LoginService): LoginDataContract.Remote = LoginRemoteData(loginService)

    @Provides
    @LoginScope
    fun localData(userDb: UserDb, scheduler: Scheduler): LoginDataContract.Local = LoginLocalData(userDb, scheduler)

    @Provides
    @LoginScope
    fun compositeDisposable(): CompositeDisposable = CompositeDisposable()


    /*Parent providers to dependents*/
    @Provides
    @LoginScope
    fun userDb(context: Context): UserDb = Room.databaseBuilder(context, UserDb::class.java, Constants.MvvmK.DB_NAME).build()

    @Provides
    @LoginScope
    fun loginService(retrofit: Retrofit): LoginService = retrofit.create(LoginService::class.java)
}
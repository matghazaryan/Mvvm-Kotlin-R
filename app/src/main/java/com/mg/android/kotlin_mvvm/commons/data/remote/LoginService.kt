package com.mg.android.kotlin_mvvm.commons.data.remote

import com.mg.android.kotlin_mvvm.commons.data.User
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {

    @POST("5bebd5603300005900fbc067")
    fun login(@Query("user_name") username: String?, @Query("pasword") password: String?): Single<User>
}

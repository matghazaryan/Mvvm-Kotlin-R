package com.mg.android.kotlin_mvvm.commons.data.remote

import com.mg.android.kotlin_mvvm.commons.data.User
import io.reactivex.Single
import com.mg.android.kotlin_mvvm.commons.model.ApiResponse
import retrofit2.http.*


interface LoginService {

//    @POST("5dda2ca63200007a009a88b7")
//    fun login(@Query("user_name") username: String?, @Query("pasword") password: String?): Single<User>

    @POST("5bebd5603300005900fbc067")
    fun login(@Query("user_name") username: String?, @Query("pasword") password: String?): Single<ApiResponse<User>>
}

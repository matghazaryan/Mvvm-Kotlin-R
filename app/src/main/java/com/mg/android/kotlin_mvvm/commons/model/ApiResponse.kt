package com.mg.android.kotlin_mvvm.commons.model

import com.google.gson.annotations.SerializedName


class ApiResponse<T> {

    @SerializedName("statusCode")
    var code: String = ""

    @SerializedName("data")
    var data: T? = null

}
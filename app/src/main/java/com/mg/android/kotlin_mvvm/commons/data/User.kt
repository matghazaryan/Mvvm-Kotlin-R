package com.mg.android.kotlin_mvvm.commons.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class User(
                @SerializedName("email") @PrimaryKey val email: String,
                @SerializedName("token") val token: String,
                @SerializedName("twoStepEnabled") val twoStepEnabled: Boolean)
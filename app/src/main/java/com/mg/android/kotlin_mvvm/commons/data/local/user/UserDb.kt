package com.mg.android.kotlin_mvvm.commons.data.local.user

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mg.android.kotlin_mvvm.commons.data.User

@Database(entities = [User::class], version = 1,exportSchema = false)
abstract class UserDb : RoomDatabase() {
    abstract fun userDao(): UserDao
}
package com.mg.android.kotlin_mvvm.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.mg.android.kotlin_mvvm.R
import com.mg.android.kotlin_mvvm.commons.extensions.startActivity
import com.mg.android.kotlin_mvvm.commons.extensions.withDelay
import com.mg.android.kotlin_mvvm.login.view.LoginActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        withDelay(3000) { startActivity<LoginActivity>()}
    }
}

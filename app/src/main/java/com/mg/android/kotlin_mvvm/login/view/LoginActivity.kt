package com.mg.android.kotlin_mvvm.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mg.android.kotlin_mvvm.R
import com.mg.android.kotlin_mvvm.commons.MvvmDH
import com.mg.android.kotlin_mvvm.commons.extensions.click
import com.mg.android.kotlin_mvvm.commons.extensions.startActivity
import com.mg.android.kotlin_mvvm.commons.extensions.stringValue
import com.mg.android.kotlin_mvvm.commons.extensions.toast
import com.mg.android.kotlin_mvvm.login.viewModel.LoginViewModel
import com.mg.android.kotlin_mvvm.login.viewModel.LoginViewModelFactory
import com.mg.android.kotlin_mvvm.ui.home.view.HomeActivity
import com.mpaani.core.networking.Outcome
import kotlinx.android.synthetic.main.activity_login.*
import java.io.IOException
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    private val TAG = "LoginActivity"

    private val component by lazy { MvvmDH.loginComponent() }

    @Inject
    lateinit var viewModelFactory: LoginViewModelFactory

    private val viewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this,viewModelFactory).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initialSetup()
    }

    private fun initialSetup() {
        component.inject(this)
        observeData()
        btnLogin.click {
            viewModel.login(etEmail.stringValue(),etPassword.stringValue())
        }
    }

    private fun observeData() {
        viewModel.userOutcome.observe(this, Observer { outcome ->
            Log.d(TAG, "initiateDataListener: $outcome")
            when (outcome){

                is Outcome.Success -> {
                    startActivity<HomeActivity>()
                }

                is Outcome.Failure -> when (outcome.e) {
                    IOException() -> toast(R.string.need_internet_posts)
                    else -> toast(R.string.failed_post_try_again)
                }
            }
        })
    }
}

package com.isil.mjr.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.isil.mjr.R
import com.isil.mjr.goToActivity
import com.isil.mjr.toast
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : AppCompatActivity() {

    private val mAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        btnLogIn.setOnClickListener {
            val email = etUsername.text.toString()
            val password = etPassword.text.toString()

            if(isValidEmailAndPassword(email, password)) {
                logInByEmail(email, password)
            }
        }

        tvForgotPassword.setOnClickListener {
            goToActivity<ForgotPasswordActivity>()
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }
    }

    private fun logInByEmail(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                goToActivity<HomeActivity>{
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                toast("User is now logged in.")
            } else {
                toast("An unexpected error occurred, please try again.")
            }
        }
    }

    private fun isValidEmailAndPassword(email: String, password: String): Boolean {
        return !email.isNullOrEmpty() && !password.isNullOrEmpty()
    }
}

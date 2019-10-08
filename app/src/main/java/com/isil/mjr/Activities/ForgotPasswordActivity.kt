package com.isil.mjr.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.isil.mjr.R
import com.isil.mjr.goToActivity
import com.isil.mjr.toast
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : AppCompatActivity() {

    private val mAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        btnSend.setOnClickListener {
            val email = etUsername.text.toString()

            if(isValidEmail(email)) {
                alertByEmail(email)
            } else {
                toast("Please make sure the email address is correct.")
            }

        }
    }

    private fun alertByEmail(email: String) {
        val alert = AlertDialog.Builder(this@ForgotPasswordActivity)
        alert.setView(R.layout.dialog_password)
        alert.setPositiveButton(R.string.done){
                _, _ ->
            forgotByEmail(email)
        }
        val dialog: AlertDialog = alert.create()
        dialog.show()
    }

    private fun forgotByEmail(email: String) {
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(this) {
            toast("Email has been sent to reset your password.")
            goToActivity<LogInActivity> {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return !email.isNullOrEmpty()
    }
}

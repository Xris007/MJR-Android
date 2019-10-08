package com.isil.mjr.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.isil.mjr.R
import kotlinx.android.synthetic.main.activity_feedback.*

class FeedbackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        ivBack.setOnClickListener {
            startActivity(Intent(this, ContactActivity::class.java))
            finish()
        }

        btnSend.setOnClickListener {
            val alert = AlertDialog.Builder(this@FeedbackActivity)
            alert.setView(R.layout.dialog_feedback)
            alert.setPositiveButton(R.string.send){
                    _, _ ->
                startActivity(Intent(this, ContactActivity::class.java))
                finish()
            }
            alert.setNegativeButton(R.string.cancel){
                    _, _ ->
            }
            val dialog: AlertDialog = alert.create()
            dialog.show()
        }
    }

    override fun onBackPressed() {
        startActivity(Intent(this, ContactActivity::class.java))
        finish()
    }
}

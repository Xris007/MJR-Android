package com.isil.mjr.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.isil.mjr.R
import kotlinx.android.synthetic.main.activity_add_class.*

class AddClassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_class)

        btnCancel.setOnClickListener {
            startActivity(Intent(this, ClassActivity::class.java))
            finish()
        }

        btnAdd.setOnClickListener {
            val alert = AlertDialog.Builder(this@AddClassActivity)
            alert.setView(R.layout.dialog_add_class)
            alert.setPositiveButton(R.string.add){
                    _, _ ->
                startActivity(Intent(this, ClassActivity::class.java))
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
        startActivity(Intent(this, ClassActivity::class.java))
        finish()
    }
}

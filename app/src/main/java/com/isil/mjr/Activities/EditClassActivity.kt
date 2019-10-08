package com.isil.mjr.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.isil.mjr.R
import kotlinx.android.synthetic.main.activity_edit_class.*

class EditClassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_class)

        btnCancel.setOnClickListener {
            startActivity(Intent(this, ClassInfoActivity::class.java))
            finish()
        }

        btnSave.setOnClickListener {
            val alert = AlertDialog.Builder(this@EditClassActivity)
            alert.setView(R.layout.dialog_edit_class)
            alert.setPositiveButton(R.string.save){
                    _, _ ->
                startActivity(Intent(this, ClassInfoActivity::class.java))
                finish()
            }
            alert.setNegativeButton(R.string.cancel){
                    _, _ ->
            }
            val dialog: AlertDialog = alert.create()
            dialog.show()
        }
    }
}

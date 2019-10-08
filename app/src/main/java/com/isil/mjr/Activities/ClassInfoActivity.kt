package com.isil.mjr.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.isil.mjr.R
import kotlinx.android.synthetic.main.activity_class_info.*

class ClassInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_info)

        ivBack.setOnClickListener {
            startActivity(Intent(this, ClassActivity::class.java))
            finish()
        }

        btnEdit.setOnClickListener {
            startActivity(Intent(this, EditClassActivity::class.java))
        }
    }

    override fun onBackPressed() {
        startActivity(Intent(this, ClassActivity::class.java))
        finish()
    }
}

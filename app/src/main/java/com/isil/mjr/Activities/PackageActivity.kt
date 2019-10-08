package com.isil.mjr.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.isil.mjr.R
import kotlinx.android.synthetic.main.activity_package.*

class PackageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package)

        ivBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        btnUpdate.setOnClickListener {
            startActivity(Intent(this, ContactActivity::class.java))
        }
    }
}

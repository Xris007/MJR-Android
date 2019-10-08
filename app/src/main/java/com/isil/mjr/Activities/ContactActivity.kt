package com.isil.mjr.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.isil.mjr.R
import kotlinx.android.synthetic.main.activity_contact.*

class ContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        ivBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        btnFeedBack.setOnClickListener {
            startActivity(Intent(this, FeedbackActivity::class.java))
            finish()
        }




        val stb = AnimationUtils.loadAnimation(this,R.anim.stb)

        val btt = AnimationUtils.loadAnimation(this,R.anim.btt);
        val btt2 = AnimationUtils.loadAnimation(this,R.anim.btt2);
        val btt3 = AnimationUtils.loadAnimation(this,R.anim.btt3);
        val btt4 = AnimationUtils.loadAnimation(this,R.anim.btt4);

        val imageView = findViewById(R.id.imageView) as ImageView

        val textView = findViewById(R.id.textView) as TextView
        val tvPhone = findViewById(R.id.tvPhone) as TextView

        val textView1 = findViewById(R.id.textView1) as TextView
        val tvEmail = findViewById(R.id.tvEmail) as TextView

        val textView2 = findViewById(R.id.textView2) as TextView
        val tvAddress = findViewById(R.id.tvAddress) as TextView

        val btnFeedBack = findViewById(R.id.btnFeedBack) as Button

        imageView.startAnimation(stb)

        textView.startAnimation(btt)
        tvPhone.startAnimation(btt)

        textView1.startAnimation(btt2)
        tvEmail.startAnimation(btt2)

        textView2.startAnimation(btt3)
        tvAddress.startAnimation(btt3)

        btnFeedBack.startAnimation(btt4)



    }
}

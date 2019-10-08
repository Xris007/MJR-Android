package com.isil.mjr.Activities

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.isil.mjr.R
import kotlinx.android.synthetic.main.activity_teacher.*

class TeacherActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)

        ivBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        val ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);
        val stb = AnimationUtils.loadAnimation(this,R.anim.stb);

        val btt = AnimationUtils.loadAnimation(this,R.anim.btt);
        val btt2 = AnimationUtils.loadAnimation(this,R.anim.btt2);
        val btt3 = AnimationUtils.loadAnimation(this,R.anim.btt3);

        val imageUser = findViewById(R.id.imageUser) as ImageView
        val tvTeacher = findViewById(R.id.tvTeacher) as TextView
        val tvCountry = findViewById(R.id.tvCountry) as TextView
        val tvNative = findViewById(R.id.tvNative) as TextView

        val textView = findViewById(R.id.textView) as TextView
        val tvPhone = findViewById(R.id.tvPhone) as TextView

        val textView2 = findViewById(R.id.textView2) as TextView
        val tvEmail = findViewById(R.id.tvEmail) as TextView

        val textView1 = findViewById(R.id.textView1) as TextView
        val tvAddress = findViewById(R.id.tvAddress) as TextView



        imageUser.startAnimation(stb)
        tvTeacher.startAnimation(ttb)
        tvCountry.startAnimation(ttb)
        tvNative.startAnimation(ttb)

        textView.startAnimation(btt)
        tvPhone.startAnimation(btt)

        textView2.startAnimation(btt2)
        tvEmail.startAnimation(btt2)

        textView1.startAnimation(btt3)
        tvAddress.startAnimation(btt3)



    }
}

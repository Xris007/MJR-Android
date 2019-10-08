package com.isil.mjr.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.isil.mjr.R
import com.isil.mjr.goToActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    private val splash_time_out: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        progressBar()

        Handler().postDelayed({
            goToActivity<LogInActivity>{
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }, splash_time_out)
    }

    fun progressBar() {
        var barStatus = 0
        val handler = Handler()

        Thread(Runnable {
            while (barStatus < 100) {
                barStatus+=1
                try {
                    Thread.sleep(30)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

                handler.post {
                    progressBar.progress = barStatus
                }
            }
        }).start()
    }
}

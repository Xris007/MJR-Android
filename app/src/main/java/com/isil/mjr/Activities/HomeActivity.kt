package com.isil.mjr.Activities

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.view.Menu
import com.isil.mjr.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.home_content.*
import kotlinx.android.synthetic.main.home_content.toolBar

class HomeActivity : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val animDrawable = root_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        ibtnClass.setOnClickListener {
            startActivity(Intent(this, ClassActivity::class.java))
        }

        ibtnSchedule.setOnClickListener {
            startActivity(Intent(this, ScheduleActivity::class.java))
        }

        ibtnTeacher.setOnClickListener {
            startActivity(Intent(this, TeacherActivity::class.java))
        }

        ibtnContact.setOnClickListener {
            startActivity(Intent(this, ContactActivity::class.java))
        }

        toggle = ActionBarDrawerToggle(this, drawerLayout, toolBar,
            R.string.open,
            R.string.exit
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.navUser -> {
                    startActivity(Intent(this, StudentActivity::class.java))
                    true
                } R.id.navClass -> {
                    startActivity(Intent(this, ClassActivity::class.java))
                    true
                } R.id.navSchedule -> {
                    startActivity(Intent(this, ScheduleActivity::class.java))
                    true
                } R.id.navPackage -> {
                    startActivity(Intent(this, PackageActivity::class.java))
                    true
                } R.id.navNotification -> {
                    startActivity(Intent(this, NotificationActivity::class.java))
                    true
                } R.id.navLogOut -> {
                    val alert = AlertDialog.Builder(this@HomeActivity)
                    alert.setView(R.layout.dialog_exit)
                    alert.setPositiveButton(R.string.exit) {
                        _, _ ->
                        startActivity(Intent(this, LogInActivity::class.java))
                        finish()
                    }
                    alert.setNegativeButton(R.string.cancel) {
                        _, _ ->
                    }
                    val dialog: AlertDialog = alert.create()
                    dialog.show()
                    true
                } else -> false
            }
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            val alert = AlertDialog.Builder(this@HomeActivity)
            alert.setView(R.layout.dialog_exit)
            alert.setPositiveButton(R.string.exit){
                    _, _ ->
                startActivity(Intent(this, LogInActivity::class.java))
                finish()
            }
            alert.setNegativeButton(R.string.cancel){
                    _, _ ->
            }
            val dialog: AlertDialog = alert.create()
            dialog.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }
}

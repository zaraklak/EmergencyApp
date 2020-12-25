package com.example.myapplicationemergency

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.editpage.*
import kotlinx.android.synthetic.main.profile.*
import kotlinx.android.synthetic.main.profile.btn_menu

class editpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var sharedPreferences: SharedPreferences
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editpage)

        val context = this
        val db = DBHelp(context)
        sharedPreferences =getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        btn_edit.setOnClickListener {
            val go_to= Intent(this, profile::class.java)
            startActivity(go_to)
        }
        btn_menu.setOnClickListener {
            val go_to= Intent(this, main_menu::class.java)
            startActivity(go_to)
        }

        username_ed.setText(sharedPreferences.getString("username", "").toString())
        email_ed.setText(db.readEmail(sharedPreferences.getString("username", "").toString()))
        address_ed.setText(db.readAddress(sharedPreferences.getString("username", "").toString()))
        password_ed.setText(db.readPassword(sharedPreferences.getString("username", "").toString()))
        phone_ed.setText(db.readPhone(sharedPreferences.getString("username", "").toString()))
    }
}
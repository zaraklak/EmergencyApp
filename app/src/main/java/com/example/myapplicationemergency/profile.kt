package com.example.myapplicationemergency

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.editpage.*
import kotlinx.android.synthetic.main.profile.*
import kotlinx.android.synthetic.main.profile.btn_menu

class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var sharedPreferences: SharedPreferences
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)
        val context = this
        val db = DBHelp(context)
        sharedPreferences =getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        btn_menu.setOnClickListener {
            val go_to= Intent(this, main_menu::class.java)
            startActivity(go_to)
        }

        username_pr.setText(sharedPreferences.getString("username", "").toString())
        email_pr.setText(db.readEmail(sharedPreferences.getString("username", "").toString()))
        address_pr.setText(db.readAddress(sharedPreferences.getString("username", "").toString()))
        password_pr.setText(db.readPassword(sharedPreferences.getString("username", "").toString()))
        phone_pr.setText(db.readPhone(sharedPreferences.getString("username", "").toString()))

        btn_save.setOnClickListener {
            var user = User(username_pr.text.toString(), email_pr.text.toString(), password_pr.text.toString(), address_pr.text.toString(), phone_pr.text.toString())
            db.updateAddress(user.address, user.username)
            db.updateEmail(user.email, user.username)
            db.updatePassword(user.password, user.username)
            db.updatePhone(user.phone, user.username)
            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show()
        }
    }
}
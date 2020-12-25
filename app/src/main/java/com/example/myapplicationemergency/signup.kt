package com.example.myapplicationemergency

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.signin.*
import kotlinx.android.synthetic.main.signin.btn_exit
import kotlinx.android.synthetic.main.signup.*

class signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var sharedPreferences: SharedPreferences
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)

        sharedPreferences =getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        btn_exit.setOnClickListener {
            val go_to= Intent(this, MainActivity::class.java)
            startActivity(go_to)
        }

        btn_signup.setOnClickListener {
            val context = this
            val db = DBHelp(context)
            val Password = db.readPassword(username1.text.toString())
            if(password1.text.toString() == Password && password1.text.isNotEmpty() && username1.text.isNotEmpty()) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("username", username1.text.toString())
                editor.apply()
                Toast.makeText(context, "Signed", Toast.LENGTH_SHORT).show()
                val go_to_reg = Intent(this, main_menu::class.java)
                startActivity(go_to_reg)
            }
            else{
                Toast.makeText(context, "Failed username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
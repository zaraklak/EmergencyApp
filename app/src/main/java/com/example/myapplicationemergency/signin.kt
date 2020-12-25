package com.example.myapplicationemergency

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.signin.*

class signin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin)


        btn_exit.setOnClickListener {
            val go_to= Intent(this, MainActivity::class.java)
            startActivity(go_to)
        }

        btn_signin.setOnClickListener {
            val context = this
            val db = DBHelp(context)
            if(username.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()){
                val user =User(username.text.toString(), email.text.toString(), password.text.toString(), "", "")
                db.insertData(user)
            }
        }
    }
}
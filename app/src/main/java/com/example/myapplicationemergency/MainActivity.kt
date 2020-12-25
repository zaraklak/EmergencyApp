package com.example.myapplicationemergency

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplicationemergency.signin
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signin_btn.setOnClickListener {
            val go_to= Intent(this, signin::class.java)
            startActivity(go_to)
        }
        signup_btn.setOnClickListener {
            val go_to= Intent(this, signup::class.java)
            startActivity(go_to)
        }
    }
}
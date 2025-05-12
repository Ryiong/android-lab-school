package com.example.lab2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    private lateinit var username: String
    private lateinit var welcomeUser: TextView
    private lateinit var btnCall: Button
    private lateinit var btnMessage: Button
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        username = intent.getStringExtra("username").toString()
        welcomeUser = findViewById(R.id.welcomeuser)
        welcomeUser.text = "Welcome, $username"
        findViewById<Button>(R.id.btnCall).setOnClickListener {
            startActivity(Intent(this, CallActivity::class.java))
        }

        findViewById<Button>(R.id.btnMessage).setOnClickListener {
            startActivity(Intent(this, MessageActivity::class.java))
        }

        findViewById<Button>(R.id.btnLogout).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
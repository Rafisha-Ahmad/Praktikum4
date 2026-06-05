package com.example.praktikum4

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.os.Handler
import kotlin.jvm.java

class Latihan1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        supportActionBar?.hide() // Hilangkan action bar
        delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO //Paksa lightmode
        setContentView(R.layout.activity_latihan1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Loading 3 detik untuk masuk ke LoginActivity
        Handler(Looper.getMainLooper()).postDelayed({
            val intentLatihan1 = Intent(this, Latihan2::class.java)
            intentLatihan1.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intentLatihan1)
            finish()
        },3000)
    }
}
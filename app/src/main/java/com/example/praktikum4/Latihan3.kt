package com.example.praktikum4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Latihan3 : AppCompatActivity() {

    private var username: String = "" // Simpan username dari Latihan 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
        setContentView(R.layout.activity_latihan3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ambil username dari Latihan2, Jika Null, amankan dengan string kosong.
        username = intent.getStringExtra("username") ?: ""

        // Daftarkan id pada xml activity_latihan3 ke file ini
        val tvHeaderLatihan3 = findViewById<TextView>(R.id.tvHeaderLatihan3)
        val btnBerandaLatihan3 = findViewById<Button>(R.id.btnBerandaLatihan3)
        val btnTentangLatihan3 = findViewById<Button>(R.id.btnTentangLatihan3)

        // Tampilkan selamat datang dengan username yang diterima
        tvHeaderLatihan3.text = "Selamat Datang, $username"

        // Tampilkan BerandaFragment sebagai fragment default saat Activity dibuka
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerLatihan3,
                    BerandaFragment()).commit()
        }

        // Buat event button Beranda untuk tampilan BerandaFragment
        btnBerandaLatihan3.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerLatihan3,
                    BerandaFragment()).commit()
        }

        // Buat event button Tentang untuk tampilan TentangFragment
        btnTentangLatihan3.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerLatihan3,
                    TentangFragment()).commit()
        }

    }

    // Buat fungsi diluar onCreate agar dapat diakses oleh file lain
    fun bukaLatihan4(){
        val intentLatihan3 = Intent(this, Latihan4::class.java)
        intentLatihan3.putExtra("username", username)
        startActivity(intentLatihan3)
    }
}
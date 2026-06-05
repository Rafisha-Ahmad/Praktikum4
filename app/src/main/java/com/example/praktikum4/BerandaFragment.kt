package com.example.praktikum4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class BerandaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflate (mengubah) Layout XML menjadi Objek View
        val view = inflater.inflate(R.layout.fragment_beranda, container, false)

        // Pendaftaran id btnMulaiBeranda pada fragment ini
        val btnMulaiBeranda = view.findViewById<Button>(R.id.btnMulaiBeranda)

        // Saat tombol diklik, panggil method bukaLatihan4() pada Latihan3.kt
        btnMulaiBeranda.setOnClickListener {
            (activity as Latihan3).bukaLatihan4()
        }
        return view // Kembalikan View supaya ditampilkan oleh Fragment
    }
}
package com.example.ngeruntah.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ngeruntah.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setInitLayout()
    }

    private fun setInitLayout() {
        jemput_sampah.setOnClickListener{
            val intent = Intent(this, JemputSampahActivity::class.java)
            startActivity(intent)
        }
        jenis_sampah.setOnClickListener{
            val intent = Intent(this, JenisSampahActivity::class.java)
            startActivity(intent)
        }
        saldo_riwayat.setOnClickListener{
            val intent = Intent(this, RiwayatActivity::class.java)
            startActivity(intent)
        }
        profile_icon.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }


}
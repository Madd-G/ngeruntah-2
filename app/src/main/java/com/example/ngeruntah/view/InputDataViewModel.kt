package com.example.ngeruntah.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class InputDataViewModel(application: Application) : AndroidViewModel(application) {

    fun addDataSampah(
        jenis_sampah: String,
        berat: Int,
        harga: Int,
        tanggal: String,
        alamat: String,
        catatan: String
    ) {
    }
}
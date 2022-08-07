package com.example.ngeruntah.view

import ServiceInterface
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.ngeruntah.R
import com.example.ngeruntah.view.network.Repository
import kotlinx.android.synthetic.main.activity_jemput_sampah.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


class JemputSampahActivity : AppCompatActivity() {
    lateinit var btnSubmit: Button

    lateinit var inputDataViewModel: InputDataViewModel
    lateinit var etBerat: EditText
    lateinit var etTanggal: EditText
    lateinit var etAlamat: EditText
    lateinit var etCatatan: EditText
    lateinit var strBerat: String
    lateinit var strTanggal: String
    lateinit var strAlamat: String
    lateinit var strCatatan: String
    lateinit var strKategoriSelected: String
    lateinit var strHargaSelected: String
    lateinit var strKategori: Array<String>
    lateinit var strHarga: Array<String>
    lateinit var apiService: ServiceInterface
    lateinit var btnadd: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jemput_sampah)

        btnadd = findViewById(R.id.btnCheckout)
        btnadd.setOnClickListener {
            val array = DataRiwayat()
            array.weight = etBerat.text.toString().toInt()
            array.date = etTanggal.text.toString()
            array.address = etAlamat.text.toString()
            array.note = etCatatan.text.toString()
            apiService.postData(array).enqueue(object : Callback<DataRiwayat> {
                override fun onResponse(call: Call<DataRiwayat>, response: Response<DataRiwayat>) {
                    startActivity(Intent(this@JemputSampahActivity, RiwayatActivity::class.java))
                    Toast.makeText(baseContext, "Add Data Success", Toast.LENGTH_SHORT).show()

                }

                override fun onFailure(call: Call<DataRiwayat>, t: Throwable) {
                    Toast.makeText(baseContext, "Add Data Failed", Toast.LENGTH_SHORT).show()
                }

            })
            startActivity(Intent(this, RiwayatActivity::class.java))
        }

        btnSubmit = findViewById(R.id.btnCheckout)
        etBerat = findViewById(R.id.inputBerat)
        etTanggal = findViewById(R.id.inputTanggal)
        etAlamat = findViewById(R.id.inputAlamat)
        etCatatan = findViewById(R.id.inputCatatan)
        apiService = Repository.getDataAPI().create(ServiceInterface::class.java)


        inputTanggal.setOnClickListener { view: View? ->
            val tanggalJemput = Calendar.getInstance()
            val date =
                DatePickerDialog.OnDateSetListener { view1: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                    tanggalJemput[Calendar.YEAR] = year
                    tanggalJemput[Calendar.MONTH] = monthOfYear
                    tanggalJemput[Calendar.DAY_OF_MONTH] = dayOfMonth
                    val strFormatDefault = "d MMMM yyyy"
                    val simpleDateFormat = SimpleDateFormat(strFormatDefault, Locale.getDefault())
                    inputTanggal.setText(simpleDateFormat.format(tanggalJemput.time))
                }
            DatePickerDialog(
                this@JemputSampahActivity, date,
                tanggalJemput[Calendar.YEAR],
                tanggalJemput[Calendar.MONTH],
                tanggalJemput[Calendar.DAY_OF_MONTH]
            ).show()
        }
    }
}
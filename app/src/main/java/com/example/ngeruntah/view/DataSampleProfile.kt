package com.example.ngeruntah.view

object DataSampleProfile {
    private val username = arrayOf(
        "chandra ayunda"
    )
    private val email = arrayOf(
        "candraayunda@gmail.com"
    )
    private val no_telepon = arrayOf(
        "098765433456"
    )
    private val jenis_kelamin = arrayOf(
        "perempuan"
    )
    val listData: ArrayList<DataProfile>
        get() {
            val listDataku = arrayListOf<DataProfile>()
            for (position in username.indices) {
                val data = DataProfile()
                data.username = username[position]
                data.email = email[position]
                data.no_telepon = no_telepon[position]
                data.jenis_kelamin = jenis_kelamin[position]
                listDataku.add(data)
            }
            return listDataku
        }
}
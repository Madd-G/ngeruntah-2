package com.example.ngeruntah.view

object DataSampleLogin {
    private val email = arrayOf(
        "candraayunda@gmail.com"

    )
    private val password = arrayOf(
        "Chandra123#"
    )

    val listData: ArrayList<DataLogin>
        get() {
            val listDataku = arrayListOf<DataLogin>()
            for (position in email.indices) {
                val data = DataLogin()
                data.email = email[position]
                data.password = password[position]
                listDataku.add(data)
            }
            return listDataku
        }

}
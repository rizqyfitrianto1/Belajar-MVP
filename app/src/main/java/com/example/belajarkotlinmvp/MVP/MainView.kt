package com.example.belajarkotlinmvp.MVP

interface MainView {

    //membuat method menampilkan toast

    fun tampilPesan(pesan : String)

    //method untuk menampilkan data yang sudah di proses pada presenter

    fun tampilData(data : String)

    // method untuk clear edittext

    fun clearField()
}
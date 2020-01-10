package com.example.belajarkotlinmvp.MVP

import android.text.TextUtils

class MainPresenterImp(private val view: MainMVP) : MainPresenter {

    //membuat array list menampung data

    private val DATA = ArrayList<HashMap< String, String>>()

    override fun tambahData(namaPertama: String, namaTerakhir: String) {

        if (TextUtils.isEmpty(namaPertama) || (TextUtils.isEmpty(namaTerakhir))){
            //menampilkan toast jika salah satu edit tesxt kosong
            view.tampilPesan("Harus di isi semua gan")
        }else{
            //hashMap
            val map = HashMap<String, String>()

            //menambah dua value pada hashMap
            map.put("namaPertama", namaPertama)
            map.put("namaTerakhir", namaTerakhir)

            //data hashMap sudah diisi kemudian ditampung arrayLIst
            DATA.add(map)

            //menampilkan view ketika data telah berhasil dimasukkan
            view.tampilPesan("Data sudah masuk")

            //membersihkan field edittext
            view.clearField()
        }
    }

    //melakukan proses data yang ada pada interfaCE PRESENTER
    override fun prosesData() {

        if (DATA.size == 0){
            view.tampilPesan("data kosong???")
        }else {
            var alldata = ""

            //melakukan for loop untuk mengisi variable alldata dengan setiap value tang ada di arraylist
            for (i in 0 until DATA.size) {
                alldata += "Nama Depan : " + DATA[i].get("namaPertama") + "\nNama Belakang : " + DATA[i].get("namaTerakhir") + "\n\n"
            }
            alldata += "Total" +DATA.size

            view.tampilData(alldata)
        }
    }
}
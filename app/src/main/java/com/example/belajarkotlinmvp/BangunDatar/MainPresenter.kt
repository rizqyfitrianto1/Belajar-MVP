package com.example.belajarkotlinmvp.BangunDatar

import com.example.belajarkotlinmvp.BangunDatar.Base.BasePresenter
import com.example.belajarkotlinmvp.BangunDatar.Model.HasilModel

class MainPresenter : BasePresenter<MainView> {

    //membuat deklarasi
    var modelview : MainView? = null

    constructor(modelview: MainView?) {
        this.modelview = modelview
    }

    //bikin function hitung
    fun hitung (satu : String, dua : String){
        //membuat kondisional
        if (satu.isNotEmpty() && dua.isNotEmpty()){
            val nilai1 = satu.toDouble()
            val nilai2 = dua.toDouble()
            val hasil = nilai1 * nilai2
            val  model = HasilModel(hasil.toString())

            //masuk ke view
            modelview?.success(model)
        }else{
            //response ke view kalau stringnya kosong
            modelview?.error()
        }
    }

    override fun onAttach(view: MainView) {

        modelview = view
    }

    override fun onDettach() {

        modelview = null
    }
}
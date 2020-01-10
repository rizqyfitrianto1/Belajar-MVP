package com.example.belajarkotlinmvp.AnkoMVP

import com.example.belajarkotlinmvp.AnkoMVP.Model.ModelMvp

class FirstPresenterImp (model : FirstView) : FirstPresenter{
    override fun tambahData(msg: String) {
        if (msg.isNotEmpty()){
            var model = ModelMvp(msg)

            //menambahkan ke view
            viewmodel?.berhasil(model)
        }else{
            //kalau nanti kosong
            viewmodel?.error()
        }
    }

    var viewmodel : FirstView? = null

    init {
        viewmodel = model
    }
}
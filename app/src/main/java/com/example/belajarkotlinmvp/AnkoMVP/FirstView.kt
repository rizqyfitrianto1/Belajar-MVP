package com.example.belajarkotlinmvp.AnkoMVP

import com.example.belajarkotlinmvp.AnkoMVP.Model.ModelMvp

interface FirstView {

    fun berhasil(hasil : ModelMvp)
    fun error()
}
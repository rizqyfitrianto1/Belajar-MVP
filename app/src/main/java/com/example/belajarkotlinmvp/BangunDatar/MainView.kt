package com.example.belajarkotlinmvp.BangunDatar

import com.example.belajarkotlinmvp.BangunDatar.Base.BaseView
import com.example.belajarkotlinmvp.BangunDatar.Model.HasilModel

interface MainView : BaseView {

    fun success(hasil : HasilModel)
    fun error()
}
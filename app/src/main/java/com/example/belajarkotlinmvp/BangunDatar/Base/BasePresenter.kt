package com.example.belajarkotlinmvp.BangunDatar.Base

interface BasePresenter <in T : BaseView> {

    fun onAttach(view: T)
    fun onDettach()
}
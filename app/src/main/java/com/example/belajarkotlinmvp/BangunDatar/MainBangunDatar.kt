package com.example.belajarkotlinmvp.BangunDatar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.belajarkotlinmvp.BangunDatar.Model.HasilModel
import com.example.belajarkotlinmvp.R
import kotlinx.android.synthetic.main.lay_bangundatar.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton

class MainBangunDatar : AppCompatActivity(), MainView {

    //deklarasi presenter

    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lay_bangundatar)

        //inisialisasi presenter
        presenter = MainPresenter(this)

        btn_hitung.setOnClickListener {
            presenter.hitung(edt_nilai1.text.toString(), edt_nilai2.text.toString())
        }
    }

    override fun success(hasil: HasilModel) {
        alert {
            title = hasil.hasilModel
            noButton {  }
            yesButton {  }
        }.show()
    }

    override fun error() {
        toast("jangan kosong yak")
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDettachView() {
        onDettachView()
    }
}
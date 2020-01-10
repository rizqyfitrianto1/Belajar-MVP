package com.example.belajarkotlinmvp.AnkoMVP

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.belajarkotlinmvp.AnkoMVP.Model.ModelMvp
import com.example.belajarkotlinmvp.R
import kotlinx.android.synthetic.main.lay_ankomvp.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton

class MainAnkoMvp : AppCompatActivity(), FirstView {

    //deklarasi presenter
    lateinit var presenterImp: FirstPresenterImp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lay_ankomvp)

        //inisialisasi presenter

        presenterImp = FirstPresenterImp(this)

        btn_input.setOnClickListener {
            presenterImp.tambahData(edt_data.text.toString())
        }
    }

    override fun berhasil(hasil: ModelMvp) {
        //menampilkan data di alert
        alert {
            title = hasil.textmsg

            noButton {

            }

            yesButton {
                d -> d.dismiss()
            }
        }.show()
    }

    override fun error() {
        //menampilkan toast jika data hilang
        toast("data tidak boleh kosong")
    }
}
package com.example.belajarkotlinmvp.MVP

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.belajarkotlinmvp.R
import kotlinx.android.synthetic.main.lay_datamvp.*

class MainMVP : AppCompatActivity(), MainView {

    //ambil presenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lay_datamvp)

        //init presenter
        presenter = MainPresenterImp(this)

        //fungsi button add

        btn_add.setOnClickListener {
            //memanggil method tambahData() pada presenter
            presenter.tambahData(edt_firstname.text.toString(), edt_lastname.text.toString())
        }

        //fungsi button tampil data

        btn_show.setOnClickListener {
            //memanggil method tampilData()
            presenter.prosesData()
        }
    }
    override fun tampilPesan(pesan: String) {
        Toast.makeText(applicationContext, pesan, Toast.LENGTH_SHORT).show()
    }

    override fun tampilData(data: String) {
        AlertDialog.Builder(this)
            .setTitle("Tampil Data")
            .setIcon(R.drawable.ic_list)
            .setMessage(data)
            .setPositiveButton("Close",
                DialogInterface.OnClickListener
                {dialogInterface, i ->  dialogInterface.dismiss()}
            ).show()
    }

    override fun clearField() {
        edt_firstname.setText("")
        edt_lastname.setText("")
    }
}
package com.example.desafios

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_conversor_de_comprimento.*

class ConversorDeComprimentoActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View) {
        val id = v.id

        when(id) {
            R.id.btn_back -> onBackPressed()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_de_comprimento)

        vincular()
    }

    private fun vincular() {
        btn_back.setOnClickListener(this)
    }
}
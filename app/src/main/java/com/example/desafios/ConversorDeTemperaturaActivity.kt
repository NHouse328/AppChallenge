package com.example.desafios

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_conversor_de_temperatura.*

class ConversorDeTemperaturaActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View) {
        val id = v.id

        when(id) {
            R.id.btn_back -> onBackPressed()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_de_temperatura)

        vincular()

        val itens = arrayListOf<String>("Grau Celsius (oC)","Graus Fahrenheit (oF)","Kelvin (K)")
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,itens)

        spinner1.adapter = adapter
        spinner2.adapter = adapter
    }

    private fun vincular() {
        btn_back.setOnClickListener(this)
    }
}

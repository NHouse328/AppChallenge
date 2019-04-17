package com.example.desafios

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_conversor_de_comprimento.*

class ConversorDeComprimentoActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View) {
        val id = v.id

        when(id) {
            R.id.btn_back -> onBackPressed()
            R.id.btn_calcular_conv_comprimento -> {
                when {
                    spinner1.selectedItemPosition == spinner2.selectedItemPosition -> {
                        Toast.makeText(this,"Mude uma unidade de Comprimento !", Toast.LENGTH_SHORT).show()
                    }
                    edt_num_conv_comprimento.editableText.isNullOrEmpty() -> {
                        Toast.makeText(this,"Digite um Comprimento", Toast.LENGTH_SHORT).show()
                    }
                    else -> txv_result_conv_comprimento.text = converterComprimento(
                        spinner1.selectedItemPosition,
                        spinner2.selectedItemPosition,
                        edt_num_conv_comprimento.editableText.toString().toDouble()
                    )
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_de_comprimento)

        vincular()

        val itens = arrayListOf(
            "yottametro (Ym)",
            "zettametro (Zm)",
            "exametro (Em)",
            "petametro (Pm)",
            "terametro (Tm)",
            "gigametro (Gm)",
            "megametro (Mm)",
            "quilômetro (km)",
            "hectômetro (hm)",
            "decâmetro (dam)",
            "metro (m)",
            "decímetro (dm)",
            "centímetro (cm)",
            "milímetro (mm)",
            "micrômetro (µm)",
            "nanômetro (nm)",
            "picômetro (pm)",
            "fentômetro (fm)",
            "attômetro (am)",
            "zeptômetro (zm)",
            "yoctômetro (ym)",
            "milha (mi)",
            "jarda (yd)",
            "pé (ft)",
            "polegada (in)",
            "milha nautica"
        )
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,itens)

        spinner1.adapter = adapter
        spinner2.adapter = adapter

        spinner1.setSelection(10)
        spinner2.setSelection(7)
    }

    private fun vincular() {
        btn_back.setOnClickListener(this)
        btn_calcular_conv_comprimento.setOnClickListener(this)
    }

    private fun converterComprimento(de: Int,para: Int,comprimento: Double): String {

        var comprimentoNovo = comprimento

        val primeiro = when (de) {
            0 -> 24.0
            1 -> 21.0
            2 -> 18.0
            3 -> 15.0
            4 -> 12.0
            5 -> 9.0
            6 -> 6.0
            7 -> 3.0
            8 -> 2.0
            9 -> 1.0
            10 -> 0.0
            11 -> -1.0
            12 -> -2.0
            13 -> -3.0
            14 -> -6.0
            15 -> -9.0
            16 -> -12.0
            17 -> -15.0
            18 -> -18.0
            19 -> -21.0
            20 -> 24.0
            else -> 0.0
        }

        when (de) {
            21 -> comprimentoNovo = comprimento * 1609.344
            22 -> comprimentoNovo = comprimento / 1.094
            23 -> comprimentoNovo = comprimento / 3.281
            24 -> comprimentoNovo = comprimento / 39.37
            25 -> comprimentoNovo = comprimento * 1852
        }

        val segundo = when (para) {
            0 -> 24.0
            1 -> 21.0
            2 -> 18.0
            3 -> 15.0
            4 -> 12.0
            5 -> 9.0
            6 -> 6.0
            7 -> 3.0
            8 -> 2.0
            9 -> 1.0
            10 -> 0.0
            11 -> -1.0
            12 -> -2.0
            13 -> -3.0
            14 -> -6.0
            15 -> -9.0
            16 -> -12.0
            17 -> -15.0
            18 -> -18.0
            19 -> -21.0
            20 -> 24.0
            else -> 0.0
        }

        var result:Double

        val diferenca = primeiro - segundo
        result = comprimentoNovo * Math.pow(10.0, diferenca)

        when (para) {
            21 -> result /= 1609.344
            22 -> result *= 1.094
            23 -> result *= 3.281
            24 -> result *= 39.37
            25 -> result /= 1852
        }

        return ("%.4f".format(result))

    }
}

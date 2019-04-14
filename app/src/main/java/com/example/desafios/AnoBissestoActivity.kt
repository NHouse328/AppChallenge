package com.example.desafios

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ano_bissesto.*

class AnoBissestoActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View) {
        val id = v.id

        when(id) {
            R.id.btn_back -> onBackPressed()
            R.id.btn_verificar_ano_bissesto -> {
                if (edt_num_ano_bissesto.editableText.isNullOrEmpty()){
                    Toast.makeText(this,"Digite um número", Toast.LENGTH_SHORT).show()
                }else {
                    txv_result_ano_bissesto.text = anoBissesto(edt_num_ano_bissesto.editableText.toString())
                    edt_num_ano_bissesto.text = null

                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ano_bissesto)

        vincular()
    }

    private fun vincular() {
        btn_back.setOnClickListener(this)
        btn_verificar_ano_bissesto.setOnClickListener(this)
    }

    fun anoBissesto(ano: String): String {
        val Ano = ano.toInt()

        val mensagem = "é um ano Bissesto"

        if ((Ano % 4) == 0) {
            if ((Ano % 100) != 0) {
                return "$Ano $mensagem"
            }else {
                return "$Ano não $mensagem"
            }
        }else {
            if ((Ano % 400) == 0) {
                return "$Ano $mensagem"
            }else {
                return "$Ano não $mensagem"
            }
        }
    }
}

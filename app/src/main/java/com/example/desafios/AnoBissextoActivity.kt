package com.example.desafios

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ano_bissexto.*

class AnoBissextoActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View) {
        val id = v.id

        when(id) {
            R.id.btn_back -> onBackPressed()

            R.id.btn_verificar_ano_bissexto -> {
                if (edt_num_ano_bissexto.editableText.isNullOrEmpty()){
                    Toast.makeText(this,"Digite um número", Toast.LENGTH_SHORT).show()
                }else {
                    txv_result_ano_bissexto.text = anoBissesto(edt_num_ano_bissexto.editableText.toString().toInt())
                    edt_num_ano_bissexto.text = null

                }
            }

            R.id.btn_verificar_de_ate_ano_bissexto -> {

                if (edt_de_ano_bissexto.editableText.isNullOrEmpty() || edt_ate_ano_bissexto.editableText.isNullOrEmpty()){
                    Toast.makeText(this,"Preencha de que Ano até que Ano !", Toast.LENGTH_SHORT).show()
                }else if (
                    edt_de_ano_bissexto.editableText.toString().toInt() > edt_ate_ano_bissexto.editableText.toString().toInt()
                        ){
                    Toast.makeText(this,"O último ano deve ser maior que o primeiro !", Toast.LENGTH_SHORT).show()
                } else {
                    spn_result_ano_bissexto.adapter = null

                    val casas = deAteAnoBissexto(
                        edt_de_ano_bissexto.editableText.toString().toInt(),
                        edt_ate_ano_bissexto.editableText.toString().toInt()
                    ).toList().toTypedArray()

                    val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, casas)

                    spn_result_ano_bissexto.adapter = adapter

                    Toast.makeText(this,"Atualizado !", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ano_bissexto)

        vincular()
    }

    private fun vincular() {
        btn_back.setOnClickListener(this)
        btn_verificar_ano_bissexto.setOnClickListener(this)
        btn_verificar_de_ate_ano_bissexto.setOnClickListener(this)
    }

    private fun anoBissesto(ano: Int): String {

        val mensagem = "é um ano Bissexto"

        return if ((ano % 4) == 0) {
            if ((ano % 100) != 0) {
                "$ano $mensagem"
            }else {
                "$ano não $mensagem"
            }
        }else {
            if ((ano % 400) == 0) {
                "$ano $mensagem"
            }else {
                "$ano não $mensagem"
            }
        }
    }

    private fun deAteAnoBissexto(de: Int, ate: Int): Array<String> {
        var list: Array<String> = emptyArray()

        list += "Anos"

        for (ano in de..ate) {

            if ((ano % 4) == 0) {
                if ((ano % 100) != 0) {
                    list += "$ano"
                }
            }else {
                if ((ano % 400) == 0) {
                    list += "$ano"
                }
            }

        }

        return list

    }
}

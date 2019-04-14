package com.example.desafios

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_par_ou_impar.*

class ParOuImparActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View) {
        val id = v.id

        when(id) {
            R.id.btn_back -> onBackPressed()
            R.id.btn_verificar_par_ou_impar -> {
                if (edt_num_par_ou_impar.editableText.isNullOrEmpty()){
                    Toast.makeText(this,"Digite um número", Toast.LENGTH_SHORT).show()
                }else {
                    txv_result_par_ou_impar.text = parOuImpar(edt_num_par_ou_impar.editableText.toString())
                    edt_num_par_ou_impar.text = null

                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_par_ou_impar)

        vincular()
    }

    private fun vincular() {
        btn_back.setOnClickListener(this)
        btn_verificar_par_ou_impar.setOnClickListener(this)
    }

    fun parOuImpar(num: String): String {
        val numero: Int = num.toInt()

        if((numero % 2) == 0) {
            return "$numero é Par !"
        }else {
            return "$numero é Ímpar !"
        }
    }
}

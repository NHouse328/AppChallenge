package com.example.desafios

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View) {
        val id = v.id

        when(id) {
            R.id.btn_to_screen_par_ou_impar -> {
                val intent = Intent(this, ParOuImparActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_to_screen_ano_bissesto -> {
                val intent = Intent(this, AnoBissextoActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_to_screen_conversor_temperatura -> {
                val intent = Intent(this, ConversorDeTemperaturaActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_to_screen_conversor_comprimento -> {
                val intent = Intent(this, ConversorDeComprimentoActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_to_screen_chopp_ware -> {
                val intent = Intent(this, ChoppWareActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vincular()
    }

    private fun vincular() {
        btn_to_screen_par_ou_impar.setOnClickListener(this)
        btn_to_screen_ano_bissesto.setOnClickListener(this)
        btn_to_screen_conversor_temperatura.setOnClickListener(this)
        btn_to_screen_conversor_comprimento.setOnClickListener(this)
        btn_to_screen_chopp_ware.setOnClickListener(this)
    }
}

package com.example.desafios

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_conversor_de_temperatura.*

class ConversorDeTemperaturaActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View) {
        val id = v.id

        when(id) {
            R.id.btn_back -> onBackPressed()
            R.id.btn_calcular_conv_temp -> {
                when {
                    spinner1.selectedItemPosition == spinner2.selectedItemPosition -> {
                        Toast.makeText(this,"Mude uma unidade de Temperatura !", Toast.LENGTH_SHORT).show()
                    }
                    edt_num_conv_temp.editableText.isNullOrEmpty() -> {
                        Toast.makeText(this,"Digite uma Temperatura", Toast.LENGTH_SHORT).show()
                    }
                    else -> txv_result_conv_temp.text = converterTemperatura(
                        spinner1.selectedItemPosition,
                        spinner2.selectedItemPosition,
                        edt_num_conv_temp.editableText.toString()
                    )
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_de_temperatura)

        vincular()

        val itens = arrayListOf("Grau Celsius (ºC)","Graus Fahrenheit (ºF)","Kelvin (K)")
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,itens)

        spinner1.adapter = adapter
        spinner2.adapter = adapter

    }

    private fun vincular() {
        btn_back.setOnClickListener(this)
        btn_calcular_conv_temp.setOnClickListener(this)
    }

    private fun converterTemperatura(de: Int, para: Int, temp: String): String {
        val temperatura: Float = temp.toFloat()

        return when(de) {
            0 -> {
                when(para) {
                    1 -> celciusFahrenheit(temperatura,1).toString()
                    2 -> celciusKelvin(temperatura,1).toString()
                    else -> "erro1"
                }
            }
            1 -> {
                when(para) {
                    0 -> celciusFahrenheit(temperatura,2).toString()
                    2 -> celciusKelvin(celciusFahrenheit(temperatura,2),1).toString()
                    else -> "erro2"
                }
            }
            2 -> {
                when(para) {
                    0 -> celciusKelvin(temperatura,2).toString()
                    1 -> celciusFahrenheit(celciusKelvin(temperatura,2),1).toString()
                    else -> "erro3"
                }
            }
            else -> "erro0"
        }
    }

    private fun celciusFahrenheit(temperatura: Float,sentido: Int): Float {
        return when(sentido) {
            1 -> (temperatura * (9F / 5F)) + 32F //(0 °C × 9/5) + 32
            2 -> (temperatura - 32F) * (5F / 9F) //(0 °F − 32) × 5/9
            else -> 0F
        }
    }

    private fun celciusKelvin(temperatura: Float,sentido: Int): Float {
        return when(sentido) {
            1 -> temperatura + 273.15F
            2 -> temperatura - 273.15F
            else -> 0F
        }
    }

}

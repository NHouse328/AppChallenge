package com.example.desafios

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View) {
        val id = v.id

        when (id) {
            R.id.btn_to_screen_par_ou_impar -> {
                val intent = Intent(this, ParOuImparActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

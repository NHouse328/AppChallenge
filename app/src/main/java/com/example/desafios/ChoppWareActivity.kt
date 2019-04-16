package com.example.desafios

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_chopp_ware.*

class ChoppWareActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View) {
        val id = v.id

        when (id) {
            R.id.btn_back -> onBackPressed()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chopp_ware)

        vincular()
    }

    private fun vincular () {
        btn_back.setOnClickListener(this)
    }
}

package com.example.myapplication.IMC

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.IMC.IMCActivity.Companion.IMC_KEY
import com.example.myapplication.R

class ResultIMCActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0//si no tiene valor que devuelva un doble -1.0
        val tvResultIMC = findViewById<TextView>(R.id.tvResultIMC)
        tvResultIMC.text = "${result}"//al tvREsult l
    }
}
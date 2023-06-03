package com.example.myapplication.IMC

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.myapplication.IMC.IMCActivity.Companion.IMC_KEY
import com.example.myapplication.R

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var btnRecalcutate: Button
    private lateinit var tvResult:TextView
    private lateinit var tvResultIMC: TextView
    private lateinit var tvDescription:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)//obtenemos el resultado de la vista anterior
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0//si no tiene valor que devuelva un doble -1.0
        initComponent()
        initUI(result)
        initListener()
    }

    private fun initListener(){
        btnRecalcutate.setOnClickListener { onBackPressed() }
    }
    fun initComponent(){
        tvResultIMC = findViewById(R.id.tvResultIMC)
        btnRecalcutate = findViewById(R.id.btnRecalcutate)
        tvResult  = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
    }

    fun initUI(result: Double) {
        tvResultIMC.text = "${result}"//al tvREsult l
        when(result){//when result esta in from 0.00 to 18.50 que haga...
            in 0.00..18.50 ->{//BAJO PESO
                tvDescription.text =getString(R.string.description_bajo)//lo obtenemos de los strings
                tvResult.text =getString(R.string.title_bajo)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.alert))

            }
            in 18.51..24.99 ->{//BAJO NORMAL
                tvDescription.text =getString(R.string.description_normal)
                tvResult.text =getString(R.string.title_normal)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.success))

            }
            in 25.00..29.99 ->{//SOBREPESO
                tvDescription.text =getString(R.string.description_sobrepeso)
                tvResult.text =getString(R.string.title_sobrepeso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.alert))//para cambiarle de color al texto desde los colos.xml
            }
            in 30.00..99.00 ->{//OBESIDAD
                tvDescription.text =getString(R.string.description_obesidad)
                tvResult.text =getString(R.string.title_obesidad)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.danger))

            }
            else->{//errror
                tvResultIMC.text = getString(R.string.error)//al tvREsult l
                tvDescription.text =getString(R.string.error)
                tvResult.text=getString(R.string.error)
            }
        }
    }
}
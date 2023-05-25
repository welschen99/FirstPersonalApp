package com.example.myapplication.IMC

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.myapplication.R
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class IMCActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false

    private lateinit var viewMale:CardView//declaro el componente como privado
    private lateinit var viewFemale:CardView
    private lateinit var tvHeight:TextView
    private lateinit var rsLiner:RangeSlider

    override fun onCreate(savedInstanceState: Bundle?) {//el primer metodo que se llama
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        initComponent()
        initListeners()
        initUI()
    }

    private fun initComponent(){
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsLiner = findViewById(R.id.rsHeight)
    }
    private fun initListeners(){
        viewMale.setOnClickListener{
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener{
            changeGender()
            setGenderColor()
        }
        rsLiner.addOnChangeListener {_,value,_ ->
            val df = DecimalFormat("#.##")//saco los decimales
            val result = df.format(value)
            tvHeight.text = "$result cm"//devuelvo el valor rexto
        }
    }

    private fun changeGender(){
        isMaleSelected = !isMaleSelected//para cambiar el estado de seleccionado a false
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(getBackgrouColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgrouColor(isFemaleSelected))
    }

    private fun getBackgrouColor(isSelectComponent:Boolean): Int{
        val colorReference = if(isSelectComponent){
            R.color.cardViewSelect //accede al colors.xml y busca la clase
        }else{
            R.color.cardViewNotSelect
        }

        return ContextCompat.getColor(this,colorReference)
    }
    private fun initUI() {
        setGenderColor()
    }
}
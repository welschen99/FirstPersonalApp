package com.example.myapplication.IMC

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.myapplication.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class IMCActivity : AppCompatActivity() {
//asignamos valores iniciales a las var
    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false
    private var currentWeight:Int = 70
    private var currentAge:Int = 10
    private var currentHeight:Int =120

//declaramos las variables
    private lateinit var viewMale:CardView//declaro el componente como privado
    private lateinit var viewFemale:CardView
    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var tvWeight:TextView
    private lateinit var tvAge:TextView
    private lateinit var btnCalculate:Button

    companion object{
        const val IMC_KEY = "IMC_RESULT"
    }
    //todo_ el mundo puede acceder a ello, CREAMOS ESTA CONSTANTE PARA QUE NO NOS EQUIVOQUEMOS EN LA KEY

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
        rsHeight = findViewById(R.id.rsHeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        tvWeight = findViewById(R.id.tvWeight)
        tvAge = findViewById(R.id.tvAge)
        btnCalculate = findViewById(R.id.btnCalculate)
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
        rsHeight.addOnChangeListener {_,value,_ ->
            val df = DecimalFormat("#.##")//saco los decimales
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"//devuelvo el valor rexto
        }
        btnPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight()//llamamos a una funcion para que le pase el parametro al text view
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight -=1
            setWeight()
        }
        btnPlusAge.setOnClickListener {
            currentAge+=1
            setAge()
        }
        btnSubtractAge.setOnClickListener {
            currentAge-=1
            setAge()
        }
        btnCalculate.setOnClickListener{
            val result = calculateIMC()
            navigateToResult(result)//creamos la funcion para llevar a otra vista con la variable result
        }

    }
    private fun navigateToResult(result:Double){
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY,result)
        startActivity(intent)
    }
    private fun calculateIMC():Double{
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble()/100 * currentHeight.toDouble()/100)
        val result = df.format(imc).toDouble()
        Log.i("imc","el imc es $result")
        return result
    }
    private fun setWeight(){
        tvWeight.text = currentWeight.toString()
    }
    private fun setAge(){
        tvAge.text = currentAge.toString()
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
        setWeight()
        setAge()
    }
}
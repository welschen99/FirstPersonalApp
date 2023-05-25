package com.example.myapplication.Menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.IMC.IMCActivity
import com.example.myapplication.R
import com.example.myapplication.fistApp.Home.FirstAppActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnSaludar = findViewById<Button>(R.id.btnSaludar)
        val btnIMC= findViewById<Button>(R.id.btnIMCApp)
        btnSaludar.setOnClickListener{navigatetoSaludar()}
        btnIMC.setOnClickListener{navigatetoIMC()}
    }

    private fun navigatetoIMC() {
        val intent = Intent(this, IMCActivity::class.java)//creamos el intent que es para navegar entre pantalla
        startActivity(intent)
    }

    private fun navigatetoSaludar(){//creamos una funcion privada para no llamarlo de afuera
        val intent = Intent(this, FirstAppActivity::class.java)//creamos el intent que es para navegar entre pantalla
        startActivity(intent)
    }
}
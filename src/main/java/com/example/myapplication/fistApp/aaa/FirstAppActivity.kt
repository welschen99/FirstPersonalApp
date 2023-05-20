package com.example.myapplication.fistApp.aaa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.example.myapplication.R
import android.content.Intent//importamos el intent

class FirstAppActivity : AppCompatActivity() {//para agrupar las funciones
    override fun onCreate(savedInstanceState: Bundle?) {//se ejecuta al arrancar la pantalla
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)//layout principal
        val btnStart = findViewById<AppCompatButton>(R.id.btnStart)//declara el boton de la vista
        val etName =findViewById<EditText>(R.id.etName)//declaramos el input

        btnStart.setOnClickListener{//Escucha cuando le hagan click
            var texto = etName.text.toString()//me devuelve el valor que esta dentro de la app
            if (texto.isNotEmpty()){
                Log.i("Logcat","Texto en consola: ${texto}")//Print Mensaje de consola
                val intent = Intent(this, ResultActivity::class.java)//creamos el intent que es para navegar entre pantalla donde el this se refiere a la pantalla de FirstAppActivity y lo enviamos al Result Activiy
                intent.putExtra("EXTRA_NAME",texto)//al intent cuando lo lanzamos le ponemos la clave extra name que contiene el 'texto'
                startActivity(intent)
            }
        }

    }
}
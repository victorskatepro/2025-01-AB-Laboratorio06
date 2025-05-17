package com.saico.victor.laboratorio06

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio04Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio04)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val edtName = findViewById<EditText>(R.id.edtName)
        val edtLastName = findViewById<EditText>(R.id.edtLastName)
        val edtMail = findViewById<EditText>(R.id.edtMail)
        val btnSend = findViewById<Button>(R.id.btnSend)

        btnSend.setOnClickListener {
            val name = edtName.text.toString()
            val lastName = edtLastName.text.toString()
            val mail = edtMail.text.toString()
            Toast.makeText(this, "Nombre: $name, Apellido: $lastName, Correo: $mail", Toast.LENGTH_SHORT).show()
            tvTitle.text = "Formulario Completado"

            edtName.text.clear()
            edtLastName.text.clear()
            edtMail.text.clear()
        }
    }
}
package com.saico.victor.laboratorio06

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio01Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio01)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val vw1 = findViewById<View>(R.id.vw1)
        val vw2 = findViewById<View>(R.id.vw2)
        val vw3 = findViewById<View>(R.id.vw3)
        val vw4 = findViewById<View>(R.id.vw4)
        val vw5 = findViewById<View>(R.id.vw5)
        val vw6 = findViewById<View>(R.id.vw6)

        val array = arrayOf(vw1, vw2, vw3, vw4, vw5, vw6)

        array.forEachIndexed { index, view ->
            Handler(Looper.getMainLooper()).postDelayed({
                view.visibility = View.GONE
            }, index * 2000L)
        }
    }
}
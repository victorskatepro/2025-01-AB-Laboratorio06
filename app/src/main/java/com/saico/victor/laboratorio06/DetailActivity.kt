package com.saico.victor.laboratorio06

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.saico.victor.laboratorio06.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private val NAME_KEY = "NAME_KEY"
    private val EMAIL_KEY = "EMAIL_KEY"
    private val PHONE_KEY = "PHONE_KEY"
    private val OFFICE_KEY = "OFFICE_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onResume() {
        super.onResume()
        showInformation()
    }

    private fun showInformation() {
        val bundle = intent.extras
        if (bundle != null) {
            val name = bundle.getString(NAME_KEY)
            val email = bundle.getString(EMAIL_KEY)
            val phone = bundle.getString(PHONE_KEY)
            val office = bundle.getString(OFFICE_KEY)

            binding.tvName.text = "Nombre completo: $name"
            binding.tvEmail.text = "Correo electronico: $email"
            binding.tvPhone.text = "Número telefonico: $phone"
            binding.tvOffice.text = "Oficina: $office"
        }
    }

}
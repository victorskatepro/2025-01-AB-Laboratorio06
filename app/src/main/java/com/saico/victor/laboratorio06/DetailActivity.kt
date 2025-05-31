package com.saico.victor.laboratorio06

import android.content.Intent
import android.net.Uri
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
        observeButtons()
    }


    private fun observeButtons() {
        binding.imbWsp.setOnClickListener {
            goWsp()
        }

        binding.imbEmail.setOnClickListener {
            goEmail()
        }

        binding.imbDial.setOnClickListener {
            goDial()
        }

        binding.imbSms.setOnClickListener {
            goSms()
        }
    }

    private fun goWsp() {
        val bundle = intent.extras
        if (bundle != null && bundle.containsKey(PHONE_KEY)) {
            val phone = "+51${bundle?.getString(PHONE_KEY)}"
            val message = "Hola te he agregado a mi lista de contactos"

            val intentWsp = Intent()
            intentWsp.action = Intent.ACTION_VIEW
            intentWsp.data = Uri.parse("https://wa.me/$phone?text=$message")

            startActivity(intentWsp)
        }
    }

    private fun goEmail() {
        val bundle = intent.extras
        if (bundle != null && bundle.containsKey(EMAIL_KEY)) {
            val email = bundle?.getString(EMAIL_KEY)
            val message = "Hola te he agregado a mi lista de contactos"
            val subject = "Lista de contactos laboratorio 06"

            val intentEmail = Intent()
            intentEmail.action = Intent.ACTION_SENDTO
            intentEmail.data = Uri.parse("mailto: $email")
            intentEmail.putExtra(Intent.EXTRA_SUBJECT, subject)
            intentEmail.putExtra(Intent.EXTRA_TEXT, message)

            startActivity(intentEmail)
        }
    }

    private fun goDial() {

        val bundle = intent.extras
        if (bundle != null && bundle.containsKey(PHONE_KEY)) {
            val phone = bundle?.getString(PHONE_KEY)

            val intentDial = Intent()
            intentDial.action = Intent.ACTION_DIAL
            intentDial.data = Uri.parse("tel:$phone")

            startActivity(intentDial)
        }

    }

    private fun goSms() {
        val bundle = intent.extras
        if (bundle != null && bundle.containsKey(PHONE_KEY)) {
            val phone = bundle?.getString(PHONE_KEY)
            val message = "Hola te he agregado a mi lista de contactos"

            val intentSms = Intent()
            intentSms.action = Intent.ACTION_SENDTO
            intentSms.data = Uri.parse("smsto:$phone")
            intentSms.putExtra("sms_body", message)

            startActivity(intentSms)
        }
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
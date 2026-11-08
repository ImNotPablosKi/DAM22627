package com.example.prueba

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba.databinding.ActivityDetalleBinding

class DetalleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var bundle = intent.extras!!

        binding.textoDetalle.text = getString(R.string.saludito, bundle.getString("texto"))
        // binding.textoDetalle.setText(bundle.getString("texto"))

    }

}
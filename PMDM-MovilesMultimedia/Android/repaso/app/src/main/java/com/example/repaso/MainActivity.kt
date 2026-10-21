package com.example.repaso

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.repaso.databinding.ActivityMainBinding
import com.example.repaso.model.Datos

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bundle = intent.extras!!

        binding.tituloMain.setText("Bienvenido, " + bundle.getString("nombre"))

        val datos = intent.getParcelableExtra<Datos>("dato", Datos::class.java)

        binding.textView5.setText(datos?.descripcion ?: "Sin Descripción")

        // Recibir Foto
        binding.imagenFotoMain.setImageBitmap(intent.getParcelableExtra("foto"))

        binding.botonVolver.setOnClickListener {
            finish()
        }
    }
}
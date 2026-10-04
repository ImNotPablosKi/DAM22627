package org.iesch.practicamenupablo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.practicamenupablo.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bundle = intent.extras!!

        binding.textoSaludo.text = getString(R.string.saludo, bundle.getString("usuario"))

        binding.imageViewPerro.setOnClickListener {
            startActivity(Intent(this, EdadCaninaActivity::class.java))
        }

        binding.imageViewSuperHeroe.setOnClickListener {
            startActivity(Intent(this, HeroActivity::class.java))
        }

    }
}
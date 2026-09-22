package org.iesch.superheroes

import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.superheroes.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

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

        // Último paso: Recibimos los datos del MainActivity que hemos enviado
        val bundle = intent.extras!!
        val superHeroName = bundle.getString("superHeroName") ?: "No hay nombre." // Controlar nulos
        val alterEgo = bundle.getString("alterEgo") ?: "No hay un alter ego disponible."
        val bio = bundle.getString("bio") ?: "No hay una biografía disponible."
        val power = bundle.getFloat("power")

        // Rellenamos los campos con los valores recibidos
        binding.heroNameTv.text = superHeroName
        binding.alterEgoResult.text = alterEgo
        binding.bioResult.text = bio
        binding.ratingBar2.rating = power

    }
}
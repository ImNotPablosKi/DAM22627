package org.iesch.superheroes

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.superheroes.databinding.ActivityDetailBinding
import org.iesch.superheroes.model.SuperHeroe

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

        // val superHeroName = bundle.getString("superHeroName") ?: "No hay nombre." // Controlar nulos
        // val alterEgo = bundle.getString("alterEgo") ?: "No hay un alter ego disponible."
        // val bio = bundle.getString("bio") ?: "No hay una biografía disponible."
        // val power = bundle.getFloat("power")

        // 1 - Recibimos el objeto del Intent
        val superHeroe = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {

            // Para versiones SDK 33 o superiores
            intent.getParcelableExtra("superHeroe", SuperHeroe::class.java)

        } else {

            // Para versiones anteriores a SDK 33
            intent.getParcelableExtra<SuperHeroe>("superHeroe")

        }

        val bundle = intent.extras!!
        val bitmap = bundle.getParcelable<Bitmap>("foto_heroe")

        // Rellenamos los campos con los valores recibidos
        binding.heroNameTv.text = superHeroe?.nombre ?: "No hay nombre"
        binding.alterEgoResult.text = superHeroe?.alterEgo ?: "No hay alter ego"
        binding.bioResult.text = superHeroe?.bio ?: "No hay biografía"
        binding.ratingBar2.rating = superHeroe?.power ?: 0f // La f se pone porque es un float

        // Asigno la imagen a la ImageView
        binding.imageView.setImageBitmap(bitmap)

    }
}
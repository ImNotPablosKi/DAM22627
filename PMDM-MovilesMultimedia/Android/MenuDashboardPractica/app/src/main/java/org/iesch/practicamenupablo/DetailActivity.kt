package org.iesch.practicamenupablo

import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.practicamenupablo.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Recibir los datos del objeto
        // Depende de la versión del SDK
        val superheroe = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            // Para versiones SDK 33 o suepriores

            intent.getParcelableExtra("superHeroe", Superheroe::class.java)
        } else {
            // Para versiones anteriores que la 33
            intent.getParcelableExtra<Superheroe>("superHeroe")
        }



        binding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)
        // Recibir datos del intent
        val bundle = intent.extras!!

        val bitmapDirection = bundle.getString("path_heroe")
        val bitmap = BitmapFactory.decodeFile(bitmapDirection)

        // Rellenar los campos
        binding.heroNameTv.text = superheroe?.nombre ?: "No hay nombre"
        binding.alterEgoResult.text = superheroe?.alterEgo ?: "No hay alterego"
        binding.Bioesult.text = superheroe?.bio ?: "No hay bio"

        // Poner la foto que vaya sufrida
        binding.imagenHeroeGrande.setImageBitmap(bitmap)

        binding.ratingBar2.rating = superheroe?.poder ?: 0f // la f es para especificar float

    }
}
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
        // Recivo los datos del objeto
        // Dependiendo la versión del SDK uso una cosa u otra
        val superheroe = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            // Para versiones SDK 33 o suepriores

            intent.getParcelableExtra("superHeroe", Superheroe::class.java)
        } else {
            // Para versiones anteriores que la 33
            intent.getParcelableExtra<Superheroe>("superHeroe")
        }



        binding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

//        // Recivo los datos enviados con el intent
        val bundle = intent.extras!!
        //val bitmap = bundle.getParcelable<Bitmap>("foto_heroe")
        val bitmapDirection = bundle.getString("path_heroe")
        val bitmap = BitmapFactory.decodeFile(bitmapDirection)

//
//        val nombreSuperHeroe = bundle.getString("nombreSuperHeroe") ?: "No Hay nombre" // Esto es un elvis, es el texto que sale en caso de que esté vacío, un alt
//        val alterego = bundle.getString("alterego") ?: "No Hay alterego"
//        val bio = bundle.getString("bio") ?: "No Hay bio"
//        val power = bundle.getFloat("power")

        // Ahora hay que rellenar los campos
        binding.heroNameTv.text = superheroe?.nombre ?: "No hay nombre"
        binding.alterEgoResult.text = superheroe?.alterEgo ?: "No hay alterego"
        binding.Bioesult.text = superheroe?.bio ?: "No hay bio"

        //Pongo la foto
        binding.imagenHeroeGrande.setImageBitmap(bitmap)

        binding.ratingBar2.rating = superheroe?.poder ?: 0f // la f es para especificar float

    }
}
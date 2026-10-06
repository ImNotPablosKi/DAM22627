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
        // versión del SDK
        val superheroe = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            intent.getParcelableExtra("superHeroe", Superheroe::class.java)
        } else {
            intent.getParcelableExtra<Superheroe>("superHeroe")
        }



        binding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val bundle = intent.extras!!

        val bitmapDirection = bundle.getString("path_heroe")
        val bitmap = BitmapFactory.decodeFile(bitmapDirection)

        binding.heroNameTv.text = superheroe?.nombre ?: "No hay nombre"
        binding.alterEgoResult.text = superheroe?.alterEgo ?: "No hay alterego"
        binding.Bioesult.text = superheroe?.bio ?: "No hay bio"

        binding.imagenHeroeGrande.setImageBitmap(bitmap)

        binding.ratingBar2.rating = superheroe?.poder ?: 0f // la f es para especificar float

    }
}
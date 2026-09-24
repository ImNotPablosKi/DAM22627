package org.iesch.superheroes

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.superheroes.databinding.ActivityMainBinding
import org.iesch.superheroes.model.SuperHeroe

class MainActivity : AppCompatActivity() {

    // 1 - Creamos la variable lateinit, pues la vamos a inicializar luego
    private lateinit var binding: ActivityMainBinding

    // Variable para manejar el resultado de haber hecho una foto
    private lateinit var heroImage: ImageView
    private  var heroBitMap: Bitmap? = null
    private val getContent = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) {

        // Esto devuelve un objeto de tipo bitmap
        bitmap ->
            heroBitMap = bitmap
            heroImage.setImageBitmap(heroBitMap)

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 2 - Inicializamos el binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        // 3 - Usamos el binding para inflar la vista
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Listener para llamar a la cama
        heroImage = binding.HeroNameImage
        binding.HeroNameImage.setOnClickListener {

            abrirCamara()

        }



        // A partir de aquí introduzco el código necesario

        binding.botonGuardar.setOnClickListener {

            // Obtenemos los valores al momento de hacer click
            val superHeroName = binding.heroNameEdit.text.toString()
            val alterEgo = binding.heroNameEdit2.text.toString()
            val bio = binding.editTextText3.text.toString()
            val power = binding.power.rating

            // 2 - Me creo el objeto SuperHeroe
            val superHeroe = SuperHeroe(superHeroName, alterEgo, bio, power)

            // Qué quiero hacer cuando pulso el botón guardar
            irADetailActivity(superHeroe)

        }
    }

    fun abrirCamara() {

        // Abrimos la camara llamando al getContent
        getContent.launch(null)

    }

    fun irADetailActivity(superheroe: SuperHeroe) {

        // Creamos el objeto Intent
        val intent = Intent(this, DetailActivity::class.java)

        // Añadimos todos los campos con el método putExtra
        // De esta manera, todos estos datos se llevarán a la detailActivity
//        intent.putExtra("superHeroName", superheroe.nombre)
//        intent.putExtra("alterEgo", superheroe.alterEgo)
//        intent.putExtra("bio", superheroe.bio)
//        intent.putExtra("power", superheroe.power)

        intent.putExtra("superHeroe", superheroe)

        // Añadir objeto bitmap al intent
        intent.putExtra("foto_heroe", heroImage.drawable.toBitmap())

        // Iniciar la actividad
        startActivity(intent)

    }
}
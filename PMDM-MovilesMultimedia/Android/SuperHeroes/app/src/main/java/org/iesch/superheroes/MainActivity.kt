package org.iesch.superheroes

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.superheroes.databinding.ActivityMainBinding
import org.iesch.superheroes.model.SuperHeroe
import java.io.File

class MainActivity : AppCompatActivity() {

    // 1 - Creamos la variable lateinit, pues la vamos a inicializar luego
    private lateinit var binding: ActivityMainBinding

    // Variable para manejar el resultado de haber hecho una foto
    private lateinit var heroImage: ImageView
    private  var heroBitMap: Bitmap? = null

    // Hay que cambiar takePicturesPreview por takePictures

    private var picturepath = ""
    private val getContent = registerForActivityResult(ActivityResultContracts.TakePicture()) {

        // Nos devolverá un booleano, si la foto es exitosa o no
        success ->
            if (success && picturepath.isNotEmpty()) {

                heroBitMap = BitmapFactory.decodeFile(picturepath)
                // Mostramos la imagen en el cuadradito
                heroImage.setImageBitmap(heroBitMap)

            }

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
        val imageFile = crearImagenFile()

        // Ya tenemos el file, ahora necesitamos la URL
        // Será a través del FileProvider, y lo que hace es compartir el File con otras aplicaciones de forma segura
        val url = FileProvider.getUriForFile(this, "${applicationContext.packageName}.provider", imageFile)
        getContent.launch(url)

    }

    // Esta función crea un objeto de tipo file y de eso recuperamos la URL
    private fun crearImagenFile() : File {

        val fileName = "superhero_image"
        // Esto será el directorio donde vamos a almacenar la imagen. Por defecto es DIRECTORY_PICTURES
        val fileDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        // Creamos nuestro file, aqui nos pide el nombre, el formato y el directorio
        val imageFile = File.createTempFile(fileName, ".jpg", fileDirectory)
        picturepath = imageFile.absolutePath
        return imageFile

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
        intent.putExtra("path_heroe", picturepath)

        // Iniciar la actividad
        startActivity(intent)

    }
}
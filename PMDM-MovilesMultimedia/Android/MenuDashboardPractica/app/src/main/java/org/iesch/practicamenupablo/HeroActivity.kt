package org.iesch.practicamenupablo

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.practicamenupablo.databinding.ActivityHeroBinding
import java.io.File

class HeroActivity : AppCompatActivity() {

    // 1 - Creo la variable lateinit para inicializarla luego
    private lateinit var binding: ActivityHeroBinding

    // Vreo la variable que va a manegar el resultado de hacer la foto
    private lateinit var  heroImage: ImageView
    private var heroBitmap: Bitmap? = null



    // Para hacer la foto y recoger la foto de otro lado
    private var picturePath = ""
    private val getContent = registerForActivityResult(ActivityResultContracts.TakePicture()){
        // Esto devuelve un objeto bigMap si es el preview, en este caso TakePicture usa picturePath porque así no tiene solo un MB y devuelve un booleano
            success ->
        if (success && picturePath.isNotEmpty()){
            // Podemos transformar la imagen del directorio en un bitmap
            heroBitmap = BitmapFactory.decodeFile(picturePath)
            // Pongo la imagen
            heroImage.setImageBitmap(heroBitmap)
        }
    }

    fun abrirCamara(){
        // Aquí creo un path temporal para guardar la imagen
        val imageFile = crearImagenFile()

        // Ahora ya tenemos file pero necesitamos la uri
        // Se usa FileProvider que comparte el file con otras aplicaciones de forma segura
        val uri = FileProvider.getUriForFile(this, "${applicationContext.packageName}.provider", imageFile)
        getContent.launch(uri)
    }

    private fun crearImagenFile() : File{
        // esta función crea un file y sacamos la url de este
        val fileName = "superhero_image"
        // Esto es el directorio donde se van a guardar las imagenes, por defecto es DIRECTORY_PICTURES
        val fileDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        // Creo el file
        val imageFile = File.createTempFile(fileName, ".jpg", fileDirectory)
        // Ahora se guarda la ruta en la variable global
        picturePath = imageFile.absolutePath
        return imageFile
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Hago que la imagen sea clickable
        heroImage = binding.heroImage
        binding.heroImage.setOnClickListener {
            abrirCamara()
        }

        // Añado un trigger para el boton
        binding.Guardar.setOnClickListener {
            // Obtengo los valores al hacer click
            // El .toString es para asegurar que sean strings
            val nombreSuperHeroe = binding.heroNameEdit.text.toString()
            val alterego = binding.alterEgoEdit.text.toString()
            val bio = binding.editTextText.text.toString()
            val power = binding.power.rating
            irADetailActivity(Superheroe(nombreSuperHeroe, alterego, bio, power))
        }
    }

//    fun abrirCamaraClick() {
//        // Esta finción abre la camara llamado al getcontent launch
//        getContent.launch(null)
//    }

    fun irADetailActivity(superheroe: Superheroe) {
        // Creo el intent que me va a permitir moverme entre actividades
        val intent = Intent(this, DetailActivity::class.java)

        // Añado todos los campos al intent para mandarlos al DetailActivity
        //intent.putExtra("nombreSuperHeroe", nombreSuperHeroe)
        //intent.putExtra("alterego", alterego)
        //intent.putExtra("bio", bio)
        //intent.putExtra("power", power)

        intent.putExtra("superHeroe", superheroe)
        // Paso la foto con intent
        intent.putExtra("path_heroe", picturePath)
        // La ejecuto
        startActivity(intent)
    }
}
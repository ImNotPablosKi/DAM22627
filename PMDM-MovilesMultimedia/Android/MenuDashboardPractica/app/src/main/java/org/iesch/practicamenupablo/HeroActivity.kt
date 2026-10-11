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

    private lateinit var binding: ActivityHeroBinding

    private lateinit var  heroImage: ImageView
    private var heroBitmap: Bitmap? = null

    private var picturePath = ""
    private val getContent = registerForActivityResult(ActivityResultContracts.TakePicture()){

        success ->
        if (success && picturePath.isNotEmpty()){
            heroBitmap = BitmapFactory.decodeFile(picturePath)
            heroImage.setImageBitmap(heroBitmap)
        }
    }

    fun abrirCamara(){

        // Path temporal para guardar la imagen
        val imageFile = crearImagenFile()

        val uri = FileProvider.getUriForFile(this, "${applicationContext.packageName}.provider", imageFile)
        getContent.launch(uri)
    }

    private fun crearImagenFile() : File{

        val fileName = "superhero_image"

        val fileDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES)

        val imageFile = File.createTempFile(fileName, ".jpg", fileDirectory)

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

        heroImage = binding.heroImage
        binding.heroImage.setOnClickListener {
            abrirCamara()
        }

        // Añado un trigger para el boton
        binding.Guardar.setOnClickListener {

            val nombreSuperHeroe = binding.heroNameEdit.text.toString()
            val alterego = binding.alterEgoEdit.text.toString()
            val bio = binding.editTextText.text.toString()
            val power = binding.power.rating
            irADetailActivity(Superheroe(nombreSuperHeroe, alterego, bio, power))
        }
    }

    fun irADetailActivity(superheroe: Superheroe) {

        val intent = Intent(this, DetailActivity::class.java)

        intent.putExtra("superHeroe", superheroe)

        intent.putExtra("path_heroe", picturePath)

        // start obvio
        startActivity(intent)
    }
}
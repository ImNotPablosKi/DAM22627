package org.iesch.superheroes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.superheroes.databinding.ActivityMainBinding
import org.iesch.superheroes.model.SuperHeroe

class MainActivity : AppCompatActivity() {

    // 1 - Creamos la variable lateinit, pues la vamos a inicializar luego
    private lateinit var binding: ActivityMainBinding

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

        // A partir de aquí introduzco el código necesario
        val botonGuardar = findViewById<Button>(R.id.botonGuardar)

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

    fun irADetailActivity(superheroe: SuperHeroe) {

        // Creamos el objeto Intent
        val intent = Intent(this, DetailActivity::class.java)

        // Añadimos todos los campos con el método putExtra
        // De esta manera, todos estos datos se llevarán a la detailActivity
        intent.putExtra("superHeroName", superheroe.nombre)
        intent.putExtra("alterEgo", superheroe.alterEgo)
        intent.putExtra("bio", superheroe.bio)
        intent.putExtra("power", superheroe.power)

        // intent.putExtra("superHeroe", superherºoe)

        // Iniciar la actividad
        startActivity(intent)

    }
}
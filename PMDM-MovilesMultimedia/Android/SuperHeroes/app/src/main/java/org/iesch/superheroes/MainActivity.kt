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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // A partir de aquí introduzco el código necesario
        val botonGuardar = findViewById<Button>(R.id.botonGuardar)

        botonGuardar.setOnClickListener {

            // Obtenemos los valores al momento de hacer click
            val superHeroName = findViewById<EditText>(R.id.heroNameEdit).text.toString()
            val alterEgo = findViewById<EditText>(R.id.heroNameEdit2).text.toString()
            val bio = findViewById<EditText>(R.id.editTextText3).text.toString()
            val power = findViewById<RatingBar>(R.id.power).rating

            // Qué quiero hacer cuando pulso el botón guardar
            irADetailActivity(superHeroName, alterEgo, bio, power)

        }
    }

    fun irADetailActivity(superHeroName: String, alterEgo: String, bio: String, power: Float) {

        // Creamos el objeto Intent
        val intent = Intent(this, DetailActivity::class.java)

        // Añadimos todos los campos con el método putExtra
        // De esta manera, todos estos datos se llevarán a la detailActivity
        intent.putExtra("superHeroName", superHeroName)
        intent.putExtra("alterEgo", alterEgo)
        intent.putExtra("bio", bio)
        intent.putExtra("power", power)

        // Iniciar la actividad
        startActivity(intent)

    }
}
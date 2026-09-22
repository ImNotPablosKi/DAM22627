package org.iesch.superheroes

import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Último paso: Recibimos los datos del MainActivity que hemos enviado
        val bundle = intent.extras!!
        val superHeroName = bundle.getString("superHeroName") ?: "No hay nombre." // Controlar nulos
        val alterEgo = bundle.getString("alterEgo") ?: "No hay un alter ego disponible."
        val bio = bundle.getString("bio") ?: "No hay una biografía disponible."
        val power = bundle.getFloat("power")

        // Rellenamos los campos con los valores recibidos
        findViewById<TextView>(R.id.heroName_tv).text = superHeroName
        findViewById<TextView>(R.id.alterEgoResult).text = alterEgo
        findViewById<TextView>(R.id.bioResult).text = bio
        findViewById<RatingBar>(R.id.ratingBar2).rating = power

    }
}
package org.iesch.edadcanina

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Aqui la pantalla está creada
        // 1 - Tomamos el control de todos los elementos de la parte de la UI

        val resultText = findViewById<TextView>(R.id.texto_respuesta)
        val calculateButton = findViewById<Button>(R.id.boton_calcular)
        val ageEdit = findViewById<EditText>(R.id.edit_edad)

        // 2 - Los botones tienen la propiedad setOnClickListener al pulsarlo
        calculateButton.setOnClickListener {

            var edadInt = 0

            // Aqui metemos el codigo de lo que queremos hacer cuando pulsamos el boton de calcular
            val edadString = ageEdit.text.toString()

            if (edadString.isEmpty()) {
                // Mostramos un mensaje de tipo toast
                Toast.makeText(this, "Imbécil.", Toast.LENGTH_LONG).show()
            } else {

               edadInt = edadString.toInt() * 7
               // Necesitamos pasar el valor a entero
               resultText.text = getString(R.string.resultado_texto, edadInt)

            }
        }

    }
}
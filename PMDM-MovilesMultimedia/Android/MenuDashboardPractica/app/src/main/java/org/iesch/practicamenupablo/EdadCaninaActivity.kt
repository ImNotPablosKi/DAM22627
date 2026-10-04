package org.iesch.practicamenupablo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EdadCaninaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edad_canina)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Aquí la pantalla está creada
        // Aquí se configuran los elementos de la interfaz
        // Primero asignamos los elementos a variables

        val textoResultado = findViewById<TextView>(R.id.texto_resp)
        val botonCalcular = findViewById<Button>(R.id.boton_calcular)
        val edadEdit = findViewById<EditText>(R.id.edit_edad)

        // Añadimos funcionalidades a los elementos

        // Para cuando clicke en el botón
        botonCalcular.setOnClickListener {

            // El toString().toInt() para evitar fallos
            val edad = edadEdit.text.toString()
            if (edad.isEmpty()){
                Toast.makeText(this, R.string.error_vacio, Toast.LENGTH_LONG).show()
            } else {
                textoResultado.text = getString(R.string.texto_respuesta, edad.toInt() * 7)
            }
        }



    }
}
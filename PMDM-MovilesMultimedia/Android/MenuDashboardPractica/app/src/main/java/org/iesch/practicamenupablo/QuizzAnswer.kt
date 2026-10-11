package org.iesch.practicamenupablo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import org.iesch.practicamenupablo.databinding.ActivityQuizzAnswerBinding

class QuizzAnswer : AppCompatActivity() {

    private lateinit var binding: ActivityQuizzAnswerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityQuizzAnswerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var bundle = intent.extras!!

        binding.imagenAnswer.setImageResource(bundle.getInt("logoCorrespondiente"))
        binding.textoRespuestaAnswer.setText(bundle.getString("textoGrande"))
        binding.textoRespuestaAnswerExtra.setText(bundle.getString("textoPequeño"))


        if (bundle.getInt("numeroPregunta") == 3){
            binding.textoAnswerFinalizado.setText("¡Cuestionario Finalizado!")
            binding.buttonSiguienteAnswer.setText("Reiniciar Cuestionario")
            binding.numAciertos.setText("Has acertado: " + bundle.getInt("numeroAciertos") + " preguntas.")
        }


        binding.buttonSiguienteAnswer.setOnClickListener {

            var intent = Intent(this, Quizz::class.java)

            if (bundle.getInt("numeroPregunta") == 1){
                intent.putExtra("numeroPregunta",2)
                intent.putExtra("numeroAciertos", bundle.getInt("numeroAciertos"))
            }

            if (bundle.getInt("numeroPregunta") == 2){
                intent.putExtra("numeroPregunta",3)
                intent.putExtra("numeroAciertos", bundle.getInt("numeroAciertos"))
            }

            if (bundle.getInt("numeroPregunta") == 3){
                intent.putExtra("numeroPregunta",1)
                intent.putExtra("numeroAciertos", 0)
            }

            startActivity(intent)

        }

    }
}
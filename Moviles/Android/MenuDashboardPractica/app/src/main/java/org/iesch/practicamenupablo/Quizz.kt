package org.iesch.practicamenupablo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.iesch.practicamenupablo.databinding.ActivityQuizzBinding

class Quizz : AppCompatActivity() {

    private lateinit var binding: ActivityQuizzBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityQuizzBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var bundle = intent.extras


        var arrayProgressText = arrayOf("1/3", "2/3", "3/3")

        var arrayPreguntaActual = arrayOf(
            "Valor de Y?",
            "Valor de X?",
            "Valor de Z?"
        )
        var arrayPreguntaActualExtra = arrayOf(
            "10y = 70",
            "20x = 10",
            "30z = 150"
        )

        var arrayOpcion1 = arrayOf(
            "y = 7",
            "x = 1",
            "z = 15"
        )

        var arrayOpcion2 = arrayOf(
            "y = 70",
            "x = 0.5",
            "z = 5"
        )

        var arrayLogos = arrayOf(
           R.drawable.correcto,
            R.drawable.incorrecto
        )

        var arrayAnswerGrande = arrayOf(
            "¡Correcto!",
            "¡Incorrecto!"
        )

        var arrayAnswerPequeño = arrayOf(
            "Has elegido la respuesta correcta.",
            "Has elegido la respuesta incorrecta."
        )


        // Logica radioButton
        var preguntaActual = bundle?.getInt("numeroPregunta") ?: 1
        var opcionEscogida = 0

        if (preguntaActual == 1){
            // valores por defecto en todos los ifs
            binding.progressText.text = arrayProgressText[0]
            binding.barraProgreso.progress = 33
            binding.opcion1.text = arrayOpcion1[0]
            binding.opcion2.text = arrayOpcion2[0]
            binding.preguntaActual.text = arrayPreguntaActual[0]
            binding.preguntaActualExtra.text = arrayPreguntaActualExtra[0]
        }

        if (preguntaActual == 2){
            binding.progressText.text = arrayProgressText[1]
            binding.barraProgreso.progress = 66
            binding.opcion1.text = arrayOpcion1[1]
            binding.opcion2.text = arrayOpcion2[1]
            binding.preguntaActual.text = arrayPreguntaActual[1]
            binding.preguntaActualExtra.text = arrayPreguntaActualExtra[1]
        }

        if (preguntaActual == 3){
            binding.progressText.text = arrayProgressText[2]
            binding.barraProgreso.progress = 99
            binding.opcion1.text = arrayOpcion1[2]
            binding.opcion2.text = arrayOpcion2[2]
            binding.preguntaActual.text = arrayPreguntaActual[2]
            binding.preguntaActualExtra.text = arrayPreguntaActualExtra[2]
        }


        binding.radioGroup.setOnCheckedChangeListener { group, i ->

            when(i){
                binding.opcion1.id -> {
                    opcionEscogida = 1;
                }
                binding.opcion2.id -> {
                    opcionEscogida = 2;
                }
            }


        }

       var numeroAciertos = bundle?.getInt("numeroAciertos") ?: 0

        // Logica quizz
        var intentParaElQuizz = Intent(this, QuizzAnswer::class.java)
        binding.buttonSiguiente.setOnClickListener {

            if (preguntaActual == 1) {

                if (opcionEscogida == 0) {
                    Toast.makeText(this, "DEBES Seleccionar una opción", Toast.LENGTH_SHORT).show()

                } else {
                    if (opcionEscogida == 1) {

                        intentParaElQuizz.putExtra("logoCorrespondiente", arrayLogos[0])
                        intentParaElQuizz.putExtra("textoGrande", arrayAnswerGrande[0])
                        intentParaElQuizz.putExtra("textoPequeño", arrayAnswerPequeño[0])
                        intentParaElQuizz.putExtra("numeroPregunta", preguntaActual)
                        intentParaElQuizz.putExtra("numeroAciertos", numeroAciertos?.plus(1) ?: numeroAciertos)
                        startActivity(intentParaElQuizz)
                    }
                    if (opcionEscogida == 2) {

                        intentParaElQuizz.putExtra("logoCorrespondiente", arrayLogos[1])
                        intentParaElQuizz.putExtra("textoGrande", arrayAnswerGrande[1])
                        intentParaElQuizz.putExtra("textoPequeño", arrayAnswerPequeño[1])
                        intentParaElQuizz.putExtra("numeroAciertos", numeroAciertos)
                        intentParaElQuizz.putExtra("numeroPregunta", preguntaActual)
                        startActivity(intentParaElQuizz)
                    }
                }

            }

            if (preguntaActual == 2) {

                if (opcionEscogida == 0) {
                    Toast.makeText(this, "Porfavor Selecciona una opción", Toast.LENGTH_SHORT).show()

                } else {
                    if (opcionEscogida == 1) {

                        intentParaElQuizz.putExtra("logoCorrespondiente", arrayLogos[1])
                        intentParaElQuizz.putExtra("textoGrande", arrayAnswerGrande[1])
                        intentParaElQuizz.putExtra("textoPequeño", arrayAnswerPequeño[1])
                        intentParaElQuizz.putExtra("numeroAciertos", numeroAciertos)
                        intentParaElQuizz.putExtra("numeroPregunta", preguntaActual)
                        startActivity(intentParaElQuizz)
                    }
                    if (opcionEscogida == 2) {

                        intentParaElQuizz.putExtra("logoCorrespondiente", arrayLogos[0])
                        intentParaElQuizz.putExtra("textoGrande", arrayAnswerGrande[0])
                        intentParaElQuizz.putExtra("textoPequeño", arrayAnswerPequeño[0])
                        intentParaElQuizz.putExtra("numeroPregunta", preguntaActual)
                        intentParaElQuizz.putExtra("numeroAciertos", numeroAciertos?.plus(1) ?: numeroAciertos)
                        startActivity(intentParaElQuizz)
                    }
                }

            }

            if (preguntaActual == 3) {

                if (opcionEscogida == 0) {
                    Toast.makeText(this, "Porfavor Selecciona una opción", Toast.LENGTH_SHORT).show()

                } else {
                    if (opcionEscogida == 1) {

                        intentParaElQuizz.putExtra("logoCorrespondiente", arrayLogos[1])
                        intentParaElQuizz.putExtra("textoGrande", arrayAnswerGrande[1])
                        intentParaElQuizz.putExtra("textoPequeño", arrayAnswerPequeño[1])
                        intentParaElQuizz.putExtra("numeroAciertos", numeroAciertos)
                        intentParaElQuizz.putExtra("numeroPregunta", preguntaActual)
                        startActivity(intentParaElQuizz)
                    }
                    if (opcionEscogida == 2) {

                        intentParaElQuizz.putExtra("logoCorrespondiente", arrayLogos[0])
                        intentParaElQuizz.putExtra("textoGrande", arrayAnswerGrande[0])
                        intentParaElQuizz.putExtra("textoPequeño", arrayAnswerPequeño[0])
                        intentParaElQuizz.putExtra("numeroAciertos", numeroAciertos?.plus(1) ?: numeroAciertos)
                        intentParaElQuizz.putExtra("numeroPregunta", preguntaActual)
                        startActivity(intentParaElQuizz)
                    }
                }

            }


        }


    }




}
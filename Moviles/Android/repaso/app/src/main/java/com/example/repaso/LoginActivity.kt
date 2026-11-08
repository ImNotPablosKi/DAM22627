package com.example.repaso

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
<<<<<<< HEAD
=======
import android.util.Log
>>>>>>> c42824a (alea iacta est)
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.repaso.databinding.ActivityLoginBinding
import com.example.repaso.model.Datos

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Bitmap
        var foto : Bitmap? = null

        val getContent = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) {

            bitmap -> if (bitmap != null) {

                foto = bitmap
                binding.imagenFoto.setImageBitmap(bitmap)

            }

        }

        binding.imagenFoto.setOnClickListener {
            getContent.launch(null)
        }

        val datos : Datos = Datos(1, binding.editUsuario.text.toString(), "Genérico")

        binding.botonLogin.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("nombre", binding.editUsuario.text.toString().ifEmpty { "Anónimo" })
            intent.putExtra("foto", foto)
            intent.putExtra("dato", datos)

            if (binding.editPasswd.text.isEmpty()) {

<<<<<<< HEAD
                Toast.makeText(this, "DEBES introducir una contraseña ", Toast.LENGTH_LONG).show()
=======
                Toast.makeText(this, "Imbecil", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
>>>>>>> c42824a (alea iacta est)

            } else {

                startActivity(intent)

            }

        }

        Log.i("Log guapo", "Esto es un Log")
    }

    override fun onResume() {
        super.onResume()
        binding.editPasswd.text.clear()

        Log.i("resume", "Esto es el método onResume()")
    }
}
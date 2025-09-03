package com.example.flagquiz

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    lateinit var editTextNome: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editTextNome = findViewById<EditText>(R.id.editTextNome);
        val buttonAvancar = findViewById<Button>(R.id.buttonAvancar);

        buttonAvancar.isEnabled = false;
        editTextNome.addTextChangedListener { nomeUsuario -> buttonAvancar.isEnabled = !nomeUsuario.toString().isEmpty() }

    }

    fun telaQuiz(view: View) {
        editTextNome = findViewById<EditText>(R.id.editTextNome);
        NomeUsuario.getInstance().setDado(editTextNome.text.toString());

        val intent = Intent(this, TelaQuiz::class.java);

        startActivity(intent)
        finish()
    }
}
package com.example.flagquiz

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY

class TelaQuiz : AppCompatActivity() {

    val flags = listOf(
        R.drawable.flag_cairo,
        R.drawable.flag_india,
        R.drawable.flag_japao,
        R.drawable.flag_nepal,
        R.drawable.flag_brasil,
        R.drawable.flag_bangladesh,
        R.drawable.flag_colombia,
        R.drawable.flag_equador,
        R.drawable.flag_jamaica,
        R.drawable.flag_franca,
        R.drawable.flag_polonia,
        R.drawable.flag_vaticano
    )
    val nomesBandeiras = listOf(
        "cairo",
        "india",
        "japao",
        "nepal",
        "brasil",
        "bangladesh",
        "colombia",
        "equador",
        "jamaica",
        "franca",
        "polonia",
        "vaticano"
    )

    var numeroSeletor = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun novaImagem(view: View) {
        val imgFlag: ImageView = findViewById<ImageView>(R.id.imageView)

        numeroSeletor = (0..11).random()

        val randomFlag = flags.get(numeroSeletor)
        imgFlag.setImageResource(randomFlag)
    }

    fun acertarErrar(view: View){
        val certoErradoText: TextView = findViewById<TextView>(R.id.textViewCertoErrado)
        val editTextNomeBandeira: TextView = findViewById<EditText>(R.id.editTextNomeBandeira)
        val resposta = editTextNomeBandeira.toString().trim().lowercase()

        if (resposta == nomesBandeiras.get(numeroSeletor)){
            certoErradoText.setText("ACERTOU")
        } else {
            certoErradoText.setText("ERROU")
        }

        novaImagem(view)
    }
}


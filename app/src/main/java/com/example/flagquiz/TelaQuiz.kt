package com.example.flagquiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY

class TelaQuiz : AppCompatActivity() {

    val flags = listOf(
        R.drawable.flag_russia,
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
    val listaRespostas: ArrayList<String> = ArrayList()

    val bandeirasJaforam: ArrayList<Int> = ArrayList()
    val nomesBandeiras = listOf(
        "russia",
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
    var pontuacao = 0
    var jogadas = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imgFlag: ImageView = findViewById<ImageView>(R.id.imageView)

        numeroSeletor = (0..flags.size).random()

        val randomFlag = flags.get(numeroSeletor)
        imgFlag.setImageResource(randomFlag)


        val rodadaText: TextView = findViewById<TextView>(R.id.textViewRodada)
        rodadaText.setText("%d de 5".format(jogadas))

        bandeirasJaforam.add(numeroSeletor)

    }

    fun novaImagem(view: View) {
        val imgFlag: ImageView = findViewById<ImageView>(R.id.imageView)


            while (bandeirasJaforam.contains(numeroSeletor)) {
                numeroSeletor = (0..flags.size).random()
            }

            val randomFlag = flags.get(numeroSeletor)
            imgFlag.setImageResource(randomFlag)

    }

    fun acertarErrar(view: View) {
        val certoErradoText: TextView = findViewById<TextView>(R.id.textViewCertoErrado)
        val editTextNomeBandeira: TextView = findViewById<EditText>(R.id.editTextNomeBandeira)
        val resposta = editTextNomeBandeira.text.toString().lowercase().trim()

        // LÓGICA DE SE ACERTOU OU ERROU

        if (resposta == nomesBandeiras.get(numeroSeletor)) {
            Toast.makeText(this, "ACERTOU", Toast.LENGTH_SHORT).show()
            pontuacao += 20
            listaRespostas.add("Questão $jogadas: ACERTOU -- R: ${nomesBandeiras.get(numeroSeletor)}")
        } else {
            Toast.makeText(this, "ERROU", Toast.LENGTH_SHORT).show()
            listaRespostas.add("Questão $jogadas: ERROU -- Era: ${nomesBandeiras.get(numeroSeletor)}, você respondeu: ${resposta}")

        }

        // ADICIONAR QUE JÁ FOI
        bandeirasJaforam.add(numeroSeletor)

        // LÓGICA DE ENCERRAR OU IR PARA PRÓXIMA RODADA

        if (jogadas >= 5) {
            println("LOG PONTUACAO: $pontuacao")
            println("LOG LISTA: $listaRespostas")
            val intent = Intent(this, TelaResultado::class.java);
            intent.putExtra("pontuacao", pontuacao)
            intent.putExtra("listaRespostas", listaRespostas)
            startActivity(intent)
        } else {
            novaImagem(view)
            jogadas++
            val rodadaText: TextView = findViewById<TextView>(R.id.textViewRodada)
            rodadaText.setText("%d de 5".format(jogadas))
        }
    }
}



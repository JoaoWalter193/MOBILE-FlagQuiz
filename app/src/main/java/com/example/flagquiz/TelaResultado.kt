package com.example.flagquiz

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaResultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textViewNome = findViewById<TextView>(R.id.textViewNome);
        val textViewPontuacao = findViewById<TextView>(R.id.textViewPontuacao);
        val textViewLista = findViewById<TextView>(R.id.textViewLista);

        val dado: String? = NomeUsuario.getInstance().getDado();
        textViewNome.text = "Nome usuário: $dado"

        val bundle = intent.extras;
        if (bundle != null) {
            val pontuacaoRecebida = bundle.getInt("pontuacao");
            val listaRecebida = bundle.getStringArrayList("listaRespostas");
            println("LOG PONTUACAO1: $pontuacaoRecebida");
            println("LOG LISAA1: $listaRecebida");

            // A forma recomendada e mais eficiente
            val textoFormatado = listaRecebida?.joinToString(separator = "\n")
            textViewLista.text = "Respostas: \n$textoFormatado"

            textViewPontuacao.text = "Resultado: $pontuacaoRecebida";
        }
    }
}